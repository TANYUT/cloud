package com.cloud.web.utils;

import com.cloud.web.enun.ResTypeEnum;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @Title ResEntity.java
 * @Package com.cloud.web.utils
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/28 21:11
 */
public class ResEntity<T> implements Serializable {
    private T data;
    private String msg;
    private String title = "成功";
    private String type = "success";

    /**
     * @params: [data 响应数据]
     * @Author: au .T
     * @Date: 2019/4/26 13:29
     */
    public ResEntity(T data) {
        this.data = data;
    }

    /**
     * @params: [type, msg]
     * @params: [响应类型参考ResTypeEnum, 提示内容参考ResMsgEnum]
     * @Author: au .T
     * @Date: 2019/4/26 13:27
     */
    public ResEntity(String type, String msg) {
        this.msg = msg;
        this.type = type;
        this.title = ResTypeEnum.resolve(type).getTitle();
    }
}
