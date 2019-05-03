package com.cloud.webflux.demo;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_2.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/13 17:05
 */
public class MonoFlux_2 {
    public static void main(String[] args) {
        Flux<String> source = Flux.just("aut");
        source.map(String::toUpperCase)
                .subscribe(new BaseSubscriber<String>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        super.hookOnSubscribe(subscription);
                        System.err.println();
                        request(1);

                    }

                    @Override
                    protected void hookOnNext(String value) {
                        super.hookOnNext(value);
                        request(1);
                    }
                });

    }
}
