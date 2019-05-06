package com.cloud.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.web.utils.ResEntity;
import com.cloud.admin.entity.User;
import com.cloud.admin.service.UserService;
import lombok.AllArgsConstructor;
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
    public ResEntity getPage(Page<User> page, User user) {
        return ResEntity.<IPage>resEntity(service.page(page,
                Wrappers.<User>query().lambda()
        ));
    }


    @ApiOperation(value = "ID查询User", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping("/{userId}")
    public ResEntity getById(@PathVariable("userId") Integer userId) {
        return ResEntity.resEntity(service.getById(userId));
    }


    @ApiOperation(value = "新增User", httpMethod = "POST", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PostMapping
    public ResEntity save(@RequestBody User user) {
        return ResEntity.resEntity(service.save(user));
    }


    @ApiOperation(value = "ID修改User", httpMethod = "PUT", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PutMapping
    public ResEntity update(@RequestBody User user) {
        return ResEntity.resEntity(service.updateById(user));
    }

    @ApiOperation(value = "ID删除User", httpMethod = "DELETE", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @DeleteMapping("/{userId}")
    public ResEntity removeById(@PathVariable Integer userId) {
        return ResEntity.resEntity(service.removeById(userId));
    }


}