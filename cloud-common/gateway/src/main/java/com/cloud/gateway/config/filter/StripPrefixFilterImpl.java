//package com.cloud.gateway.config.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
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
// * @Title StripPrefixFilterImpl.java
// * @Package com.cloud.gateway.config
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/1 19:15
// */
//@Configuration
//@Slf4j
//@Component
//public class StripPrefixFilterImpl extends StripPrefixGatewayFilterFactory implements Ordered {
//    public static final String FROM = "from";
//
//    /**
//     * <p>
//     * 重写path    StripPrefix(剥离前缀)过滤器
//     * </p>
//     *
//     * @params: [config]
//     * @return: org.springframework.cloud.gateway.filter.GatewayFilter
//     * @Author: au .T
//     * @Date: 2019/4/1 19:18
//     */
//    @Override
//    public GatewayFilter apply(Config config) {
//        System.err.println("进入剥离前缀");
//        return (exchange, chain) -> {
//            //         1. 清洗请求头中from 参数
//            ServerHttpRequest request = exchange.getRequest().mutate()
////                    .headers(httpHeaders -> httpHeaders.remove(FROM))
//                    .build();
//
//            // 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
//            addOriginalRequestUrl(exchange, request.getURI());
//            String path = request.getURI().getRawPath();
//            String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
//                    .skip(1L).collect(Collectors.joining("/"));
//            ServerHttpRequest newRequest = request.mutate()
//                    .path(newPath).build();
//            exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
//
//            return chain.filter(exchange.mutate()
//                    .request(newRequest.mutate().build()).build());
//        };
//    }
//
//    @Override
//    public int getOrder() {
//        return -999999999;
//    }
//}
