package com.cloud.oauthupms;

import com.cloud.web.annotation.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@ClientConfig
public class Oauth2UpmsApp {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2UpmsApp.class, args);
    }
}
