package com.cloud.webflux.action;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * <p>
 *
 * </p>
 *
 * @Title TestController.java
 * @Package com.cloud.webflux.action
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/12 20:00
 */
//@Slf4j
@RestController
@ResponseBody
public class TestController {
    /**
     * 传统的 spring mvc 开发方式
     */
    @GetMapping("/mvc")
    public String mvc() {
        long timeMillis = System.currentTimeMillis();
        System.err.println("mvc() start");
        String result = createStr();
        System.err.println("mvc() end use time {}/ms" + (System.currentTimeMillis() - timeMillis));
        return result;
    }

    private String createStr() {
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "some string";
    }

    /**
     * spring webflux 的开发方式
     */
    @GetMapping("/webflux")
    public Mono<String> webflux() {
        long timeMillis = System.currentTimeMillis();
        System.err.println("webflux() start");
        Mono<String> result = Mono.fromSupplier(this::createStr);
        System.err.println("webflux() end use time {}/ms" + (System.currentTimeMillis() - timeMillis));
        return result;
    }

    /**
     * 使用flux，像流一样返回0-N个元素
     */

//    @GetMapping(value = "/flux")
    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> flux() {
        long timeMillis = System.currentTimeMillis();
        System.err.println("webflux() start");
        List<String> list = new ArrayList<>();
//        Flux<Object> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            list.add("flux data--" + i);
//            return list;
//        }));

        Flux<Object> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("flux data--" + i);
            return i;
        }));
        System.err.println("webflux() end use time {}/ms" + (System.currentTimeMillis() - timeMillis));
        return result;
    }

    @GetMapping(value = "/mono", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Object> mono() {
        long timeMillis = System.currentTimeMillis();
        System.err.println("webflux() /mono");
        List<String> list = new ArrayList<>();
//        () -> {
//            System.err.println("111111");
//            new RuntimeException("yichang");
//        }).subscribe(System.err::println, System.out::println);
        AtomicInteger ii = new AtomicInteger();
        Mono<Object> mo = Mono.fromRunnable(() -> {
            for (int i = 0; i < 10; i++) {
                ii.set(i);
            }

        });
        System.err.println("mono() end use time {}/ms" + (System.currentTimeMillis() - timeMillis));
//        return result;

//        "foo".toMono();
        return mo;
    }
}
