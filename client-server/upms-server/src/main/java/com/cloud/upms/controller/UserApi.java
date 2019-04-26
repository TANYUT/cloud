package com.cloud.upms.controller;

import cn.hutool.json.JSONObject;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title UserApi.java
 * @Package com.cloud.upms.controller
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/6 14:43
 */
@RequestMapping("/user")
@RestController
public class UserApi {
    private final String userName = "admin";
    private final String passWord = "12345";

    @GetMapping("/logIn")
    public Object logIn(@RequestParam Map<String, String> obj) {
        return obj;
    }
}
