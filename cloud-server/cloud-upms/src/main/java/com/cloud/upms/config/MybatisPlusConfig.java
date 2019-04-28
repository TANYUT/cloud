package com.cloud.upms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.cloud.upms.config.DataScope.DataScopeInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 *
 * </p>
 *
 * @Title MybatisPlusConfig.java
 * @Package com.cloud.upms.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/28 18:07
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
