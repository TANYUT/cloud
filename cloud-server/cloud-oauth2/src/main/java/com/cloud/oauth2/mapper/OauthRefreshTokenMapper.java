package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthRefreshToken;

/**
 * <p>
 * OauthRefreshToken Mapper接口
 * </p>
 * @Title: OauthRefreshTokenController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:08
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthRefreshTokenMapper extends BaseMapper<OauthRefreshToken> {
    /**
     * 简单分页查询
     * @param oauthRefreshToken 
     * @return
     *   IPage<OauthRefreshToken> getOauthRefreshTokenPage(Page page, @Param("oauthRefreshToken") OauthRefreshToken oauthRefreshToken);
     */

}
