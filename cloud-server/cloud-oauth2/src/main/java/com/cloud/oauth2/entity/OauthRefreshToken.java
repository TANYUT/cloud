package com.cloud.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * <p>
 * OauthRefreshToken实体类
 * </p>
 *
 * @Title: OauthRefreshTokenController.java
 * @Package: com.cloud.oauth2.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:08
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("oauth_refresh_token")
public class OauthRefreshToken extends Model<OauthRefreshToken> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String tokenId;
    /**
     *
     */
    private String token;
    /**
     *
     */
    private String authentication;

}
