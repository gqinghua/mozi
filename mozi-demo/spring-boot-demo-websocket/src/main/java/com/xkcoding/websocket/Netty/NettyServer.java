//package com.xkcoding.websocket.Netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import org.springframework.stereotype.Component;
//
///**
// *
// * guoqinghua
// *
// */
//@Component
//public class NettyServer {
//
//    public static void main(String[] args) {
//        //端口号,可以设立配置文件
//        new NettyServer().bing(7397);
//    }
//
//    private void bing(int port) {
//        //配置服务端NIO线程组
//        EventLoopGroup parentGroup = new NioEventLoopGroup(); //NioEventLoopGroup extends MultithreadEventLoopGroup Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
//        EventLoopGroup childGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(parentGroup, childGroup)
//                    .channel(NioServerSocketChannel.class)    //非阻塞模式
//                    .option(ChannelOption.SO_BACKLOG, 128)
//                    .childHandler(new MyChannelInitializer());
//            ChannelFuture f = b.bind(port).sync();
//            System.out.println("郭清华提醒=> Reader Idle");
//            f.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            childGroup.shutdownGracefully();
//            parentGroup.shutdownGracefully();
//        }
//
//    }
//
//
//}
