package com.ygxhj.common.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import com.ygxhj.common.message.OutputMessage;

public class MessageService {
	public static ByteBuf getMsg(byte msg[]){
		ByteBuf buf = Unpooled.buffer(msg.length);
		OutputMessage om1 = new OutputMessage();
		om1.putInt(msg.length);
		for (byte ii : msg) {
			om1.putByte(ii);
		}
		nextMessage(buf, om1.getBytes());
		return buf;
	}
	private static void nextMessage(ByteBuf buf , byte[] message) {
		buf.writeBytes(message);
	}
}
