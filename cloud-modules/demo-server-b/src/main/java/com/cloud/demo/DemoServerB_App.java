package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * <p>
 *
 * </p>
 *
 * @Title DemoGatewayApp.java
 * @Package com.cloud.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/31 18:57
 */
@EnableDiscoveryClient
@SpringCloudApplication
public class DemoServerB_App {
    public static void main(String[] args) {
        SpringApplication.run(DemoServerB_App.class, args);
    }


}
