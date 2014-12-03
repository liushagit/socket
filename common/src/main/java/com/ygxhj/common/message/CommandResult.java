package com.ygxhj.common.message;


public class CommandResult {

	private String cmd;
	private String status;
	private String logMsg;
	private String playerMsg;
	private byte data[];
	private String adminMsg;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	public String getPlayerMsg() {
		return playerMsg;
	}
	public void setPlayerMsg(String playerMsg) {
		this.playerMsg = playerMsg;
	}
	public String getAdminMsg() {
		return adminMsg;
	}
	public void setAdminMsg(String adminMsg) {
		this.adminMsg = adminMsg;
	}
	
}
