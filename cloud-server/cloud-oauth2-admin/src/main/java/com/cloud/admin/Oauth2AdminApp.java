package com.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <p>
 * https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2login-sample-initial-setup
 * </p>
 *Unauthorized
 * @Title: Oauth2AdminApp.java
 * @Package: com.cloud.admin
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 17:58
 */
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class Oauth2AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AdminApp.class, args);
    }
}
