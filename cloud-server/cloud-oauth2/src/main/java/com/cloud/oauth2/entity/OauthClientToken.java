package com.cloud.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * <p>
 * OauthClientToken实体类
 * </p>
 *
 * @Title: OauthClientTokenController.java
 * @Package: com.cloud.oauth2.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("oauth_client_token")
public class OauthClientToken extends Model<OauthClientToken> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String tokenId;
    /**
     *
     */
    private String token;
    /**
     *
     */
    @TableId
    private String authenticationId;
    /**
     *
     */
    private String userName;
    /**
     *
     */
    private String clientId;

}
