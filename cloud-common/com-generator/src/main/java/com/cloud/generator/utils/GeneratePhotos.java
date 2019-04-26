package com.cloud.generator.utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title GeneratePhotos.java
 * @Package com.cloud.generator.utils
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/9 10:52
 */
public class GeneratePhotos {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3406/ks_platform?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true";
    private static String JDBC_USERNAME = "sinotn";
    private static String JDBC_PASSWORD = "123456";
    private static String PLAN_ID = "ouiqnh5r15euCZ0QAgQxBawLiN-bgSHp";

    public static void main(String[] args) throws SQLException {
        JdbcBean jdbcBean = new JdbcBean(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        JdbcUtil jdbcUtil = new JdbcUtil(jdbcBean.getJdbcDriver(),
                jdbcBean.getJdbcUrl(), jdbcBean.getJdbcUsername(), jdbcBean.getJdbcPassword());

        String sql = "SELECT *  FROM pf_plan_node   WHERE PLAN_ID = '" + PLAN_ID + "'";
        System.err.println(sql);
        List<Map<String, String>> result = jdbcUtil.selectByParams(sql, null);
        for (Map m : result) {
            System.err.println(m);
        }
        jdbcUtil.release();
    }
}
