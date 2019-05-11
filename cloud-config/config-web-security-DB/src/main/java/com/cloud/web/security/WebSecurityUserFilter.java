package com.cloud.web.security;

import cn.hutool.json.JSONUtil;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 请求用户过滤器
 * </p>
 *
 * @Title: WebSecurityUserFilter.java
 * @Package: com.cloud.web.security
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 9:52
 */
@Order(0)//控制过滤顺序 从0 开始
public class WebSecurityUserFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("@Order(0)用户User过滤器");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.err.println("请求方法-->" + httpRequest.getMethod());
        System.err.println("请求sessionId-->" + httpRequest.getSession().getId());
        System.err.println("请求用户信息-->" + httpRequest.getUserPrincipal());
        System.err.println("请求Cookie S-->" + JSONUtil.parseObj(httpRequest.getCookies()[0]));
        System.err.println("请求 PathInfo-->" + (httpRequest.getPathInfo()));
        System.err.println("请求 PathTranslated-->" + (httpRequest.getPathTranslated()));
        System.err.println("请求 ContextPath-->" + (httpRequest.getContextPath()));
        System.err.println("请求 QueryString-->" + (httpRequest.getQueryString()));
        System.err.println("请求 RemoteUser-->" + (httpRequest.getRemoteUser()));
        System.err.println("请求 UserInRole-->" + (httpRequest.isUserInRole("ADMIN")));
        System.err.println("请求 RequestedSessionId-->" + (httpRequest.getRequestedSessionId()));
        System.err.println("请求 RequestURI-->" + (httpRequest.getRequestURI()));
        System.err.println("请求 RequestURL-->" + (httpRequest.getRequestURL()));
        System.err.println("请求 ServletPath-->" + (httpRequest.getServletPath()));

        HttpServletResponse httpResponse = (HttpServletResponse) response;


        chain.doFilter(request, response);
    }
}
