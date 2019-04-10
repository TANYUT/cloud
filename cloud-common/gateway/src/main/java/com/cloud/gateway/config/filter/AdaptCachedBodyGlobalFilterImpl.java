//package com.cloud.gateway.config.filter;
//
//import cn.hutool.json.JSONUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.AdaptCachedBodyGlobalFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title AdaptCachedBodyGlobalFilterImpl.java
// * @Package com.cloud.gateway.config.filter
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/1 22:55
// */
//@Configuration
//@Slf4j
//@Component
//public class AdaptCachedBodyGlobalFilterImpl extends AdaptCachedBodyGlobalFilter {
//    @Override
//    public int getOrder() {
//      return   1;
//    }
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.err.println(this.getOrder());
//        System.err.println("AdaptCachedBodyGlobalFilterImpl");
////        Flux<DataBuffer> body = exchange.getAttributeOrDefault(CACHED_REQUEST_BODY_KEY,
////                null);
////        ServerHttpRequest request = exchange.getRequest();
////        String uri = request.getURI().toString();
////        System.out.println(" uri : " + uri);
////        HttpHeaders head = request.getHeaders();
////        String json = JSONUtil.parseObj(head).toString();
////        System.err.println(JSONUtil.formatJsonStr(json));
////        if (body != null) {
////            ServerHttpRequestDecorator decorator = new ServerHttpRequestDecorator(
////                    exchange.getRequest()) {
////                @Override
////                public Flux<DataBuffer> getBody() {
////                    return body;
////                }
////            };
////            exchange.getAttributes().remove(CACHED_REQUEST_BODY_KEY);
////            return chain.filter(exchange.mutate().request(decorator).build());
////        }
//
//
//        return chain.filter(exchange);
//    }
//
//}
