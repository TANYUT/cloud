package com.cloud.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.web.utils.ResEntity;
import com.cloud.admin.entity.User;
import com.cloud.admin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * UserController控制层
 * </p>
 *
 * @Title: UserController.java
 * @Package: com.cloud.admin.controller;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("user")
@Api(value = "UserControllerAPI", description = "User描述")
public class UserController {
    private final UserService service;

    @ApiOperation(value = "根据对象分页查询User", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页索引", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "size", value = "页显示记录数", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/getPage")
    public ResEntity getPage(Page<User> page, User cond) {
        return ResEntity.<IPage>resEntity(service.page(page,
                Wrappers.<User>query().lambda()
                        .eq(StrUtil.isNotBlank(cond.getUserName()), User::getUserName, cond.getUserName())
        ));
    }

    @GetMapping("/getUser")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}