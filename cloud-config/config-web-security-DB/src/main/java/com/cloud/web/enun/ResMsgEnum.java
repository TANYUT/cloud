package com.cloud.web.enun;

import lombok.Getter;

/**
 * <p>
 * Res响应基本消息枚举
 * </p>
 *
 * @Title ResMsgEnum.java
 * @Package com.cloud.web.enun
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/28 21:09
 */
public enum ResMsgEnum {
    SUCCESS("操作成功"),
    ERROR("操作异常"),
    INFO("操作提示"),
    WARNING("操作警告");
    @Getter
    private String msg;


    ResMsgEnum(String msg) {
        this.msg = msg;
    }
}
