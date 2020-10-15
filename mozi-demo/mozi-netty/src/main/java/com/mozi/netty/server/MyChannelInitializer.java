package com.mozi.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.Charset;

/**
 * a. ChannelInitializer继承于ChannelInboundHandler接口
 *
 * b. ChannelInitializer是一个抽象类，不能直接使用
 *
 * ChannelInitializer什么时候会被调用？
 *
 * 以ServerBootstrap启动这一场景为例
 *
 * 在ServerBootstrap.init()方法中，负责accept新链接的Channel的pipeline被添加了一个ChannelInitializer
 *
 * 由于此时这个Channel还没有被register到EventLoop，于是在addLast方法的调用链中，会给pipeline添加一个PendingHandlerAddedTask，其目的是在Channel被register到EventLoop的时候，触发一个回调事件
 *
 * 然后在AbstractBootstrap.initAndRegister()方法中，这个Channel会被register到boss EventLoopGoup，接着会被register到boss EventLoopGoup中的某一个具体的EventLoop
 *
 * 在AbstractChannel.register0()方法中，之前注册的PendingHandlerAddedTask会被调用，经过一系列调用之后，ChannelInitializer.handleAdded()方法会被触发：
 *
 * ChannelInitializer的主要目的是为程序员提供了一个简单的工具，用于在某个Channel注册到EventLoop后，对这个Channel执行一些初始化操作。ChannelInitializer虽然会在一开始会被注册到Channel相关的pipeline里，但是在初始化完成之后，ChannelInitializer会将自己从pipeline中移除，不会影响后续的操作。
 *
 * 使用场景：
 *
 * a. 在ServerBootstrap初始化时，为监听端口accept事件的Channel添加ServerBootstrapAcceptor
 *
 * b. 在有新链接进入时，为监听客户端read/write事件的Channel添加用户自定义的ChannelHandler
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        /**
         * 心跳监测
         * 1、readerIdleTimeSeconds 读超时时间
         * 2、writerIdleTimeSeconds 写超时时间
         * 3、allIdleTimeSeconds    读写超时时间
         * 4、TimeUnit.SECONDS 秒[默认为秒，可以指定]
         */
        channel.pipeline().addLast(new IdleStateHandler(2, 2, 2));
        // 基于换行符号
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }

}
