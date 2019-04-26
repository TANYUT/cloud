package com.cloud.demo.action;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title Api.java
 * @Package com.cloud.demo.action
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/31 19:12
 */
@RestController
@RequestMapping("/api")
@Api(value = "DemoSever_A_Api", tags = "DemoSever_A_Api")
public class DemoSever_A_Api {
    @Autowired
    HttpServletRequest request;
    @Value("${server.port}")
    String port;
    @Value("${demoservera}")
    String demoTest;

    @Value("${rest.api.names}")
    String[] apiNames;

    @GetMapping("/api")
    public Object api() {
        return apiNames;
    }

    @GetMapping("/port")
    public Object port() {
        Map<String, String> map = new HashMap<>();
        map.put("port", port);
        return map;
    }

    @GetMapping("/nacos/test")
    public Object nacosTest() {
        return demoTest;
    }

    @GetMapping("/head")
    public Object head() {
        String head = request.getHeader("demoHeader");
        Map<String, String> map = new HashMap<>();
        map.put("head", head);
        return map;
    }

    @GetMapping("/index")
    public Object index() {
        Map<String, String> map = new HashMap<>();
        map.put("index", "DemoSever_A_Api");
        return map;
    }

    @GetMapping("/error")
    public Object error() {
        if (true) {
            throw new RuntimeException("抛出RuntimeException异常");
        }
        return null;
    }
}
