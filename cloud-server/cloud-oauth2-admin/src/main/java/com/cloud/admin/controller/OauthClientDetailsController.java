package com.cloud.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.web.utils.ResEntity;
import com.cloud.admin.entity.OauthClientDetails;
import com.cloud.admin.service.OauthClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;


/**
 * <p>
 * OauthClientDetailsController控制层
 * </p>
 *
 * @Title: OauthClientDetailsController.java
 * @Package: com.cloud.admin.controller;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@RestController
@AllArgsConstructor
@RequestMapping("oauthClientDetails")
@Api(value = "OauthClientDetailsControllerAPI", description = "OauthClientDetails描述")
public class OauthClientDetailsController {
    private final OauthClientDetailsService service;


    @ApiOperation(value = "根据对象分页查询OauthClientDetails", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页索引", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "size", value = "页显示记录数", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/getPage")
    public ResEntity getPage(Page<OauthClientDetails> page, OauthClientDetails oauthClientDetails) {
        return ResEntity.<IPage>resEntity(service.page(page,
                Wrappers.<OauthClientDetails>query().lambda()
        ));
    }


    @ApiOperation(value = "ID查询OauthClientDetails", httpMethod = "GET", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientId", value = "主键ID", required = true, paramType = "query", dataType = "String"),
    })
    @GetMapping("/{clientId}")
    public ResEntity getById(@PathVariable("clientId") String clientId) {
        return ResEntity.resEntity(service.getById(clientId));
    }


    @ApiOperation(value = "新增OauthClientDetails", httpMethod = "POST", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientId", value = "主键ID", required = true, paramType = "query", dataType = "String"),
    })
    @PostMapping
    public ResEntity save(@RequestBody OauthClientDetails oauthClientDetails) {
        return ResEntity.resEntity(service.save(oauthClientDetails));
    }


    @ApiOperation(value = "ID修改OauthClientDetails", httpMethod = "PUT", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientId", value = "主键ID", required = true, paramType = "query", dataType = "String"),
    })
    @PutMapping
    public ResEntity update(@RequestBody OauthClientDetails oauthClientDetails) {
        return ResEntity.resEntity(service.updateById(oauthClientDetails));
    }

    @ApiOperation(value = "ID删除OauthClientDetails", httpMethod = "DELETE", notes = "", response = ResEntity.class,
            extensions = @Extension(properties = @ExtensionProperty(name = "au.T/2019-05-03 15:33:17", value = "au.t@foxmail.com"))
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientId", value = "主键ID", required = true, paramType = "query", dataType = "String"),
    })
    @DeleteMapping("/{clientId}")
    public ResEntity removeById(@PathVariable String clientId) {
        return ResEntity.resEntity(service.removeById(clientId));
    }
}