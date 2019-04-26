package com.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringCloudApplication
public class SptingConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(SptingConfigApp.class, args);
    }

}
