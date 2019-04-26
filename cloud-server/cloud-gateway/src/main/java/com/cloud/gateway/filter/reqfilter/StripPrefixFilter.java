package com.cloud.gateway.filter.reqfilter;

import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

/**
 * <p>
 * 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
 * </p>
 *
 * @Title StripPrefixFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/7 16:21
 */
@Component
@Configuration
public class StripPrefixFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //剥离前缀
        ServerHttpRequest request = exchange.getRequest().mutate()
                .headers(httpHeaders -> httpHeaders.remove("from")) //清洗请求头中from 参数
                .build();
        addOriginalRequestUrl(exchange, request.getURI());
        String path = request.getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
                .skip(1L).collect(Collectors.joining("/"));
        ServerHttpRequest newRequest = request.mutate()
                .path(newPath).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
        return chain.filter(exchange.mutate()
//                .response(new ServerHttpResponseDecorator(exchange.getResponse()) {
//                    @Override
//                    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                        ServerHttpResponse res = exchange.getResponse();
//                        System.err.println(res.getStatusCode().value());
//                        return res.writeWith(body);
//                    }
//                })
                .request(newRequest.mutate().build()).build()).then(Mono.fromRunnable(() -> {
            System.err.println("test");

        }));
    }

    @Override
    public int getOrder() {
        return -999999999;
    }


}
