package com.cloud.web.utils;

import com.cloud.web.enun.ResTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@ApiModel("返回实体类")
@Data
public class ResEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty("提示内容")
    private String msg;
    @ApiModelProperty("标题")
    private String title = "成功";
    @ApiModelProperty("类型")
    private String type = "success";


    private ResEntity(T data) {
        this.data = data;
    }


    private ResEntity(String type, String msg) {
        this.msg = msg;
        this.type = type;
        this.title = ResTypeEnum.resolve(type).getTitle();
    }

    /**
     * @params: [type, msg]
     * @params: [响应类型参考ResTypeEnum, 提示内容参考ResMsgEnum]
     * @Author: au .T
     * @Date: 2019/4/26 13:27
     */
    public static ResEntity resEntity(String type, String msg) {
        return ResEntity.resEntity(type, msg);
    }

    /**
     * @params: [data 响应数据]
     * @Author: au .T
     * @Date: 2019/4/26 13:29
     */
    public static <T> ResEntity resEntity(T data) {
        return ResEntity.resEntity(data);
    }
}
