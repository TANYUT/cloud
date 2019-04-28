package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthClientDetails;

/**
 * <p>
 * OauthClientDetails Mapper接口
 * </p>
 * @Title: OauthClientDetailsController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {
    /**
     * 简单分页查询
     * @param oauthClientDetails 
     * @return
     *   IPage<OauthClientDetails> getOauthClientDetailsPage(Page page, @Param("oauthClientDetails") OauthClientDetails oauthClientDetails);
     */

}
