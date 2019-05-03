package com.cloud.oauthupms.server.impl;

import com.cloud.oauthupms.entity.User;
import com.cloud.oauthupms.service.UserService;
import com.cloud.web.server.impl.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 自定义用户登录
 * </p>
 *
 * @Title UserDetailsServiceImpl.java
 * @Package com.cloud.oauthupms.server.impl
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/5/3 16:00
 */
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByUserName(userName);
        Set<String> dbAuthsSet = new HashSet<>();
//        if (ArrayUtil.isNotEmpty(info.getRoles())) {
//            // 获取角色
//            Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add(SecurityConstants.WEB_ROLE_PREFIX + role));
//            // 获取资源
//            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));
//        }
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));
        return new OauthUser(userName, user.getPassWord(), authorities);
    }
}
