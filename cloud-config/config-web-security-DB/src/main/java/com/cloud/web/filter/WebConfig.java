package com.cloud.web.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * <p>
 *
 * </p>
 *
 * @Title WebConfig.java
 * @Package com.cloud.web.filter
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/1 16:07metaDataSourceAdvisor
 */

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) {
        // 现在将所有端点暴露出来
        web.ignoring()
                .antMatchers("/**")
                .antMatchers("/oauth/check_token")
                .antMatchers("/oauth/token");
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                // 在内存中创建用户并为密码加密
                .withUser("user").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456")).roles("ADMIN");

    }
}
