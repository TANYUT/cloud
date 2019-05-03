package com.cloud.web.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title DataScope.java
 * @Package com.cloud.web.bean
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/28 20:58
 */
@Data
public class DataScope extends HashMap {
    /**
     * 限制范围的字段名称
     */
    private String scopeName = "dept_id";

    /**
     * 具体的数据范围
     */
    private List<Integer> deptIds;

    /**
     * 是否只查询本部门
     */
    private Boolean isOnly = false;
}
