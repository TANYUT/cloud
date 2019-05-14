package com.cloud.admin.server.config;

import com.cloud.web.security.WebSecurityMethodFilter;
import com.cloud.web.security.WebSecurityRoleFilter;
import com.cloud.web.security.WebSecurityUriFilter;
import com.cloud.web.security.WebSecurityUserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.session.SessionManagementFilter;

/**
 * <p>
 * {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter}
 * WebSecurityConfigurerAdapter用于保护oauth相关的endpoints，同时主要作用于用户的登录(form login,Basic auth)
 *
 * </p>
 *
 * @Title WebSecurityConfiguration.java
 * @Package com.cloud.aoth.config
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 16:15
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    /**
     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * <p>
     * addFilterBefore(Filter filter, Class beforeFilter) 在 beforeFilter 之前添加 filter
     * addFilterAfter(Filter filter, Class afterFilter) 在 afterFilter 之后添加 filter
     * addFilterAt(Filter filter, Class atFilter) 在 atFilter 相同位置添加 filter， 此 filter 不覆盖 filter
     * </p>
     *
     * @Author: au .T
     * @Date: 2019/5/7 14:07
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oauth/**")
                .permitAll()
                .anyRequest().authenticated();
    }


}