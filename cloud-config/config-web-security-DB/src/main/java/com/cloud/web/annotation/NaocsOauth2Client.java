package com.cloud.web.annotation;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * nacos 客户端注册发现   oauth2  客户端注解  另加一个刷新基本配置的注解
 * </p>
 *
 * @Title ClientConfig.java
 * @Package com.cloud.web.annotation
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/2 18:19
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RefreshScope
@EnableDiscoveryClient
@EnableResourceServer
public @interface NaocsOauth2Client {
}
