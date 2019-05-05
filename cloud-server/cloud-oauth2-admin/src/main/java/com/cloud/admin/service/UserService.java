package com.cloud.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.admin.entity.User;

/**
 * <p>
 * UserService接口
 * </p>
 *
 * @Title: UserController.java
 * @Package: com.cloud.admin.service;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
public interface UserService extends IService<User> {


    User getByUserName(String userName);

}