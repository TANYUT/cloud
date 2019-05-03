package com.cloud.oauthupms.server.impl;

import cn.hutool.core.util.StrUtil;
import com.cloud.oauthupms.entity.User;
import com.cloud.oauthupms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * 自定义用户登录
 * </p>
 *
 * @Title UserDetailsServiceImpl.java
 * @Package com.cloud.oauthupms.server.impl
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/3 16:00
 */
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByUserName(userName);
        if(user!=null){}
        return null;
    }
}
