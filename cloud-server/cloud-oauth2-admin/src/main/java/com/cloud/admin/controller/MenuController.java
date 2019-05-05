package com.cloud.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.admin.utils.MenuTreeUtil;
import com.cloud.web.utils.ResEntity;
import com.cloud.admin.entity.Menu;
import com.cloud.admin.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import static com.cloud.web.utils.ResEntity.resEntity;


/**
 * <p>
 * MenuController控制层
 * </p>
 *
 * @Title: MenuController.java
 * @Package: com.cloud.admin.controller;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:16
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("menu")
@Api(value = "MenuControllerAPI", description = "Menu描述")
public class MenuController {
    private final MenuService service;


    @ApiOperation(value = "根据对象分页查询Menu", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:16", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页索引", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "size", value = "页显示记录数", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/getPage")
    public ResEntity getPage(Page<Menu> page, Menu menu) {

        return ResEntity.<IPage>resEntity(service.page(page,
                Wrappers.<Menu>query().lambda()
        ));
    }


    @ApiOperation(value = "ID查询Menu", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:16", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @GetMapping("/{menuId}")
    public ResEntity getById(@PathVariable("menuId") Integer menuId) {
        return ResEntity.resEntity(service.getById(menuId));
    }


    @ApiOperation(value = "新增Menu", httpMethod = "POST", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:16", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({

            @ApiImplicitParam(name = "menuId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PostMapping
    public ResEntity save(@RequestBody Menu menu) {
        return ResEntity.resEntity(service.save(menu));
    }


    @ApiOperation(value = "ID修改Menu", httpMethod = "PUT", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:16", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @PutMapping
    public ResEntity update(@RequestBody Menu menu) {
        return ResEntity.resEntity(service.updateById(menu));
    }

    @ApiOperation(value = "ID删除Menu", httpMethod = "DELETE", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:16", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "主键ID", required = true, paramType = "query", dataType = "Integer"),
    })
    @DeleteMapping("/{menuId}")
    public ResEntity removeById(@PathVariable Integer menuId) {
        return ResEntity.resEntity(service.removeById(menuId));
    }

    @GetMapping({"/tree"})
    public ResEntity getTree() {
        return ResEntity.resEntity(MenuTreeUtil.treeMenu(this.service.list()));
    }

}