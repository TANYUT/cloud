package com.cloud.webflux.netty.demo.echo.sever;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * <p>
 * 通过 ChannelHandler 来实现服务器的逻辑
 * </p>
 *
 * @Title EchoServerHandler.java
 * @Package com.cloud.netty.demo.echo
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/23 14:31
 */
@ChannelHandler.Sharable  //标识这类的实例之间可以在 channel 里面共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * <p>
     * 每个信息入站 都会调用
     * </p>
     *
     * @params: [ctx, msg]
     * @Author: au .T
     * @Date: 2019/4/23 14:34
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);//  将所接收的消息返回给发送者。注意，这还没有冲刷数据
    }

    /**
     * <p>
     * 通知处理器 最后的 channelRead()  是当前批处理中的的最后一条消息调用
     * </p>
     *
     * @params: [ctx]
     * @Author: au .T
     * @Date: 2019/4/23 14:35
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)//冲刷所有待审消息到远程节点。关闭通道后，操作完成
                .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * <p>
     * 读操作时 捕获异常时调用
     * </p>
     *
     * @params: [ctx, cause]
     * @Author: au .T
     * @Date: 2019/4/23 14:37
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();//打印异常堆栈跟踪
        ctx.close();//关闭通道
    }
}
