package com.cloud.generator.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * JDBC 连接数据库的工具类
 * </p>
 *
 * @Title JdbcUtil.java
 * @Package com.cloud.codegen.utils
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/3/20 18:16
 */
public class JdbcUtil {
    /**
     * 数据库连接
     */
    private Connection conn;
    /**
     * SQL语句执行对象
     */
    private PreparedStatement pstmt;
    /**
     * 执行结果
     */
    private ResultSet rs;

    /**
     * 初始化
     *
     * @param driver   驱动
     * @param url      数据库连接URL
     * @param username 用户名
     * @param password 密码
     */
    public JdbcUtil(String driver, String url, String username, String password) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 更新数据
    public boolean updateByParams(String sql, List params) throws SQLException {
        // 影响行数
        int result = -1;
        pstmt = conn.prepareStatement(sql);
        int index = 1;
        // 填充sql语句中的占位符
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        return result > 0 ? true : false;
    }

    // 查询多条记录
    public List<Map<String, String>> selectByParams(String sql, List params) throws SQLException {
        List<Map<String, String>> list = new ArrayList<>();
        int index = 1;
        pstmt = conn.prepareStatement(sql);
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int colsLen = metaData.getColumnCount();
        while (rs.next()) {
            Map<String, String> map = new HashMap(colsLen);
            for (int i = 0; i < colsLen; i++) {
                String columnName = metaData.getColumnName(i + 1);
                Object columnValue = rs.getObject(columnName);
                if (null == columnValue) {
                    columnValue = "";
                }
                map.put(columnName, columnValue.toString());
            }
            list.add(map);
        }
        return list;
    }


    // 查询多条记录
    public Map<String, String> selectMap(String sql) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int colsLen = metaData.getColumnCount();
        Map<String, String> map = new HashMap();
        for (int i = 0; i < colsLen; i++) {
            String columnName = metaData.getColumnName(i + 1);
            Object columnValue = rs.getObject(columnName);
            if (null == columnValue) {
                columnValue = "";
            }
            map.put(columnName, columnValue.toString());
        }
        return map;
    }

    // 释放连接
    public void release() {
        try {
            if (null != rs) {
                rs.close();
            }
            if (null != pstmt) {
                pstmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("释放数据库连接");
    }

}
