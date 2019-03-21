package com.cloud.generator.utils;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @Title JdbcBean.java
 * @Package com.cloud.codegen.utils
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 18:13
 */
@Data
public class JdbcBean {
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    public JdbcBean() {}

    public JdbcBean(String jdbcDriver, String jdbcUrl, String jdbcUsername, String jdbcPassword) {
        this.jdbcDriver = jdbcDriver;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
}
