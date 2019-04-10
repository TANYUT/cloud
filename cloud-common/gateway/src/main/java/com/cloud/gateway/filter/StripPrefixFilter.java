package com.cloud.gateway.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.gateway.constant.CodeEnum;
import com.cloud.gateway.filter.serverfilter.ResBodyConfig;
import com.cloud.gateway.filter.serverfilter.ResponseAdapter;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.cloud.gateway.support.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.DefaultClientResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.nio.charset.Charset;
import java.util.*;
import java.util.function.BiFunction;
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

    private Object JSONObject;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.err.println("stripPrefix");
        //剥离前缀
        ServerHttpRequest request = exchange.getRequest().mutate()
                //  .headers(httpHeaders -> httpHeaders.remove("from")) //清洗请求头中from 参数
                .build();
        addOriginalRequestUrl(exchange, request.getURI());
        String path = request.getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
                .skip(1L).collect(Collectors.joining("/"));
        ServerHttpRequest newRequest = request.mutate()
                .path(newPath).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
        return chain.filter(exchange.mutate()
                .response(new ServerHttpResponseDecorator(exchange.getResponse()) {
                    @Override
                    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                        ServerHttpResponse res = exchange.getResponse();
                        System.err.println(res.getStatusCode().value());
                        if (true) {
                            JSONObject json = JSONUtil.createObj();
                            json.put("status", res.getStatusCode().value());
                            json.put("msg", res.getStatusCode().getReasonPhrase());
                            json.put("body", CodeEnum.resolve(res.getStatusCode().value()));
                            Mono<JSONObject> mono = Mono.just(json);

//                            Mono.just(json).and();
                            return Mono.error(new Throwable(""));
                        }
                        return res.writeWith(body);
                    }
                })
                .request(newRequest.mutate().build()).build()).then(Mono.fromRunnable(() -> {
            System.err.println("test");

        }));
    }

    @Override
    public int getOrder() {
        return -999999999;
    }


}
