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
public class OauthSecurityUtils {
    /**
     * <p>
     * 获取请求头里面的 Token
     * </p>
     *
     * @return: org.springframework.security.core.Authentication
     * @Author: au .T
     * @Date: 2019/5/3 20:12
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public static OauthUser getOauthUser() {
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof OauthUser) {
            return (OauthUser) principal;
        }
        return null;
    }

    /**
     * <p>
     * 获取登录用户的 可执行的方法
     * </p>
     *
     * @return: java.lang.String
     * @Author: au .T
     * @Date: 2019/5/3 20:25
     */
    public String getUserRoleMethod() {
        return getOauthUser().getRoleMethod();
    }

    /**
     * <p>
     * 获取登录用户的 ROLE_ID
     * </p>
     *
     * @return: java.lang.String
     * @Author: au .T
     * @Date: 2019/5/3 20:25
     */
    public String getUserRoleIds() {
        return getOauthUser().getRoleIds();
    }
}
