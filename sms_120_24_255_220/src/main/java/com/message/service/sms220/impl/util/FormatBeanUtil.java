package com.message.service.sms220.impl.util;

import com.message.service.sms220.impl.SendNotifaction;

/**
 * 格式化参数
 * 
 * @author Yu Jinshui
 * @createTime 2016年3月29日 下午3:13:56
 */
public class FormatBeanUtil {
	private FormatBeanUtil() {

	}

	/**
	 * 将返回参数格式化封装
	 *
	 * @param result
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午3:17:16
	 */
	public static SendNotifaction convertSendResult(String result) {
		SendNotifaction notifaction = new SendNotifaction();
		String[] bean = result.split(",");
		notifaction.setStatus(bean[0]);
		notifaction.setBatchnum(bean[1]);
		notifaction.setDescribe(bean[2]);

		return notifaction;
	}
}
