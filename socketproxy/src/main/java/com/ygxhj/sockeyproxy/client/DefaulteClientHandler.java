package com.ygxhj.sockeyproxy.client;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class DefaulteClientHandler extends ChannelHandlerAdapter{

	Logger logger = Logger.getLogger(DefaulteClientHandler.class);
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		int time = ClientCache.getInstance().getTime(ctx.channel());
		if(time > 10){
			logger.info("proxy Time=========" + ClientCache.getInstance().getTime(ctx.channel()));
		}
		
		
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
//		ctx.writeAndFlush(MessageService.getMsg("test".getBytes()));
		
	}

}
