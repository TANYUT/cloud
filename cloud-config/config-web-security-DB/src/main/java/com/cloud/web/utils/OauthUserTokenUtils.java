package com.cloud.web.utils;

import com.cloud.web.server.impl.OauthUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
public class OauthUserTokenUtils {
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
     * 获取用户
     */
    public static OauthUser getOauthUser() {
        Authentication auth = getAuthentication();
        boolean flag = auth != null && auth.getPrincipal() != null;
        return flag ? (OauthUser) getAuthentication().getPrincipal() : null;
    }

}
