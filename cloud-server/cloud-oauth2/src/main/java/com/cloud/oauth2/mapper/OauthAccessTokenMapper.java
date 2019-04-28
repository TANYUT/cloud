package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthAccessToken;

/**
 * <p>
 * OauthAccessToken Mapper接口
 * </p>
 * @Title: OauthAccessTokenController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthAccessTokenMapper extends BaseMapper<OauthAccessToken> {
    /**
     * 简单分页查询
     * @param oauthAccessToken 
     * @return
     *   IPage<OauthAccessToken> getOauthAccessTokenPage(Page page, @Param("oauthAccessToken") OauthAccessToken oauthAccessToken);
     */

}
