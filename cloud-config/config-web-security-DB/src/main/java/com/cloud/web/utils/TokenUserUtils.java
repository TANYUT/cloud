package com.cloud.web.utils;

import cn.hutool.json.JSONUtil;
import com.cloud.web.server.impl.TokenUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>
 *
 * </p>
 *
 * @Title OauthSecurityUtils.java
 * @Package com.cloud.web.utils
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 20:11
 */
@UtilityClass
public class TokenUserUtils {
    /**
     * <p>
     * 获取请求头里面的 Token 的全部数据 自己可以格式化输出看一下
     * </p>
     *
     * @return: org.springframework.security.core.Authentication
     * @Author: au .T
     * @Date: 2019/5/3 20:12
     */
    public static Authentication getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth : null;
    }

    /**
     * <p>
     * 获取登录用户的信息
     * 注意 如果Token 存在数据库  这里获取到的是 字符串为"anonymousUser" Object 类
     * </p>
     *
     * @return: com.cloud.web.server.impl.OauthUser
     * @Author: au .T
     * @Date: 2019/5/6 10:20
     */
    public static TokenUser getUser() {
// java.security.Principal principal = httpRequest.getUserPrincipal();
        Authentication auth = getAuthentication();
        boolean flag = auth != null && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof TokenUser;
        return flag ? (TokenUser) auth.getPrincipal() : null;
    }

    /**
     * <p>
     * 通过HttpRequest 获取用户信息
     * </p>
     *
     * @params: [httpRequest]
     * @return: java.security.Principal
     * @Author: au .T
     * @Date: 2019/5/7 15:34
     */
    public static Principal getPrincipal(HttpServletRequest httpRequest) {
        return httpRequest.getUserPrincipal();
    }

}
