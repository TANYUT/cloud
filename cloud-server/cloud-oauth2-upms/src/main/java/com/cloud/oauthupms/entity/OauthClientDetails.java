package com.cloud.oauthupms.entity;

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
 * OauthClientDetails实体类
 * </p>
 *
 * @Title: OauthClientDetailsController.java
 * @Package: com.cloud.oauthupms.entity;
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
@Data
@TableName("oauth_client_details")
@ApiModel(value = "oauth_client_details")
public class OauthClientDetails extends Model<OauthClientDetails> {
    private static final long serialVersionUID = 1L;

    /**
     * 客户端ID
     */
    @TableId
    @ApiModelProperty(value = "客户端ID")
    private String clientId;
    /**
     * 此客户端可以访问的资源。如果为空，则可以被调用者忽略
     */
    @ApiModelProperty(value = "此客户端可以访问的资源。如果为空，则可以被调用者忽略")
    private String resourceIds;
    /**
     * 客户的秘密。如果不需要{@link #//isSecretRequired()机密，则忽略}
     */
    @ApiModelProperty(value = "客户的秘密。如果不需要{@link #isSecretRequired（）机密，则忽略}")
    private String clientSecret;
    /**
     * 此客户端是否仅限于特定范围。如果为false，则将忽略身份验证请求的范围。此客户端是否仅限于特定范围。
     */
    @ApiModelProperty(value = "此客户端是否仅限于特定范围。如果为false，则将忽略身份验证请求的范围。此客户端是否仅限于特定范围。")
    private String scope;
    /**
     * 授予此客户端的授权类型。
     */
    @ApiModelProperty(value = "授予此客户端的授权类型。")
    private String authorizedGrantTypes;
    /**
     * 访问授权期间使用的预定义重定向URI。
     */
    @ApiModelProperty(value = "访问授权期间使用的预定义重定向URI。")
    private String webServerRedirectUri;
    /**
     * 返回授予OAuth客户端的权限。无法返回 null 请注意，这些不是授予具有授权访问令牌的用户的权限。相反，这些权威是客户本身所固有的。
     */
    @ApiModelProperty(value = "返回授予OAuth客户端的权限。无法返回 null 请注意，这些不是授予具有授权访问令牌的用户的权限。相反，这些权威是客户本身所固有的。")
    private String authorities;
    /**
     * 此客户端的访问令牌有效期。如果未明确设置则为空（实现可能使用该事实*来提供默认值）。
     */
    @ApiModelProperty(value = "此客户端的访问令牌有效期。如果未明确设置则为空（实现可能使用该事实*来提供默认值）。")
    private Integer accessTokenValidity;
    /**
     * 此客户端的刷新令牌有效期。由令牌服务设置的默认值为空，对于非到期令牌，为零或为负。
     */
    @ApiModelProperty(value = "此客户端的刷新令牌有效期。由令牌服务设置的默认值为空，对于非到期令牌，为零或为负。")
    private Integer refreshTokenValidity;
    /**
     * 该客户端的附加信息，vanilla OAuth协议不需要，但可能有用，例如，用于存储描述性信息
     */
    @ApiModelProperty(value = "该客户端的附加信息，vanilla OAuth协议不需要，但可能有用，例如，用于存储描述性信息")
    private String additionalInformation;
    /**
     * 测试客户端是否需要用户批准特定范围。
     */
    @ApiModelProperty(value = "测试客户端是否需要用户批准特定范围。")
    private String autoapprove;

}
