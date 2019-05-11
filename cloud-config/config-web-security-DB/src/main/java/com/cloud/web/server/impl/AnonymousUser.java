package com.cloud.web.server.impl;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 匿名用户访问类
 * </p>
 *
 * @Title: AnonymousUser.java
 * @Package: com.cloud.web.server.impl
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 10:05
 */
public class AnonymousUser extends TokenUser implements Serializable {
    private AnonymousUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
