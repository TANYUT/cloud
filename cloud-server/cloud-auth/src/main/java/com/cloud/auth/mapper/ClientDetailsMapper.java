package com.cloud.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.auth.entity.ClientDetails;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * ClientDetails Mapper接口
 * </p>
 * @Title: ClientDetailsController.java
 * @Package: com.cloud.auth.mapper;
 *
 * @Author <a href="mailto:au_t@qq.com"">au.T</a>
 * @Date: 2019-04-06 16:52:22
 * @Version: 1.0.0
 */
public interface ClientDetailsMapper extends BaseMapper<ClientDetails> {
    /**
     * 简单分页查询
     * @param clientDetails 
     * @return
     *   IPage<ClientDetails> getClientDetailsPage(Page page, @Param("clientDetails") ClientDetails clientDetails);
     */

}
