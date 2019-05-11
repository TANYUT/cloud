package com.cloud.admin.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * <p>
 *
 * </p>
 *
 * @Title: PasswordUtil.java
 * @Package: com.cloud.admin.utils
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/7 17:18
 */
public class PasswordUtil {

    public static String encode(String password) {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password);
    }
}
