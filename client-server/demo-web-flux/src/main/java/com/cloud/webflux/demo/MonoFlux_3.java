package com.cloud.webflux.demo;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_3.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 17:14
 */
public class MonoFlux_3 {

    public static void main(String[] args) {
        Flux.generate(
                () -> 0,
                (state, skin) -> {
                    skin.next("3 x " + state + "=" + 3 * state);
                    if (state == 10) {
                        skin.complete();
                    }
                    return state + 1;
                }
        ).subscribe(System.err::println);


        Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    System.err.println(i);
                    sink.next("3 x " + i + " = " + 3 * i);
                    if (i == 10) sink.complete();
                    return state;
                }
        ).subscribe(System.out::println);


        Flux.generate(AtomicLong::new, (statu, sink) -> {
            long i = statu.getAndIncrement();
            sink.next("3 x " + i + " = " + 3 * i);
            if (i == 10) sink.complete();
            return statu;
        }, statu -> System.err.println("statu" + statu))
                .subscribe(System.out::println);
    }
}
