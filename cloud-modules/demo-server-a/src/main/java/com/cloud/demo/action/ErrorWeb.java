package com.cloud.demo.action;

import com.cloud.demo.cinfig.ResBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title ErrorWeb.java
 * @Package com.cloud.gateway.config.weberror
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/3 20:34
 */
@Slf4j
@RestControllerAdvice
public class ErrorWeb {
    /**
     * 全局异常.
     * ServerHttpResponseDecorator
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception e) {
//        log.error("全局异常信息 ex={}", e.getMessage(), e);
        Map map = new HashMap();
        map.put("code", "123");
        map.put("msg", e.getMessage());
        return map;
    }
}
