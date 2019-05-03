package com.cloud.oauthupms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauthupms.entity.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * UserRole Mapper接口
 * </p>
 * @Title: UserRoleController.java
 * @Package: com.cloud.oauthupms.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 用户角色表简单分页查询
     * @param userRole 用户角色表
     * @return
     *   IPage<UserRole> getUserRolePage(Page page, @Param("userRole") UserRole userRole);
     */

}
