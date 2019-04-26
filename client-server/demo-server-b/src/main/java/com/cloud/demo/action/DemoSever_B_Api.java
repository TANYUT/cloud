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
@Api(value = "DemoSever_B_Api", tags = "DemoSever_B_Api")
public class DemoSever_B_Api {

    @Value("${server.port}")
    String port;
    @Value("${demoserverb}")
    String demoTest;

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
