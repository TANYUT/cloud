package com.cloud.webflux.entity;

import lombok.Data;

import java.time.Instant;

/**
 * <p>
 *
 * </p>
 *
 * @Title User.java
 * @Package com.cloud.webflux.entity
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/12 19:33
 */
@Data
public class User {
    private String id;
    private String name;
    private Instant instant;


    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
