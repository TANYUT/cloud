package com.cloud.log.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @Title ApiLog.java
 * @Package com.cloud.swagger
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/24 18:04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {
    /**
     * 日志描述
     *
     * @return {String}
     */
    String value() default "日志记录";
}
