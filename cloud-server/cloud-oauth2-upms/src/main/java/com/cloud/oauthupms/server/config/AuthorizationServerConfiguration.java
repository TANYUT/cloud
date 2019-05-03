package com.cloud.oauthupms.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * <p>
 *
 * </p>
 *
 * @Title AuthorizationServerConfiguration.java
 * @Package com.cloud.oauthupms.server.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/3 16:14
 */

@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    /**
     * <p>
     * Token 存储 Bean
     * </p>
     *
     * @return: org.springframework.security.oauth2.provider.token.TokenStore
     * @Author: au .T
     * @Date: 2019/5/3 13:17
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);//数据库存储Token
        //return new RedisTokenStore(redisConnectionFactory);//Redis存储Token
        //return new InMemoryTokenStore();//内存存储Token
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 配置客户端详情服务
     * 客户端详细信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

//        clients.withClientDetails(jdbcClientDetails());
//        jdbcClientDetails().loadClientByClientId()
        clients.inMemory()
                .withClient("upms")//用于标识用户ID
                .authorizedGrantTypes("authorization_code", "client_credentials", "password", "implicit", "refresh_token")//授权方式
                .scopes("upmsApp")//授权范围
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("upms"))
                .and()
                .withClient("webUi")
                .authorizedGrantTypes("authorization_code", "client_credentials", "password", "implicit", "refresh_token")
                .scopes("webUiApp")
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("webUi"))
        ;

    }


    /**
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        /* 配置token获取合验证时的策略 */
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }

    /**
     *
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
        // 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore()).userDetailsService(userDetailsService);
    }

}
