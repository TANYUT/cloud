package com.cloud.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.web.utils.ResEntity;
import com.cloud.admin.entity.RoleMenu;
import com.cloud.admin.service.RoleMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * RoleMenuController控制层
 * </p>
 * @Title: RoleMenuController.java
 * @Package: com.cloud.admin.controller;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("roleMenu")
@Api(value = "RoleMenuControllerAPI", description = "RoleMenu描述")
public class RoleMenuController {
    private final RoleMenuService service;


    @ApiOperation(value = "根据对象分页查询RoleMenu", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页索引", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "size", value = "页显示记录数", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/getPage")
    public ResEntity getPage(Page<RoleMenu> page, RoleMenu roleMenu) {
        return ResEntity.<IPage>resEntity(service.page(page,
                Wrappers.<RoleMenu>query().lambda()
        ));
    }


    @ApiOperation(value = "ID查询RoleMenu", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping("/{roleId}")
    public ResEntity getById(@PathVariable("roleId") Integer roleId) {
        return ResEntity.resEntity(service.getById(roleId));
    }


    @ApiOperation(value = "新增RoleMenu", httpMethod = "POST", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PostMapping
    public ResEntity save(@RequestBody RoleMenu roleMenu) {
        return ResEntity.resEntity(service.save(roleMenu));
    }


    @ApiOperation(value = "ID修改RoleMenu", httpMethod = "PUT", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PutMapping
    public ResEntity update(@RequestBody RoleMenu roleMenu) {
        return ResEntity.resEntity(service.updateById(roleMenu));
    }

    @ApiOperation(value = "ID删除RoleMenu", httpMethod = "DELETE", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @DeleteMapping("/{roleId}")
    public ResEntity removeById(@PathVariable Integer roleId) {
        return ResEntity.resEntity(service.removeById(roleId));
    }
}