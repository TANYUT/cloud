package com.cloud.oauthupms.server.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 自定义Token 用户类
 * </p>
 *
 * @Title OauthUser.java
 * @Package com.cloud.oauthupms.server.impl
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/3 17:40
 */
public class OauthUser extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String role;

    public OauthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.role="ADMIN";
    }
}
