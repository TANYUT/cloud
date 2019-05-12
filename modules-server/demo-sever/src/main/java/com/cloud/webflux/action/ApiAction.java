package com.cloud.webflux.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @Title ApiAction.java
 * @Package com.cloud.webflux.action
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/12 19:18
 */
@RestController
public class ApiAction {
    @GetMapping("/index")
    public Mono<ServerResponse> index(String naem) {
        return ServerResponse
                .ok()
                .syncBody(naem);
    }

    /**
     * @return
     */

    @GetMapping("get")
    public Mono<String> get() {
        return Mono.just("get");
    }


}
