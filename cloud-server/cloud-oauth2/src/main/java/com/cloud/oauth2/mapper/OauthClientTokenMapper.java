package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthClientToken;

/**
 * <p>
 * OauthClientToken Mapper接口
 * </p>
 * @Title: OauthClientTokenController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthClientTokenMapper extends BaseMapper<OauthClientToken> {
    /**
     * 简单分页查询
     * @param oauthClientToken 
     * @return
     *   IPage<OauthClientToken> getOauthClientTokenPage(Page page, @Param("oauthClientToken") OauthClientToken oauthClientToken);
     */

}
