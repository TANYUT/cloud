package com.cloud.admin.sever.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;

import java.util.Arrays;

/**
 * <p>
 * 客户端不需要持久化令牌，但每次重新启动客户端应用程序时，
 * 用户都不需要批准新的令牌授权。
 * ClientTokenServices接口定义为特定用户持久保存OAuth 2.0令牌所必需的操作。
 * 提供了一个JDBC实现，但是如果您希望实现自己的服务来在持久性数据库中存储访问令牌和关联的身份验证实例，
 * 则可以使用它。如果要使用此功能，则需要为OAuth2RestTemplate提供专门配置的TokenProvider
 *
 * </p>
 *
 * @Title: ClientOauth.java
 * @Package: com.cloud.admin.sever.config
 * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/9 20:47
 */
public class ClientOauthSession {
//    @Bean
//    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
//    public OAuth2RestOperations restTemplate() {
//        OAuth2RestTemplate template = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(accessTokenRequest));
//        AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(new AuthorizationCodeAccessTokenProvider()));
//        provider.setClientTokenServices(clientTokenServices());
//        return template;
//    }

}
