package com.cloud.generator.entity;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @Title ColumnEntity.java
 * @Package com.cloud.codegen.model.entity
 * @Author <a href="mailto:au_t@qq.com">au .T</a>
 * @Date 2019/3/20 17:43
 */

@Data
public class ColumnEntity {
    /**
     * 列表
     */
    private String columnName;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 备注
     */
    private String comments;

    /**
     * 驼峰属性
     */
    private String caseAttrName;
    /**
     * 普通属性
     */
    private String lowerAttrName;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * 其他信息。
     */
    private String extra;
}
