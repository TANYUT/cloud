package com.cloud.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
@Slf4j
@SpringBootApplication
public class DemoServerB_App {
    public static void main(String[] args) {
        log.info("========== DemoGatewayApp starting... ==========");
        SpringApplication.run(DemoServerB_App.class, args);
        log.info("========== DemoGatewayApp started... ==========");
    }


}
