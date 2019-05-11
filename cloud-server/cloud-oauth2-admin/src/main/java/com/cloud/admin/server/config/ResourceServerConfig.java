package com.cloud.admin.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * <p>
 * {@link org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter}
 * 用于保护oauth要开放的资源，同时主要作用于client端以及token的认证
 * </p>
 *
 * @Title: ResourceServerConfig.java
 * @Package: com.cloud.admin.server.config
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 12:21
 */
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()

                .antMatchers("/**").authenticated();
    }
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .pathMatchers("/login").permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic().and()
                .formLogin()
                .loginPage("/login");
        return http.build();
    }
}
