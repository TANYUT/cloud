package com.cloud.web.enun;

import lombok.Getter;

/**
 * <p>
 * Res响应标题以及类型枚举
 * </p>
 *
 * @Title ResTypeEnum.java
 * @Package com.cloud.web.enun
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/28 21:10
 */
public enum ResTypeEnum {
    SUCCESS("success", "成功"),
    ERROR("error", "异常"),
    INFO("info", "提示"),
    WARNING("warning", "警告");
    @Getter
    private String type;
    @Getter
    private String title;

    ResTypeEnum(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public static ResTypeEnum resolve(String type) {
        for (ResTypeEnum status : values()) {
            if (status.type == type) {
                return status;
            }
        }
        return ResTypeEnum.INFO;
    }

    public static ResTypeEnum resFlag(boolean flag) {
        return flag ? ResTypeEnum.SUCCESS : ResTypeEnum.ERROR;
    }
}
