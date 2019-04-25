package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;


/**
 * <p>
 *
 * </p>
 *
 * @Title DemoApp.java
 * @Package com.cloud.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/31 18:57
 */
//@RefreshScope//刷新配置
@EnableDiscoveryClient
@SpringCloudApplication
public class DemoServerA_App {
    public static void main(String[] args) {
        SpringApplication.run(DemoServerA_App.class, args);
    }

}
