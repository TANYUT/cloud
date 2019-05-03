package com.cloud.oauthupms.procedure;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @Title LoginAuthSuccess.java
 * @Package com.cloud.oauthupms.procedure
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 15:51
 */
@Component
public class LoginAuthSuccess implements ApplicationListener<AuthenticationSuccessEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        if (!authentication.getAuthorities().isEmpty()) {
            handle(authentication);
        }
    }

    /**
     * 处理登录成功方法
     * <p>
     * 获取到登录的authentication 对象
     *
     * @param authentication 登录对象
     */
    public void handle(Authentication authentication) {
        System.err.println("用户：" + authentication.getPrincipal() + " 登录成功");
    }
}
