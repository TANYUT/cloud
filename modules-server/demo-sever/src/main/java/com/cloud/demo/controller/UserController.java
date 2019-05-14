package com.cloud.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @Title: UserController.java
 * @Package: com.cloud.demo.controller
 * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/12 13:53
 */
@RestController
public class UserController {

    @GetMapping("getUser")
    public Object getUser(Authentication authentication) {
        return authentication;
    }


}
