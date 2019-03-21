package com.cloud.generator.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title TableEntity.java
 * @Package com.cloud.codegen.model.entity
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 17:43
 */
@Data
public class TableEntity {
    /**
     * 名称
     */
    private String tableName;
    /**
     * 备注
     */
    private String comments;
    /**
     * 主键
     */
    private ColumnEntity pk;
    /**
     * 列名
     */
    private List<ColumnEntity> columns;
    /**
     * 驼峰类型
     */
    private String caseClassName;
    /**
     * 普通类型
     */
    private String lowerClassName;
}