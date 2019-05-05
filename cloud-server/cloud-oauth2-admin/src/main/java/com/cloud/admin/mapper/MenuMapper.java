package com.cloud.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.admin.entity.Menu;

import java.util.List;

/**
 * <p>
 * Menu Mapper接口
 * </p>
 * @Title: MenuController.java
 * @Package: com.cloud.admin.mapper;
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-05-03 15:33:16
 * @Version: 1.0.0-SNAPSHOT
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMeun();

}
