package com.cloud.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * <p>
 * OauthClientDetails实体类
 * </p>
 *
 * @Title: OauthClientDetailsController.java
 * @Package: com.cloud.oauth2.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("oauth_client_details")
public class OauthClientDetails extends Model<OauthClientDetails> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String clientId;
    /**
     *
     */
    private String resourceIds;
    /**
     *
     */
    private String clientSecret;
    /**
     *
     */
    private String scope;
    /**
     *
     */
    private String authorizedGrantTypes;
    /**
     *
     */
    private String webServerRedirectUri;
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
    private String additionalInformation;
    /**
     *
     */
    private String autoapprove;

}
