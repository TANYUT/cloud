package com.cloud.webflux.demo;

import com.cloud.webflux.demo.util.SampleSubscriber;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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
                s -> ss .request(10)
        );
        flux.subscribe(ss);
        Mono.just("foo").subscribe(System.out::println);
        Mono.just("tst").subscribe(System.err::println);
        Mono.fromRunnable(() -> {
            System.err.println("111111");
            new RuntimeException("yichang");
        }).subscribe(System.err::println, System.out::println);
        long start = System.currentTimeMillis();
        Disposable disposable = Mono.delay(Duration.ofSeconds(2)).subscribe(n -> {
            System.out.println("生产数据源：" + n);
            System.out.println("当前线程ID：" + Thread.currentThread().getId() + ",生产到消费耗时：" + (System.currentTimeMillis() - start));
        });
        System.out.println("主线程" + Thread.currentThread().getId() + "耗时：" + (System.currentTimeMillis() - start));
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
//        Flux.intervalMillis(1000).subscribe(System.out::println);

        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);
        System.err.println("整体结束");
        while (!disposable.isDisposed()) {
            System.err.println("1");
        }


        int a = 1;
        int b =
                a = 2;
        System.exit(0);
    }
}
