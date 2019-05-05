package com.cloud.admin.controller;

import com.cloud.admin.service.UserMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * UserMenuController控制层
 * </p>
 *
 * @Title: UserMenuController.java
 * @Package: com.cloud.admin.controller;
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