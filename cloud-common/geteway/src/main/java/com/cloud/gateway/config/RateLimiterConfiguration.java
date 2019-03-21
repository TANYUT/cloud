package com.cloud.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @Title RateLimiterConfiguration.java
 * @Package com.cloud.gateway.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 17:25
 */
@Configuration
public class RateLimiterConfiguration {
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}

