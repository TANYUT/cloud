package com.cloud.web.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.web.enun.ResMsgEnum;
import com.cloud.web.enun.ResTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * <p>
 * 响应封装类
 * </p>
 *
 * @Title ResEntity.java
 * @Package com.cloud.web.utils
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
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
    @ApiModelProperty("返回的数据")
    private T data;
    @ApiModelProperty("提示消息内容")
    private String msg;
    @ApiModelProperty("提示消息标题")
    private String title = "成功";
    @ApiModelProperty("消息类型->success、成功。error、异常。info、提示。warning、警告")
    private String type = "success";


    private ResEntity(T data) {
        this.data = data;
    }


    private ResEntity(boolean flag) {
        ResTypeEnum typeEnum = ResTypeEnum.resFlag(flag);
        this.title = typeEnum.getTitle();
        this.type = typeEnum.getType();
        this.msg = ResMsgEnum.resFlag(flag).getMsg();
    }

    private ResEntity(String params) {
        ResTypeEnum typeEnum = ResTypeEnum.INFO;
        this.title = typeEnum.getTitle();
        this.type = typeEnum.getType();
        this.msg = params + ResMsgEnum.MISSING_PARAMS.getMsg();
    }

    private ResEntity(ResTypeEnum type, String msg) {
        this.msg = msg;
        this.type = type.getType();
        this.title = type.getTitle();
    }

    private ResEntity(ResTypeEnum type, ResMsgEnum msg) {
        this.type = type.getType();
        this.title = type.getTitle();
        this.msg = msg.getMsg();
    }


    /**
     * <p>
     * 注意  resEntity 这是一个重载的方法
     * 传泛型一定要申明是哪个类到这个泛型里面
     * 例如：
     * ResEntity.<IPage>resEntity(new IPage());
     * ResEntity.<String>resEntity(new String())
     * </p>
     *
     * @params: [data 响应数据]
     * @return: com.cloud.web.utils.ResEntity
     * @Author: au .T
     * @Date: 2019/4/26 13:29
     */
    public static <T> ResEntity<T> resEntity(T data) {
        return new ResEntity(data);
    }


    /**
     * <p>
     * true   操作成功    success  成功
     * false  操作失败    error    异常
     * </p>
     *
     * @params: [flag]
     * @return: com.cloud.web.utils.ResEntity
     * @Author: au .T
     * @Date: 2019/5/5 13:34
     */
    public static ResEntity resEntity(boolean flag) {
        return new ResEntity(flag);
    }

    /**
     * <p>
     * 枚举类提示内容
     * </p>
     *
     * @params: [type, msg]
     * @return: com.cloud.web.utils.ResEntity
     * @Author: au .T
     * @Date: 2019/5/5 13:43
     */
    private static ResEntity resEntity(ResTypeEnum type, ResMsgEnum msg) {
        return new ResEntity(type, msg);
    }

    /**
     * <p>
     * 自定义提示内容
     * 重要提示:  如果可以复用   请在枚举类里面添加 !!!!
     * </p>
     *
     * @params: [type, msg]
     * @return: com.cloud.web.utils.ResEntity
     * @Author: au .T
     * @Date: 2019/5/5 13:43
     */
    public static ResEntity resEntity(ResTypeEnum type, String msg) {
        return new ResEntity(type, msg);
    }

    /**
     * 参数缺失
     *
     * @params: [parames]  缺失的参数
     * @return: com.cloud.web.utils.ResEntity
     * @Author: au .T
     * @Date: 2019/5/5 14:17
     */
    public static ResEntity missingParameter(String parames) {
        return new ResEntity(parames);
    }


}
