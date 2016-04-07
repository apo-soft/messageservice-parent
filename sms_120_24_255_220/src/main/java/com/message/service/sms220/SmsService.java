package com.message.service.sms220;

import com.message.service.sms220.impl.SendNotifaction;

public interface SmsService {
	/**
	 * 信息发送
	 *
	 * @param smsmsg
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:43:22
	 */
	SendNotifaction sendMessage(SendMsg smsmsg);

	/**
	 * 获取回复信息
	 *
	 * @param smsmsg
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:45:22
	 */
	String smsrecord(SendMsg smsmsg);
}
