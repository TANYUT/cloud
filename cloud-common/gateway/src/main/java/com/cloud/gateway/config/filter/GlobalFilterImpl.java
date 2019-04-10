//package com.cloud.gateway.config.filter;
//
//import cn.hutool.json.JSONUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.json.simple.JSONArray;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.support.NotFoundException;
//import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.net.URI;
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
// * @Title GlobalFilterImpl.java
// * @Package com.cloud.gateway.config
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/3/31 20:13
// */
//@Configuration
//@Slf4j
//@Component
//public class GlobalFilterImpl implements GlobalFilter, Ordered {
//
//
//    //执行逻辑
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.err.println(this.getOrder());
//        System.err.println("GlobalFilterImpl");
//        ServerHttpRequest request = exchange.getRequest();
//        String uri = request.getURI().toString();
//        System.out.println(" uri : " + uri);
////        HttpHeaders head = request.getHeaders();
////        String json = JSONUtil.parseObj(head).toString();
////        System.err.println(JSONUtil.formatJsonStr(json));
//        //         1. 清洗请求头中from 参数
////        ServerHttpRequest request = exchange.getRequest().mutate()
////                    .headers(httpHeaders -> httpHeaders.remove(FROM))
////                .build();
//
//        // 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
//        addOriginalRequestUrl(exchange, request.getURI());
//        System.err.println("开始剥离");
//        String path = request.getURI().getRawPath();
//        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
//                .skip(1L).collect(Collectors.joining("/"));
//        ServerHttpRequest newRequest = request.mutate()
//                .path(newPath).build();
//        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
//        System.err.println(newPath.toString());
//        System.err.println("剥离结束");
//
//        return chain.filter(exchange.mutate()
//                .request(newRequest.mutate().build()).build());
//
////        return chain.filter(exchange);
//    }
//
//    //执行顺序
//    @Override
//    public int getOrder() {
//        return -9999999;
//    }
//}
