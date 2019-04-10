package com.cloud.demo.cinfig;

/**
 * <p>
 *
 * </p>
 *
 * @Title ResBody.java
 * @Package com.cloud.demo.cinfig
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/7 19:40
 */
public class ResBody<T> {
    private T data;
    private String code = "0";
    private String msg;

    public ResBody(T data) {
        this.data = data;
    }

    public ResBody(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }
}
