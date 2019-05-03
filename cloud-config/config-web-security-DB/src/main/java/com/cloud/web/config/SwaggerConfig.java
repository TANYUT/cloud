package com.cloud.web.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.spring4all.swagger.EnableSwagger2Doc;
import com.spring4all.swagger.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * <p>
 * 目前这个配置只是单个项目的Swagger 的Api 后期需要多个API接口项目聚合想gateway
 * </p>
 *
 * @Title SwaggerConfig.java
 * @Package com.cloud.web.config
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/28 21:07
 */
@EnableSwaggerBootstrapUI
@EnableConfigurationProperties(SwaggerProperties.class)
@EnableSwagger2Doc
public class SwaggerConfig implements
        org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//        org.springframework.web.reactive.config.WebFluxConfigurer
{
    @Override
    public void addResourceHandlers(
//            org.springframework.web.reactive.config.ResourceHandlerRegistry
            org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
                    registry
    ) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
