package com.cloud.admin.controller;

import com.cloud.admin.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * UserRoleController控制层
 * </p>
 *
 * @Title: UserRoleController.java
 * @Package: com.cloud.admin.controller;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("userRole")
@Api(value = "UserRoleControllerAPI", description = "UserRole描述")
public class UserRoleController {
    private final UserRoleService service;

}