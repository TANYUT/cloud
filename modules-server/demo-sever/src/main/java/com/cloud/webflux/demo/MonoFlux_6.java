package com.cloud.webflux.demo;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_6.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/13 20:08
 */
public class MonoFlux_6 {
    public static void main(String[] args) throws InterruptedException {
//        Flux.interval(Duration.ofMillis(300))
//                .map(v -> {
//                    if (v < 3) {
//                        return "tick" + v;
//                    }
//                    throw new RuntimeException("v>3");
//                })
//                // 	elapsed 会关联从当前值与上个值发出的时间间隔
//                .elapsed()
//                //重试
//                .retry(2)
//                .subscribe(System.out::println, System.err::println);
//
//        Thread.sleep(6000);

//        Flux.<String>error(new IllegalArgumentException())
//                .retryWhen(com -> com
//                        .zipWith(Flux.range(1, 4),
//                                (ex, index) -> {
//                                    if (index < 4) return index;
//                                    else throw Exceptions.propagate(ex);
//                                }));

        Flux.<String>error(new IllegalArgumentException())
                .retryWhen(companion -> companion
                        .zipWith(Flux.range(1, 4),
                                (error, index) -> {
                                    if (index < 3) return index;
                                    else return error;
                                }).doOnNext(m->System.out.println(m))
                ).subscribe(System.out::println, System.err::println);
    }
}
