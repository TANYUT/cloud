package com.cloud.oauthupms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.oauthupms.entity.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Menu Mapper接口
 * </p>
 * @Title: MenuController.java
 * @Package: com.cloud.oauthupms.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:16
 * @Version: 1.0.0-SNAPSHOT
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 菜单权限表简单分页查询
     * @param menu 菜单权限表
     * @return
     *   IPage<Menu> getMenuPage(Page page, @Param("menu") Menu menu);
     */

}
