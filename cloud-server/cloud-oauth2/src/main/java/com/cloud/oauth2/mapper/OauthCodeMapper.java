package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.OauthCode;

/**
 * <p>
 * OauthCode Mapper接口
 * </p>
 * @Title: OauthCodeController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
public interface OauthCodeMapper extends BaseMapper<OauthCode> {
    /**
     * 简单分页查询
     * @param oauthCode 
     * @return
     *   IPage<OauthCode> getOauthCodePage(Page page, @Param("oauthCode") OauthCode oauthCode);
     */

}
