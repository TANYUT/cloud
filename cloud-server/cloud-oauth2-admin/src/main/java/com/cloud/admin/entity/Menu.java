package com.cloud.admin.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * Menu实体类
 * </p>
 *
 * @Title: MenuController.java
 * @Package: com.cloud.admin.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:16
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("sys_menu")
@ApiModel(value = "sys_menu")
public class Menu extends Model<Menu> {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId
    @ApiModelProperty(value = "菜单ID")
    private Integer menuId;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String name;
    /**
     * 属于哪个客户端关联oauth_client_details
     */
    @ApiModelProperty(value = "属于哪个客户端关联oauth_client_details ")
    private String clientId;
    /**
     * 上级ID
     */
    @ApiModelProperty(value = "上级ID")
    private Integer parentId;
    /**
     * 请求方法 GET, POST, PUT, DELETE
     */
    @ApiModelProperty(value = "请求方法 GET, POST, PUT, DELETE")
    private String method;
    /**
     * 请求URL
     */
    @ApiModelProperty(value = "请求URL")
    private String reqUrl;
    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * webUI菜单权限标识
     */
    @ApiModelProperty(value = "webUI菜单权限标识")
    private String webRole;
    /**
     * webUI菜单路径
     */
    @ApiModelProperty(value = "webUI菜单路径")
    private String webPath;
    /**
     * webUI菜单权限类型-0菜单 -1按钮
     */
    @ApiModelProperty(value = "webUI菜单权限类型-0菜单 -1按钮")
    private String webRoleType;
    /**
     * web的类型 webUi 、小程序
     */
    @ApiModelProperty(value = "web的类型 webUi 、小程序")
    private String webType;
    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer sort;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 逻辑删除标记(0--正常 1--删除)
     */
    @TableLogic
    @ApiModelProperty(value = "逻辑删除标记(0--正常 1--删除)")
    private String delFlag;

}
