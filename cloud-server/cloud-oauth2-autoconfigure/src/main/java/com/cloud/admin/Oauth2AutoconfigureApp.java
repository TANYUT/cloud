package com.cloud.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 客户端不需要持久化令牌，但每次重新启动客户端应用程序时，用户都不需要批准新的令牌授权。 ClientTokenServices接口定义为特定用户持久保存OAuth 2.0令牌所必需的操作。提供了一个JDBC实现，但是如果您希望实现自己的服务来在持久性数据库中存储访问令牌和关联的身份验证实例，则可以使用它。如果要使用此功能，则需要为OAuth2RestTemplate提供专门配置的TokenProvider，例如
 * https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2login-sample-initial-setup
 * </p>
 * Unauthorized
 *
 * @Title: Oauth2AutoconfigureApp.java
 * @Package: com.cloud.admin
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 17:58
 */
@SpringBootApplication
@RefreshScope
@EnableAuthorizationServer
@EnableDiscoveryClient
public class Oauth2AutoconfigureApp {
    public static void main(String[] args) {
//        new SpringApplicationBuilder()
        new SpringApplicationBuilder(Oauth2AutoconfigureApp.class).run(args);
    }

    @RestController
    public class WebAction {
        @GetMapping("getUser")
        public Authentication getUser(Authentication auth) {
            System.err.println(auth);
            return auth;
        }
    }
}
