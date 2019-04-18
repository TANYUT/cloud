package com.cloud.webflux.demo;

import com.cloud.webflux.demo.util.MyEventListener;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_4.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 17:35
 */
public class MonoFlux_4 {
    public static void main(String[] args) throws InterruptedException {
        Flux.create((sink) -> {
            new MyEventListener<String>() {
                public void onDataChunk(List<String> chunk) {
                    for (String s : chunk) {
                        sink.next(s);
                    }
                }

                public void processComplete() {
                    sink.complete();
                }
            };
        }).subscribe(System.out::println);
        CountDownLatch countDownLatch = new CountDownLatch(1);  // 2
        String s = "Zip two sources together, that is to say wait for all " +
                "the sources to emit one element and combine these elements once into a " +
                "Tuple2.";
        Flux.zip(Flux.fromArray(s.split("\\s+"))
                , Flux.interval(Duration.ofMillis(200)))
//                .subscribe(t -> System.err.println(t.getT1()), null, countDownLatch::countDown)
        ;
        countDownLatch.await(10, TimeUnit.SECONDS);

        //zip同步数据
        Flux.zip(Flux.fromArray("1,2,3".split(","))
                , Flux.fromArray("a,b,c".split(",")))
                .subscribe(objects -> {
                    System.err.println(objects.getT1() + objects.getT2());
                });

        //handle 过滤
        String[] ss = {"1", "2", "3"};
        Mono.just("foo").subscribe();
        Flux.fromArray(ss)
                .handle((i, sink) -> {
                    if (!"2".equals(i)) {
                        sink.next(i);
                    }
                })
//                .subscribe(System.out::println)
        ;
        Flux.interval(Duration.ofMillis(300), Schedulers.newSingle("test")).subscribe(System.err::println);
    }


}
