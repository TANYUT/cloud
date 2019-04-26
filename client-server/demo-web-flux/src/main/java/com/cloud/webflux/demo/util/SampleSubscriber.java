package com.cloud.webflux.demo.util;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

/**
 * <p>
 * 建议你同时重写 hookOnError、hookOnCancel，
 * 以及 hookOnComplete 方法。
 * 你最好也重写 hookFinally 方法。
 * SampleSubscribe 确实是一个最简单的实现了 请求有限个数元素的 Subscriber
 * </p>
 *
 * @Title SampleSubscriber.java
 * @Package com.cloud.webflux.demo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 16:53
 */
public class SampleSubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value);
        request(1);
    }


}
