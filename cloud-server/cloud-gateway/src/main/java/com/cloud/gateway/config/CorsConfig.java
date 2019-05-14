//package com.cloud.gateway.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
//import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
//import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.cors.reactive.CorsUtils;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
///**
// * <p>
// * 跨域
// * </p>
// *
// * @Title: CorsConfig.java
// * @Package: com.cloud.gateway.config
// * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date: 2019/5/8 11:24
// */
//@Configuration
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CorsConfig {
//    private static final String ALL = "*";
//    private static final String MAX_AGE = "18000L";
//
//    @Bean
//    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient,
//                                                                        DiscoveryLocatorProperties properties) {
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
//    }
//
//    @Bean
//    public ServerCodecConfigurer serverCodecConfigurer() {
//        return new DefaultServerCodecConfigurer();
//    }
//
//    @Bean
//    public WebFilter corsFilter() {
//        return (ServerWebExchange ctx, WebFilterChain chain) -> {
//            ServerHttpRequest request = ctx.getRequest();
//            if (!CorsUtils.isCorsRequest(request)) {
//                return chain.filter(ctx);
//            }
//            HttpHeaders requestHeaders = request.getHeaders();
//            ServerHttpResponse response = ctx.getResponse();
//            HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
//            HttpHeaders headers = response.getHeaders();
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
//            headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
//            if (requestMethod != null) {
//                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
//            }
//            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALL);
//            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
//            if (request.getMethod() == HttpMethod.OPTIONS) {
//                response.setStatusCode(HttpStatus.OK);
//                return Mono.empty();
//            }
//            return chain.filter(ctx);
//        };
//    }
//
//}
