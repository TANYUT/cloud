package com.cloud.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * Clientdetails实体类
 * </p>
 *
 * @Title: ClientdetailsController.java
 * @Package: com.cloud.oauth2.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:13:59
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("clientdetails")
public class Clientdetails extends Model<Clientdetails> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String appId;
    /**
     *
     */
    private String resourceIds;
    /**
     *
     */
    private String appSecret;
    /**
     *
     */
    private String scope;
    /**
     *
     */
    private String grantTypes;
    /**
     *
     */
    private String redirectUrl;
    /**
     *
     */
    private String authorities;
    /**
     *
     */
    private Integer accessTokenValidity;
    /**
     *
     */
    private Integer refreshTokenValidity;
    /**
     *
     */
    private String additionalinformation;
    /**
     *
     */
    private String autoApproveScopes;



}
