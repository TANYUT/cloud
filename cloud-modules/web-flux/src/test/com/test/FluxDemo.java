package com.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import org.junit.Test;

import java.security.SecureRandom;
import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @Title FluxDemo.java
 * @Package com.test
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/12 21:19
 */
public class FluxDemo {
    private Flux<Integer> generateFluxFrom1To6() {
        return Flux.just(1, 2, 3, 4, 5, 6);
    }

    private Mono<Integer> generateMonoWithError() {
        return Mono.error(new Exception("some error"));
    }

    @Test
    public void testViaStepVerifier() {
        StepVerifier.create(generateFluxFrom1To6())
                .expectNext(1, 2, 3, 4, 5, 6)
                .expectComplete()
                .verify();
        StepVerifier.create(generateMonoWithError())
                .expectErrorMessage("some error")
                .verify();
        StepVerifier.create(Flux.range(1, 6)    // Flux.range(1, 6)用于生成从“1”开始的，自增为1的“6”个整型数据；
                // map接受lambdai -&gt; i * i为参数，表示对每个数据进行平方；
                .map(i -> i * i))
                //验证新的序列的数据
                .expectNext(1, 4, 9, 16, 25, 36)
                .expectComplete();  // verifyComplete()相当于expectComplete().verify()。
        Flux.range(0, 6)
                .map(i -> i * i)
                .doOnError(ex -> System.err.println(ex.getMessage()))
                .doOnNext(System.err::println)
                .subscribe(System.err::println,
                        e -> e.getMessage(),
                        () -> System.err.println("run"));

        StepVerifier.create(
                Flux.just("flux", "mono")
                        .flatMap(s -> Flux.fromArray(s.split("\\s*"))//对每个字符串  s  拆分成字节流
                                //延迟毫秒
                                .delayElements(Duration.ofMillis(1000)))
                        //对每个元素打印（注doOnNext方法是“偷窥式”的方法，不会消费数据流）
                        .doOnNext(System.err::println))
                //验证是否发出了8个元素。
                .expectNextCount(8)
                .verifyComplete();
    }
}
