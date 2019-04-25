package com.cloud.log.publisher;

import com.cloud.log.annotation.ApiLog;
import com.cloud.log.entity.LogApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * API日志信息事件发送
 * </p>
 *
 * @Title ApiLogPublisher.java
 * @Package com.cloud.log.publisher
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/24 18:07
 */
@Slf4j
public class ApiLogPublisher {
    private static ApplicationContext context;

    public static void publishEvent(String methodName, String methodClass, ApiLog apiLog, long time) {
//        HttpServletRequest request = HttpServletRequest;
        LogApi logApi = new LogApi();
        logApi.setType("0");
        logApi.setTitle(apiLog.value());
        logApi.setTime(String.valueOf(time));
        logApi.setMethodClass(methodClass);
        logApi.setMethodName(methodName);
        Map<String, Object> event = new HashMap<>(16);
        event.put("log", logApi);
//        event.put("request", request);
        publishEvent(new ApiLogEvent(event));
    }

    /**
     * 系统日志事件
     *
     * @author Chill
     */
    public static class ApiLogEvent extends ApplicationEvent {
        public ApiLogEvent(Map<String, Object> source) {
            super(source);
        }

    }

    public static void publishEvent(ApplicationEvent event) {
        if (context == null) {
            return;
        }
        try {
            context.publishEvent(event);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
