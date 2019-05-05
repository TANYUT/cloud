package com.cloud.admin.server.config;

import com.cloud.web.security.WebSecurityRoleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.SessionManagementFilter;

/**
 * <p>
 *
 * </p>
 *
 * @Title WebSecurityConfiguration.java
 * @Package com.cloud.admin.server.config
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 16:15
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * <p>
     * 这里是注入自定义的 继承UserDetailsService -> OauthUser 类并且增加的字段
     * 也可以直接 return  new OauthUser()
     * </p>
     *
     * @return: org.springframework.security.core.userdetails.UserDetailsService
     * @Author: au .T
     * @Date: 2019/5/4 16:46
     */
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
////InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////manager.createUser(User.withUsername("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).authorities("USER").build());
//        return userDetailsService;
//    }

    /**
     * <p>
     * spring security过滤器链及认证流程  ->https://blog.csdn.net/zhong_csdn/article/details/79447185
     * <p>
     * 1.WebAsyncManagerIntegrationFilter
     * 根据请求封装获取WebAsyncManager 从WebAsyncManager获取/注册SecurityContextCallableProcessingInterceptor
     * </p>
     * 2. SecurityContextPersistenceFilter
     * 先实例SecurityContextHolder->HttpSessionSecurityContextRepository（下面以repo代替）.作用：其会从Session中取出已认证用户的信息,提高效率,避免每一次请求都要查询用户认证信息。
     * 根据请求和响应构建HttpRequestResponseHolder repo根据HttpRequestResponseHolder加载context获取SecurityContext
     * SecurityContextHolder将获得到的SecurityContext设置到Context中，然后继续向下执行其他过滤器
     * finally-> SecurityContextHolder获取SecurityContext，然后清除，并将其和请求信息保存到repo，从请求中移除FILTER_APPLIED属性
     * <p>
     * 3. HeaderWriterFilter
     * 往该请求的Header中添加相应的信息,在http标签内部使用security:headers来控制
     * <p>
     * 4. CsrfFilter
     * csrf又称跨域请求伪造，攻击方通过伪造用户请求访问受信任站点。
     * 对需要验证的请求验证是否包含csrf的token信息，如果不包含，则报错。这样攻击网站无法获取到token信息，则跨域提交的信息都无法通过过滤器的校验。
     * <p>
     * 5. LogoutFilter
     * 匹配URL,默认为/logout  匹配成功后则用户退出,清除认证信息
     * 6. RequestCacheAwareFilter
     * 通过HttpSessionRequestCache内部维护了一个RequestCache，用于缓存HttpServletRequest
     * <p>
     * 7. SecurityContextHolderAwareRequestFilter
     * 针对ServletRequest进行了一次包装，使得request具有更加丰富的API
     * <p>
     * 8.AnonymousAuthenticationFilter
     * 当SecurityContextHolder中认证信息为空,则会创建一个匿名用户存入到SecurityContextHolder中。
     * 匿名身份过滤器，这个过滤器个人认为很重要，需要将它与UsernamePasswordAuthenticationFilter 放在一起比较理解，spring security为了兼容未登录的访问，也走了一套认证流程，只不过是一个匿名的身份。
     * 匿名认证过滤器，可能有人会想：匿名了还有身份？个人对于Anonymous匿名身份的理解是Spirng Security为了整体逻辑的统一性，即使是未通过认证的用户，也给予了一个匿名身份。而AnonymousAuthenticationFilter该过滤器的位置也是非常的科学的，它位于常用的身份认证过滤器（如UsernamePasswordAuthenticationFilter、BasicAuthenticationFilter、RememberMeAuthenticationFilter）之后，意味着只有在上述身份过滤器执行完毕后，SecurityContext依旧没有用户信息，AnonymousAuthenticationFilter该过滤器才会有意义—-基于用户一个匿名身份
     * <p>
     * 9. SessionManagementFilter
     * securityContextRepository限制同一用户开启多个会话的数量
     * SessionAuthenticationStrategy防止session-fixation protection attack（保护非匿名用户）
     * <p>
     * 10.ExceptionTranslationFilter
     * ExceptionTranslationFilter异常转换过滤器位于整个springSecurityFilterChain的后方，用来转换整个链路中出现的异常
     * 此过滤器的作用是处理中FilterSecurityInterceptor抛出的异常，然后将请求重定向到对应页面，或返回对应的响应错误代码
     * <p>
     * 11.FilterSecurityInterceptor
     * 获取到所配置资源访问的授权信息 ,根据SecurityContextHolder中存储的用户信息来决定其是否有权限,主要一些实现功能在其父类AbstractSecurityInterceptor中
     * <p>
     * 12.UsernamePasswordAuthenticationFilter
     * 表单认证是最常用的一个认证方式，一个最直观的业务场景便是允许用户在表单中输入用户名和密码进行登录，而这背后的UsernamePasswordAuthenticationFilter，在整个Spring Security的认证体系中则扮演着至关重要的角色
     * <p>
     * 根据以上 spring Security框架自带的过滤链 选择下面三个添加自定义的过滤链  还有为写入的
     * addFilterBefore(Filter filter, Class beforeFilter) 在 beforeFilter 之前添加 filter
     * addFilterAfter(Filter filter, Class afterFilter) 在 afterFilter 之后添加 filter
     * addFilterAt(Filter filter, Class atFilter) 在 atFilter 相同位置添加 filter， 此 filter 不覆盖 filter
     * </p>
     *
     * @params: [http]
     * @Author: au .T
     * @Date: 2019/5/4 16:35
     */

//    @Bean
//    public WebSecurityRoleFilter demoFilter(){
//        return new WebSecurityRoleFilter();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and()
////                .authorizeRequests().antMatchers(
////                "/actuator/**",
////                "/oauth/removeToken",
////                "/oauth/delToken/*",
////                "/oauth/listToken",
////                "/mobile/**").permitAll().anyRequest().authenticated()
////                .and()
//                .csrf().disable()
//                .addFilterAt(new WebSecurityRoleFilter(), SecurityContextPersistenceFilter.class)
//        ;
        http
                .formLogin().loginPage("/login").loginProcessingUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
        http.addFilterBefore(new WebSecurityRoleFilter(), SessionManagementFilter.class)
        ;
    }
//    @Override
//    public void configure(WebSecurity web) {
//        // 现在将所有端点暴露出来
//        web.ignoring()
//                .antMatchers("/**")
//                ;
//    }

}