package com.cloud.webflux.demo.util;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title MyEventListener.java
 * @Package com.cloud.webflux.demo.util
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/13 17:35
 */
public interface MyEventListener<T> {
    void onDataChunk(List<T> chunk);

    void processComplete();
}
