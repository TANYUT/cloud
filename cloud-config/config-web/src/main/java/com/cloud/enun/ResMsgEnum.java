package com.cloud.enun;

import lombok.Getter;

/**
 * <p>
 * Res响应基本消息枚举
 * </p>
 *
 * @Title ResMsgEnum.java
 * @Package com.cloud.enun
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/26 13:40
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
