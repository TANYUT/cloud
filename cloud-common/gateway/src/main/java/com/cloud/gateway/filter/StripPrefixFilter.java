package com.cloud.gateway.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.gateway.constant.CodeEnum;
import com.sun.media.jfxmediaimpl.MediaDisposer;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

/**
 * <p>
 * 重写StripPrefix  不用再配置文件配置 filter: - StripPrefix=1
 * </p>
 *
 * @Title StripPrefixFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/7 16:21
 */
@Component
@Configuration
public class StripPrefixFilter implements GlobalFilter, Ordered {

    private Object JSONObject;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.err.println("stripPrefix");
        //剥离前缀
        ServerHttpRequest request = exchange.getRequest().mutate()
                //  .headers(httpHeaders -> httpHeaders.remove("from")) //清洗请求头中from 参数
                .build();
        addOriginalRequestUrl(exchange, request.getURI());
        String path = request.getURI().getRawPath();
        String newPath = "/" + Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
                .skip(1L).collect(Collectors.joining("/"));
        ServerHttpRequest newRequest = request.mutate()
                .path(newPath).build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
        return chain.filter(exchange.mutate()
                .response(new ServerHttpResponseDecorator(exchange.getResponse()) {
                    @Override
                    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                        ServerHttpResponse res = exchange.getResponse();
                        System.err.println(res.getStatusCode().value());
                        if (true) {
                            JSONObject json = JSONUtil.createObj();
                            json.put("status", res.getStatusCode().value());
                            json.put("msg", res.getStatusCode().getReasonPhrase());
                            json.put("body", CodeEnum.resolve(res.getStatusCode().value()));
                            Mono<JSONObject> mono = Mono.just(json);
                            Mono<Void> mono1 = Mono.when(i -> {
                                json.put("status", res.getStatusCode().value());
                                json.put("msg", res.getStatusCode().getReasonPhrase());
                                json.put("body", CodeEnum.resolve(res.getStatusCode().value()));
                                return;
                            });
//                            Mono.just(json).and();
                            return Mono.error(new Throwable(""));
                        }
                        return res.writeWith(body);
                    }
                })
                .request(newRequest.mutate().build()).build()).then(Mono.fromRunnable(() -> {
            System.err.println("test");

        }));
    }


    public static JSONObject jsonObject() {
        JSONObject json = JSONUtil.createObj();
        json.put("status", "ss");
        json.put("msg", "msg");
        return json;
    }

    @Override
    public int getOrder() {
        return -999999999;
    }

    public static void main(String[] args) {
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


    }


}
