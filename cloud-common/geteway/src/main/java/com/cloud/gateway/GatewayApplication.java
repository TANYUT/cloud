package com.cloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * <p>
 *
 * </p>
 *
 * @Title GatewayServerApplication.java
 * @Package com.cloud.gateway
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 17:05
 */
@Slf4j
@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
