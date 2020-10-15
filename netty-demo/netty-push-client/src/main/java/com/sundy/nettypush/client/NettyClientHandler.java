package com.sundy.nettypush.client;

import com.sundy.share.dto.BaseMsg;
import com.sundy.share.dto.PingMsg;
import com.sundy.share.dto.ReqMsg;
import com.sundy.share.enums.MsgType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author plus.wang
 * @description netty客户端处理器
 * @date 2018/8/23
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {

    private NettyClient nettyClient;

    private static final Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);

    public NettyClientHandler(NettyClient client) {

        this.nettyClient = client;
    }

    /**
     * 客户端空闲时执行的方法,心跳的实现,后期失败一定次数后断开通道重连
     *
     * @param ctx
     * @param evt
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    PingMsg pingMsg = new PingMsg();
                    pingMsg.setClientId(nettyClient.getClientId());
                    ctx.writeAndFlush(pingMsg);
                    logger.info("NettyClientHandler.userEventTriggered send pingMsg clientId : {}", nettyClient.getClientId());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("NettyClientHandler.channelActive clientId : " + nettyClient.getClientId() + " 连接服务端成功");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        logger.error("NettyClientHandler.exceptionCaught error : ", cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) {

        MsgType msgType = baseMsg.getType();

        switch (msgType) {

            case PING: {
                //客户端接收到服务端心跳回应
                logger.info("NettyClientHandler.channelRead0 client receive reply pingMsg");
            }
            break;

            case ASK: {

                ReqMsg reqMsg = (ReqMsg) baseMsg;

                logger.info("NettyClientHandler.channelRead0 clientId: " + nettyClient.getClientId() + " 收到服务端推送消息: " + reqMsg.getJsonStr() + " reqId: " + reqMsg.getReqId());

                reqMsg.setClientId(nettyClient.getClientId());

                reqMsg.setType(MsgType.REPLY);

                reqMsg.setJsonStr("{'reply':'客户端：" + nettyClient.getClientId() + " 已收到服务端推送数据'}");

                channelHandlerContext.writeAndFlush(reqMsg);
            }
            break;

            case REPLY: {

                ReqMsg replyMsg = (ReqMsg) baseMsg;

                String reqId = replyMsg.getReqId();

                String jsonStr = replyMsg.getJsonStr();

                logger.info("NettyClientHandler.channelRead0 receive replyMsg from server " + " reqId : " + reqId + " jsonStr : " + jsonStr);
            }
            break;

            default:
                break;
        }

        ReferenceCountUtil.release(baseMsg);
    }
}
