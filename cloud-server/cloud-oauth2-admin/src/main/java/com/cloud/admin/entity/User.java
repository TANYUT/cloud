package com.cloud.admin.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * User实体类
 * </p>
 *
 * @Title: UserController.java
 * @Package: com.cloud.admin.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("sys_user")
@ApiModel(value = "sys_user")
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键自增ID
     */
    @TableId
    @ApiModelProperty(value = "主键自增ID")
    private Integer userId;
    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 删除状态
     */
    @TableLogic
    @ApiModelProperty(value = "删除状态")
    private String delFlag;
    /**
     * 锁定状态
     */
    @ApiModelProperty(value = "锁定状态")
    private String lockFlag;
    /**
     * 微信开放Id
     */
    @ApiModelProperty(value = "微信开放Id")
    private String wxOpenid;

}
