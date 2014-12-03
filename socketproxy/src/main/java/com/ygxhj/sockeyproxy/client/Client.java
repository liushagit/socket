package com.ygxhj.sockeyproxy.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.ygxhj.common.message.Constants;
import com.ygxhj.common.message.MessageService;

public class Client {

	private ChannelFuture future;
	
	public Client(){
		init();
	}
	public void init(){
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap strap = new Bootstrap();
			strap.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline pipeline = ch.pipeline();
					pipeline.addFirst("handler",new DefaulteClientHandler());
					pipeline.addFirst("decoder", new LengthFieldBasedFrameDecoder(
							32767, 0, 4, 0, 4));
				}
			});
			
			future = strap.connect(Constants.HOST, Constants.PORT).sync();
//			future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void send(){
		if(future.channel().isWritable()){
			ClientCache.getInstance().addSendTime(future.channel());
			ByteBuf buf = MessageService.getMsg("test".getBytes());
			future.channel().writeAndFlush(buf);
		}
	}
}
