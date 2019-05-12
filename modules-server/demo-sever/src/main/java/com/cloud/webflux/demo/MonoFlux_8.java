package com.cloud.webflux.demo;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @Title MonoFlux_8.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/14 14:58
 */
public class MonoFlux_8 {

    public static void main(String[] args) {
        Flux.range(1, 6)
                .doOnRequest(n -> System.out.println("req  " + n + "  val"))
                .subscribe(new Base<>());
    }

    public static class Base<T> extends BaseSubscriber<T> {

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
//            super.hookOnSubscribe(subscription);
            System.out.println("hookOnSubscribe  Subscribed  and make a request...");
            request(1); // 5  订阅时首先向上游请求1个元素；
        }

        protected void hookOnNext(T value) {
            System.err.println("hookOnNext....");
            super.hookOnNext(value);
            try {
                TimeUnit.SECONDS.sleep(1);  // 7  sleep 1秒钟来模拟慢的Subscriber；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (String.valueOf(value).equals("3")) {
//                hookOnCancel();
                throw new RuntimeException("抛出异常");
            }
            System.out.println("Get value [" + value + "]");    // 8打印收到的元素；
            request(1); // 9 每次处理完1个元素后再请求1个。
        }

        @Override
        protected void hookOnComplete() {
            //完成的钩子
            System.out.println("hookOnComplete");
//            super.hookOnComplete();
        }

        @Override
        protected void hookOnError(Throwable throwable) {
            //异常钩子
//            super.hookOnError(throwable);
            System.err.println(throwable);
            System.err.println(throwable.getMessage());
            System.out.println("hookOnError");
        }

        @Override
        protected void hookOnCancel() {
            //取消的钩子
//            super.hookOnCancel();
            System.out.println("hookOnCancel  取消的钩子");
        }


        @Override
        protected void hookFinally(SignalType type) {
            //最后的钩子
            System.err.println(type);
            System.out.println("hookFinally  最后的钩子");
//            super.hookFinally(type);
        }
    }
}
