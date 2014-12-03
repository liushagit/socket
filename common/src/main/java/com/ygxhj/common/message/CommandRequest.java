package com.ygxhj.common.message;


public class CommandRequest {

	private int playerId;
	private String userId;
	private String cmd;
	private byte data[];
	private String adminMsg;
	
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getAdminMsg() {
		return adminMsg;
	}
	public void setAdminMsg(String adminMsg) {
		this.adminMsg = adminMsg;
	}
	
	
}
