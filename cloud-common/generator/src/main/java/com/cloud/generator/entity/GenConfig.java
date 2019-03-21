package com.cloud.generator.entity;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @Title GenConfig.java
 * @Package com.cloud.codegen.model.entity
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 17:43
 */
@Data
public class GenConfig {
    /**
     * 包名
     */
    private String packageName;
    /**
     * 作者
     */
    private String author;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表备注
     */
    private String comments;
}
