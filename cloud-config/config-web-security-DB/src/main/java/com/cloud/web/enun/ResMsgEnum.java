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
    ERROR("操作失败"),
    INFO("操作提示"),
    WARNING("操作警告"),
    SAVE_SUCCESS("新增成功"),
    SAVE_ERROR("新增失败"),
    UPDATE_SUCCESS("修改成功"),
    UPDATE_ERROR("修改失败"),
    DELETE_SUCCESS("删除成功"),
    DELETE_ERROR("删除失败"),
    MISSING_PARAMS(" 参数缺失"),
    NO_ACCESS("无权访问"),
    NO_RIGHT_TO_DELETE("无权删除"),
    UNAUTHORIZED_ACCESS("非法访问"),
    ;
    @Getter
    private String msg;


    ResMsgEnum(String msg) {
        this.msg = msg;
    }

    public static ResMsgEnum save(boolean flag) {
        return flag ? ResMsgEnum.SAVE_SUCCESS : ResMsgEnum.SAVE_ERROR;
    }

    public static ResMsgEnum update(boolean flag) {
        return flag ? ResMsgEnum.UPDATE_SUCCESS : ResMsgEnum.UPDATE_ERROR;
    }

    public static ResMsgEnum delete(boolean flag) {
        return flag ? ResMsgEnum.DELETE_SUCCESS : ResMsgEnum.DELETE_ERROR;
    }

    public static ResMsgEnum resFlag(boolean flag) {
        return flag ? ResMsgEnum.SUCCESS : ResMsgEnum.ERROR;
    }

}
