package com.cloud.web.security.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title IgnoreUrlConfig.java
 * @Package com.cloud.web.security.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/5 12:58
 */
@Data
@RefreshScope
@Component
//@ConditionalOnExpression("!'${ignore}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore")
public class IgnoreUrlConfig {
    /**
     * 放行url,放行的url不再被安全框架拦截
     */
    private List<String> urls = new ArrayList<>();
}
