package com.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>
 *
 * </p>
 *
 * @Title ConfigApplication.java
 * @Package com.cloud.config
 * @Author <a href="mailto:au_t@qq.com">au .T</a>
 * @Date 2019/3/20 16:00
 */
@Slf4j
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
