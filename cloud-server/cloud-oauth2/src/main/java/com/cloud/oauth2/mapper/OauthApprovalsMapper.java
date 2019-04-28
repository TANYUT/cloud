package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthApprovals;

/**
 * <p>
 * OauthApprovals Mapper接口
 * </p>
 * @Title: OauthApprovalsController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthApprovalsMapper extends BaseMapper<OauthApprovals> {
    /**
     * 简单分页查询
     * @param oauthApprovals 
     * @return
     *   IPage<OauthApprovals> getOauthApprovalsPage(Page page, @Param("oauthApprovals") OauthApprovals oauthApprovals);
     */

}
