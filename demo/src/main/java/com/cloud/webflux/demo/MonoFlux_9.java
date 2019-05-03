package com.cloud.webflux.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_9.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/19 20:05
 */
public class MonoFlux_9 {
    public static void main(String[] args) {
        Flux.range(0, 10)
//                .log()    // 1
                .publishOn(Schedulers.newParallel("myParallel"))
//                .log()    // 2
                .subscribeOn(Schedulers.newElastic("myElastic"))
                .log()    // 3
                .blockLast();
        System.exit(0);
    }
}
