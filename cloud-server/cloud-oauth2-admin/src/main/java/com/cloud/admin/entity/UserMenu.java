package com.cloud.admin.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * UserMenu实体类
 * </p>
 *
 * @Title: UserMenuController.java
 * @Package: com.cloud.admin.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("sys_user_menu")
@ApiModel(value = "sys_user_menu")
public class UserMenu extends Model<UserMenu> {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @TableId
    @ApiModelProperty(value = "部门ID")
    private Integer userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Integer menuId;

}
