package com.cloud.admin.server.impl;

import cn.hutool.core.util.StrUtil;
import com.cloud.admin.entity.User;
import com.cloud.admin.service.UserService;
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
 * 自定义用户名登录   https://github.com/lenve/vhr
 * </p>
 *
 * @Title UserDetailsServiceImpl.java
 * @Package com.cloud.admin.server.impl
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/4 18:38
 */
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * <p>
     * 用户输入的可以是用户名 或者是手机号
     * 根据用户名没有查到会在根据手机号查一次
     * </p>
     *
     * @params: [userName]
     * @return: org.springframework.security.core.userdetails.UserDetails
     * @Author: au .T
     * @Date: 2019/5/5 10:46
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User userEntity = userService.getByUserName(userName);
        if (userEntity == null) {
            //根据手机号在查一次 待完善
        }
        if (userEntity == null || StrUtil.isBlank(userEntity.getPassword())) {
            throw new UsernameNotFoundException("用户名密码错误");
        }
        Set<String> authsSet = new HashSet<>();
//        if (ArrayUtil.isNotEmpty(info.getRoles())) {
//            // 获取角色
//            Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add(SecurityConstants.WEB_ROLE_PREFIX + role));
//            // 获取资源
//            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));
//        }
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(authsSet.toArray(new String[0]));
        return new OauthUser(userName, userEntity.getPassword(), authorities);
    }
}
