package com.message.service.sms220.impl;

/**
 * 发送结果同步返回参数封装
 * 
 * @author Yu Jinshui
 * @createTime 2016年3月29日 下午2:46:37
 */
public class SendNotifaction {
	private String status;
	private String batchnum;
	private String describe;

	/**
	 * 状态
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:48:26
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态
	 *
	 * @param status
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:48:39
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 批号
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:48:47
	 */
	public String getBatchnum() {
		return batchnum;
	}

	/**
	 * 批号
	 *
	 * @param batchnum
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:48:58
	 */
	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	/**
	 * 说明
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:49:09
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * 说明
	 *
	 * @param describe
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:49:17
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
