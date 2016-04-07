package com.message.service.sms.model;

import com.message.service.sms220.SendMsg;

/**
 * 发送短信请求bean
 * 
 * @author Yu Jinshui
 * @createTime 2016年3月29日 下午3:20:58
 */
public class SendSmsRequest implements SendMsg {
	private String msg;
	private String phone;
	private String port;
	private String sendtime;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setSendtime(String time) {
		this.sendtime = time;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @see com.message.service.sms220.SendMsg#getPort()
	 */
	@Override
	public String getPort() {
		return port;
	}

	/**
	 * 
	 * @see com.message.service.sms220.SendMsg#getSendtime()
	 */
	@Override
	public String getSendtime() {
		return sendtime;
	}

}
