package com.cloud.web.security;


import cn.hutool.json.JSONUtil;
import com.cloud.web.security.config.IgnoreUrlConfig;
import com.cloud.web.utils.OauthUserTokenUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * <p>
 * 需要在配置文件spring.factories 配置注入Bean
 * </p>
 *
 * @Title WebSecurityRoleFilter.java
 * @Package com.cloud.web.security
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/4 18:25
 */
public class WebSecurityRoleFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("WebSecurityRoleFilter");
//        System.err.println(JSONUtil.parseObj(OauthUserTokenUtils.getAuthentication()).toStringPretty());
//        System.err.println("--------------------------------");
//        System.err.println(JSONUtil.parseObj(OauthUserTokenUtils.getOauthUser()).toStringPretty());

//        String grantType = request.getQueryParams().getFirst("grant_type");
//        IgnoreUrlConfig ignoreUrlConfig = new IgnoreUrlConfig();
//        System.err.println(ignoreUrlConfig.getUrls());
        chain.doFilter(request, response);
    }
}
