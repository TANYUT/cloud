package com.test.chapter_2_2;

/**
 * <p>
 *
 * </p>
 *
 * @Title MyEventListener.java
 * @Package com.test.chapter_2_2
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/19 19:19
 */
public interface MyEventListener {
    void onNewEvent(MyEventSource.MyEvent event);

    void onEventStopped();
}
