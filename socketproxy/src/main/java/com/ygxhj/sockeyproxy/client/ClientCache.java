package com.ygxhj.sockeyproxy.client;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCache {

	private static final ClientCache instance = new ClientCache();
	
	private ClientCache(){}

	public static ClientCache getInstance() {
		return instance;
	}
	
	Map<String, Long> timeCache = new ConcurrentHashMap<String, Long>();
	
	public void addSendTime(Channel channel){
		timeCache.put(channel.id().asLongText(), System.currentTimeMillis());
	}
	
	public int getTime(Channel channel){
		long end = System.currentTimeMillis();
		long begin = timeCache.get(channel.id().asLongText());
		return (int)(end - begin);
	}
	
}
