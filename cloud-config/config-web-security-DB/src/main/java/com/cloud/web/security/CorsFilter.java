//package com.cloud.web.security;
//
//import cn.hutool.json.JSONUtil;
//import com.cloud.web.server.impl.TokenUser;
//import com.cloud.web.utils.TokenUserUtils;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * <p>
// * 跨域过滤器
// * </p>
// *
// * @Title: CorsFilter.java
// * @Package: com.cloud.web.security
// * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
// * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date: 2019/5/12 17:19
// */
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CorsFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        System.err.println(" CorsFilter  跨域过滤器");
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        if (httpRequest.getHeader("Authorization") != null) {
//            chain.doFilter(req, res);
//            return;
//        }
//        final HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
//        response.setHeader("Access-Control-Max-Age", "3600");
//
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            chain.doFilter(req, res);
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig config) {
//    }
//}
