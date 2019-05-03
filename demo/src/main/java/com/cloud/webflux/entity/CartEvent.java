package com.cloud.webflux.entity;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @Title CartEvent.java
 * @Package com.cloud.webflux.entity
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/13 15:05
 */
@Data
public class CartEvent {
    private Product product;
    private int quantity;
}
