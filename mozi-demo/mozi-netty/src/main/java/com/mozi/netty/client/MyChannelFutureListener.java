package com.mozi.netty.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

import java.util.concurrent.TimeUnit;


public class MyChannelFutureListener implements ChannelFutureListener {
    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (channelFuture.isSuccess()) {
            System.out.println("i郭清华提醒=> Reader Idle");
            return;
        }
        final EventLoop loop = channelFuture.channel().eventLoop();
        loop.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    new NettyClient().connect("127.0.0.1", 7397);
                    System.out.println("郭清华提醒=> Reader Idle");
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println("郭清华提醒=> Reader Idle");
                }
            }
        }, 1L, TimeUnit.SECONDS);
    }
}
