package com.cloud.gateway.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.gateway.constant.CodeEnum;
import com.cloud.gateway.constant.GatewayConstant;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.cloud.gateway.support.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.DefaultClientResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.client.reactive.ClientHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

/**
 * <p>
 *
 * </p>
 *
 * @Title GatewayFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/6 14:24
 */
//@Configuration
//@Slf4j
//@Component
public class GatewayFilter {


    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {

            //判断请求的客户端 是不是可以请求的客户客户端
            ServerHttpRequest request = exchange.getRequest().mutate()
                    //  .headers(httpHeaders -> httpHeaders.remove(FROM)) //清洗请求头中from 参数
                    .build();
//            if (!this.head(request)) {
//                return Mono.error(new Exception("非法访问"));
//            }
            String webName = request.getHeaders().getFirst("webName");
            System.err.println(webName);
            System.err.println("1---pre");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.err.println("6---post");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {

            System.err.println("2---pre");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.err.println("5---post");
            }));
        };
    }


    /**
     * <p>
     * 判断请求头
     * </p>
     *
     * @params: [request]
     * @return: boolean
     * @Author: au .T
     * @Date: 2019/4/6 17:21
     */
    private boolean head(ServerHttpRequest req) {
        HttpHeaders head = req.getHeaders();
        //如果已近授权  且不非法
        boolean flag = head.containsKey(HttpHeaders.AUTHORIZATION)
                && head.getFirst(HttpHeaders.AUTHORIZATION) != null;
        if (flag) {
            return Boolean.TRUE;
        } else {
            //判断是不是可以访问后台的UI项目
            boolean web = head.containsKey(GatewayConstant.WEN_HEAD);
            if (web) {
                String webPsw = head.getFirst(GatewayConstant.WEN_HEAD);
                String s[] = webPsw.split("-");
                flag = GatewayConstant.WEB_HTNL.equals(s[0]) && GatewayConstant.WEB_HTML_PAW.equals(s[1]);
                if (flag) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }


}