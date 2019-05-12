package com.cloud.webflux.netty.demo.netty;

/**
 * <p>
 *
 * </p>
 *
 * @Title Server.java
 * @Package com.cloud.com.netty
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/23 12:56
 */
public class Server {
    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        Server.start();
    }

}
