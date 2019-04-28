package com.cloud.oauth2.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @Title LoginAuthenticationFailureEvenHandler.java
 * @Package com.cloud.oauth2.handler
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/28 15:04
 */
//@Component
public class LoginAuthenticationFailureEvenHandler implements ApplicationListener<AbstractAuthenticationFailureEvent> {

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
