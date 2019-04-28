package com.cloud.oauth2.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;



/**
 * <p>
 * OauthCode实体类
 * </p>
 *
 * @Title: OauthCodeController.java
 * @Package: com.cloud.oauth2.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("oauth_code")
public class OauthCode extends Model<OauthCode> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String code;
    /**
     *
     */
    private String authentication;

}
