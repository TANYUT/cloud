package com.cloud.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.admin.entity.UserMenu;

/**
 * <p>
 * UserMenu Mapper接口
 * </p>
 * @Title: UserMenuController.java
 * @Package: com.cloud.admin.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
public interface UserMenuMapper extends BaseMapper<UserMenu> {
    /**
     * 角色与部门对应关系简单分页查询
     * @param userMenu 角色与部门对应关系
     * @return
     *   IPage<UserMenu> getUserMenuPage(Page page, @Param("userMenu") UserMenu userMenu);
     */

}
