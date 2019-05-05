package com.cloud.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.admin.entity.User;
import com.cloud.admin.mapper.UserMapper;
import com.cloud.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * UserService实现类
 * </p>
 *
 * @Title: UserController.java
 * @Package: com.cloud.service.impl
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User getByUserName(String userName) {
        if (StrUtil.isNotBlank(userName)) {
            return this.getOne(Wrappers.<User>query().lambda().eq(User::getUserName, userName));
        }

        return null;
    }
}