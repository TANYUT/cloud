package com.cloud.oauthupms.procedure;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 登录失败程序  LoginAuthSuccess
 * </p>
 *
 * @Title LoginAuthError.java
 * @Package com.cloud.oauthupms.procedure
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 15:50
 */
@Component
public class LoginAuthError implements ApplicationListener<AbstractAuthenticationFailureEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication) event.getSource();
        handle(authenticationException, authentication);
    }

    public void handle(AuthenticationException authenticationException, Authentication authentication) {
        System.err.println("用户：{" + authentication.getPrincipal() + "} 登录失败，异常：{" + authenticationException.getLocalizedMessage() + "}");
    }

}
