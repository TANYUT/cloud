package com.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauth2.entity.Clientdetails;

/**
 * <p>
 * Clientdetails Mapper接口
 * </p>
 * @Title: ClientdetailsController.java
 * @Package: com.cloud.oauth2.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:13:59
 * @Version: 1.0.0-SNAPSHOT
 */
public interface ClientdetailsMapper extends BaseMapper<Clientdetails> {
    /**
     * 简单分页查询
     * @param clientdetails 
     * @return
     *   IPage<Clientdetails> getClientdetailsPage(Page page, @Param("clientdetails") Clientdetails clientdetails);
     */

}
