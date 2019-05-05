package com.cloud.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.admin.entity.RoleMenu;

/**
 * <p>
 * RoleMenu Mapper接口
 * </p>
 * @Title: RoleMenuController.java
 * @Package: com.cloud.admin.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:17
 * @Version: 1.0.0-SNAPSHOT
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    /**
     * 角色菜单表简单分页查询
     * @param roleMenu 角色菜单表
     * @return
     *   IPage<RoleMenu> getRoleMenuPage(Page page, @Param("roleMenu") RoleMenu roleMenu);
     */

}