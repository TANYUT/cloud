//package com.cloud.gateway.config.filter;
//
//import cn.hutool.core.util.StrUtil;
//import cn.hutool.json.JSONUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.cloud.gateway.event.PredicateArgsEvent;
//import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
//import org.springframework.cloud.gateway.event.WeightDefinedEvent;
//import org.springframework.cloud.gateway.filter.WeightCalculatorWebFilter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.support.ConfigurationUtils;
//import org.springframework.cloud.gateway.support.WeightConfig;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.style.ToStringCreator;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.Validator;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title WeightCalculatorWebFilterImpl.java
// * @Package com.cloud.gateway.config.filter
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/1 22:35
// */
//
//@Configuration
//@Slf4j
//@Component
//public class WeightCalculatorWebFilterImpl extends WeightCalculatorWebFilter {
//
//
//    public WeightCalculatorWebFilterImpl(Validator validator, ObjectProvider<RouteLocator> routeLocator) {
//        super(validator, routeLocator);
//    }
//
//    @Override
//    public int getOrder() {
//        return -1000;
//    }
//
//    /* for testing */
//    static Map<String, String> getWeights(ServerWebExchange exchange) {
//        Map<String, String> weights = exchange.getAttribute(WEIGHT_ATTR);
//        if (weights == null) {
//            weights = new ConcurrentHashMap<>();
//            exchange.getAttributes().put(WEIGHT_ATTR, weights);
//        }
//        return weights;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        String userId = exchange.getRequest().getHeaders().getFirst("Authorization");
//        if(StrUtil.isBlank(userId)){
////            return ;
//        }
//        System.err.println(userId);
//        System.err.println(getOrder());
//        System.err.println("WeightCalculatorWebFilterImpl");
//        if (1 == 1) {
//        }
////        Map<String, String> weights =  getWeights(exchange);
////        ServerHttpRequest request = exchange.getRequest();
////        String uri = request.getURI().toString();
////        System.out.println(" uri : " + uri);
////        HttpHeaders head = request.getHeaders();
////        String json = JSONUtil.parseObj(head).toString();
////        System.err.println(JSONUtil.formatJsonStr(json));
//////
////        if (log.isTraceEnabled()) {
////            log.trace("Weights attr: " + weights);
////        }
//        // 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
//        //         1. 清洗请求头中from 参数
//        ServerHttpRequest request = exchange.getRequest().mutate()
////                    .headers(httpHeaders -> httpHeaders.remove(FROM))
//                .build();
//
//        // 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
//        addOriginalRequestUrl(exchange, request.getURI());
//        String path = request.getURI().getRawPath();
//        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
//                .skip(1L).collect(Collectors.joining("/"));
//        ServerHttpRequest newRequest = request.mutate()
//                .path(newPath).build();
//        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
//        return chain.filter(exchange);
//    }
//
//}
