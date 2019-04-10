package com.cloud.gateway.config.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @Title KeyResolverFilter.java
 * @Package com.cloud.gateway.config.resolver
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/6 13:16
 */
@Component
public class KeyResolverFilter {
    /**
     * 客户端IP限流
     *
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @Author: au .T
     * @Date: 2019/4/6 13:11
     */
    @Bean("ipKeyResolver")
    KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
    /**
     * 自定义头部限流
     *
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @Author: au .T
     * @Date: 2019/4/6 13:06
     */
//    @Bean("headUserKeyResolver")
//    KeyResolver headUserKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("user"));
//    }
    /**
     * 查询参数限流  查询参数 为 userId
     *
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @Author: au .T
     * @Date: 2019/4/6 13:08
     */
//    @Bean("paramsUserIdKeyResolver")
//    KeyResolver paramsUserIdKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
//    }


    /**
     * 请求URL 限流
     *
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @Author: au .T
     * @Date: 2019/4/6 13:12
     */
//    @Bean("urlKeyResolver")
//    KeyResolver urlKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
//    }

}
