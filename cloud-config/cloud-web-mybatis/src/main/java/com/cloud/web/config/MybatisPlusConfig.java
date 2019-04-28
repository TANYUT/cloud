package com.cloud.web.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.cloud.web.bean.DataScopeInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 *
 * </p>
 *
 * @Title MybatisPlusConfig.java
 * @Package com.cloud.web.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/28 20:54
 */
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }
}
