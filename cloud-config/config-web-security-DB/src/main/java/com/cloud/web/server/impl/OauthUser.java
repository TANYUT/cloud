package com.cloud.web.server.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 *
 * </p>
 *
 * @Title OauthUser.java  userInfo
 * @Package com.cloud.web.server.impl
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 20:14
 */
public class OauthUser extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 该用户的角色ID多个 , 隔开
     */
    @Getter
    @Setter
    private String roleIds;
    /**
     * 该用户可以执行的方法  , 隔开
     */
    @Getter
    @Setter
    private String roleMethod;

    public OauthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.roleIds = "ADMIN,USER";
        this.roleMethod = "GET,POST";
    }
}
