package com.ygxhj.transport.handler;

import org.apache.log4j.Logger;

import com.ygxhj.common.message.MessageService;
import com.ygxhj.transport.cache.ChannelContextCache;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class DefaulteHandler extends ChannelHandlerAdapter {

	Logger logger = Logger.getLogger(DefaulteHandler.class);
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ctx.writeAndFlush(MessageService.getMsg("response".getBytes()));
		logger.info("handelSize = " + ChannelContextCache.getInstance().size());
		
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		ChannelContextCache.getInstance().addContext(ctx);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		ChannelContextCache.getInstance().removeContext(ctx);
	}

}
