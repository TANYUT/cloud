package com.cloud.oauthupms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauthupms.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * OauthClientDetails Mapper接口
 * </p>
 * @Title: OauthClientDetailsController.java
 * @Package: com.cloud.oauthupms.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
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
