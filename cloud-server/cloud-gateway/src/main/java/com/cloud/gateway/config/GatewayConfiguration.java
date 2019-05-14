//package com.cloud.gateway.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title: GatewayConfiguration.java
// * @Package: com.cloud.gateway.config
// * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
// * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date: 2019/5/12 17:32
// */
//
//@Configuration
//@EnableResourceServer
//public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        http.authorizeRequests().
//                antMatchers("/oauth/**").
//                permitAll().
//                antMatchers("/**").
//                authenticated();
//    }
//}
