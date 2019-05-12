package com.cloud.webflux.entity;

import lombok.Data;

/**
 * <p>
 * 商品
 * </p>
 *
 * @Title Product.java
 * @Package com.cloud.webflux.entity
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/13 15:00
 */
@Data
public class Product {
    private String name;
    private double price;
}
