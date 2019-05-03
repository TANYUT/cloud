package com.cloud.oauthupms.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.web.utils.ResEntity;
import com.cloud.oauthupms.entity.UserMenu;
import com.cloud.oauthupms.service.UserMenuService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * UserMenuController控制层
 * </p>
 *
 * @Title: UserMenuController.java
 * @Package: com.cloud.oauthupms.controller;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("userMenu")
@Api(value = "UserMenuControllerAPI", description = "UserMenu描述")
public class UserMenuController {
    private final UserMenuService service;

}