package com.cloud.webflux.netty.demo.echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * <p>
 *
 * </p>
 *
 * @Title EchoClientHandler.java
 * @Package com.cloud.netty.demo.echo
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
 * @Date 2019/4/23 14:54
 */
@ChannelHandler.Sharable//@Sharable标记这个类的实例可以在 channel 里共享
public class EchoClientHandler extends
        SimpleChannelInboundHandler<ByteBuf> {
    /**
     * <p>
     * 服务器的连接被建立后调用
     * </p>
     *
     * @params: [ctx]
     * @Author: au .T
     * @Date: 2019/4/23 14:56
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", //当被通知该 channel 是活动的时候就发送信息
                CharsetUtil.UTF_8));
    }

    /**
     * <p>
     * 数据后从服务器接收到调用
     * </p>
     *
     * @params: [ctx, in]
     * @Author: au .T
     * @Date: 2019/4/23 14:57
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             ByteBuf in) {
        System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));//记录接收到的消息
    }

    /**
     * <p>
     * 捕获一个异常时调用
     * </p>
     *
     * @params: [ctx, cause]
     * @Author: au .T
     * @Date: 2019/4/23 14:58
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();//记录日志错误并关闭 channel
        ctx.close();
    }
}