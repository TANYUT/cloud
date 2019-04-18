package com.cloud.webflux.demo;

import com.cloud.webflux.demo.util.SampleSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_1.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 16:31
 */
public class MonoFlux_1 {

    public static void main(String[] args) {
        Mono.just("");
        Flux.range(1, 3)
                //消费产生的数据
                //.subscribe(System.err::println);
                .subscribe(i -> System.err.println(i));

        Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("go to 4");
                }).subscribe(i -> System.err.println(i),
                //处理异常
                //  Throwable::printStackTrace
                ex -> System.err.println(ex.getMessage())
        );

        Flux.range(1, 4)
                .subscribe(System.err::println,
                        Throwable::printStackTrace,
                        //订阅时定义错误和完成信号的处理
                        () -> System.err.println("end")
                );
        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        Flux<Integer> flux =
                Flux.range(1, 4);
        flux.subscribe(
                System.out::println,
                ex -> System.out.println(ex.getMessage()),
                () -> System.out.println("end2"),
                s -> ss.request(10)
        );
        flux.subscribe(ss);

        System.exit(0);
    }
}
