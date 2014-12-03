package com.ygxhj.transport.cache;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelContextCache {
	
	private static final ChannelContextCache instance = new ChannelContextCache();
	private ChannelContextCache(){}
	
	
	private Map<String, ChannelHandlerContext> context = new ConcurrentHashMap<String, ChannelHandlerContext>();
	
	public static ChannelContextCache getInstance() {
		return instance;
	}
	
	public void addContext(ChannelHandlerContext ctx){
		context.put(ctx.channel().id().asLongText(), ctx);
	}
	
	public void removeContext(ChannelHandlerContext ctx){
		context.remove(ctx.channel().id().asLongText());
	}
	
	public int size(){
		return context.size();
	}
	
}
