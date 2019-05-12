package com.cloud.webflux.demo;

import reactor.core.publisher.Flux;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_5.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/13 18:36
 */
public class MonoFlux_5 {

    public static void main(String[] args) {
        Flux.range(0, 5)
                .map(v -> {
                    String s = null;
//                    s.equals(String.valueOf(v));
                    return v;
                })
                .map(v -> (v))
                .subscribe(System.out::println,
                        Throwable::printStackTrace);

        Flux.just(10)
                .map(v -> {
                    String s = null;
                    s.equals(String.valueOf(v));
                    return v;
                })
                .map(v -> v)
                .onErrorReturn(Integer.valueOf("1")).subscribe(System.out::println);

        Flux.just("10")
                .map(v -> {
                    String s = null;
                    s.equals(String.valueOf(v));
                    return v;
                })
                .onErrorReturn(MonoFlux_5::test, "recovered10")
                .subscribe(System.out::println);
    }


    private static boolean test(Throwable e) {
        System.err.println(e.getMessage());
        System.err.println(e.getMessage().equals("null"));
        return e.getMessage().equals("null");
//        return true;
    }
}
