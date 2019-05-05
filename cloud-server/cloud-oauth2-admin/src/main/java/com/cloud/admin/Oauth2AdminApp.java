package com.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
//@ComponentScan(basePackages="")
public class Oauth2AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AdminApp.class, args);
    }
}
