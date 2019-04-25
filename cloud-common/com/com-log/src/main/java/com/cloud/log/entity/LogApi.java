package com.cloud.log.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @Title LogApi.java
 * @Package com.cloud.log.entity
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/24 18:19
 */
@Data
//@TableName("log")
public class LogApi implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 主键id
     */
//    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;
    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 服务器 ip
     */
    private String serverIp;
    /**
     * 服务器名
     */
    private String serverHost;
    /**
     * 环境
     */
    private String env;
    /**
     * 操作IP地址
     */
    private String remoteIp;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 方法类
     */
    private String methodClass;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 执行时间
     */
    private String time;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = PATTERN_DATETIME)
    @JsonFormat(pattern = PATTERN_DATETIME)
    private LocalDateTime createTime;
}
