package com.test.chapter_2_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * <p>
 *
 * </p>
 *
 * @Title MyEventSource.java
 * @Package com.test.chapter_2_2
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/19 19:19
 */
public class MyEventSource {
    private List<MyEventListener> listeners;

    public MyEventSource() {
        this.listeners = new ArrayList<>();
    }

    public void register(MyEventListener listener) {
        listeners.add(listener);
    }

    public void newEvent(MyEvent event) {
        for (MyEventListener listener :
                listeners) {
            listener.onNewEvent(event);
        }
    }

    public void eventStopped() {
        for (MyEventListener listener :
                listeners) {
            listener.onEventStopped();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyEvent {
        private Date timeStemp;
        private String message;
    }
}
