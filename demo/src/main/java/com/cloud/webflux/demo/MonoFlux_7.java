package com.cloud.webflux.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import static java.lang.Thread.sleep;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_7.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 20:44
 */
public class MonoFlux_7 {
    public static void main(String[] args) throws Exception {
        Flux<String> source = Flux.just("foo", "bar");
        Flux.create(emitter -> {
            for (int i = 0; i < 10; i++) {
                if (emitter.isCancelled()) {
                    return;
                }
                System.out.println("source created " + i);
                emitter.next(i);
            }
        }).doOnNext(s -> System.out.println("doNonext" + s))
                .subscribeOn(Schedulers.newElastic("aaaa"))
                .subscribe(sonsumer -> {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println("huiquId" + sonsumer);
                });

        sleep(1000);

    }
}
