package com.cloud.upms.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * <p>
 *
 * </p>
 *
 * @Title WebClientBuilder.java
 * @Package com.cloud.oauth2.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/28 19:41
 */
public class WebClientBuilder {
    @Bean
    @LoadBalanced
    public WebClient.Builder webBuilder() {
        return WebClient.builder();
    }
}
