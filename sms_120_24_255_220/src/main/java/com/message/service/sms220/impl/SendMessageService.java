package com.message.service.sms220.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.log4j.Logger;
import com.message.service.sms220.SendMsg;
import com.message.service.sms220.SmsConfig;
import com.message.service.sms220.SmsService;
import com.message.service.sms220.impl.util.FormatBeanUtil;

public class SendMessageService implements SmsService {

	private SmsConfig smsconfig;
	private static final Logger logger = Logger.getLogger(SendMessageService.class);

	public SendMessageService(SmsConfig config) {
		this.smsconfig = config;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsService#sendMessage(com.gumpcome.svmconfig.smspackage.SendMsg)
	 */
	@Override
	public SendNotifaction sendMessage(SendMsg smsmsg) {
		String params = createParams(smsmsg, smsconfig);
		String res = HttpRequest.sendGet(smsconfig.url(), params, smsconfig.charset());
		return FormatBeanUtil.convertSendResult(res);
	}

	/**
	 * 封装发送参数
	 *
	 * @param smsmsg
	 * @param smsconfig
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:59:28
	 */
	private String createParams(SendMsg msg, SmsConfig config) {
		StringBuilder build = new StringBuilder();
		build.append("act=" + smsconfig.sendmsg());
		build.append("&unitid=" + config.unitid());
		build.append("&username=" + config.username());
		build.append("&passwd=" + config.passwd());
		try {
			build.append("&msg=" + URLEncoder.encode(msg.getMsg(), smsconfig.charset()));
		} catch (UnsupportedEncodingException e) {
			logger.error("编码失败，请检查", e);
		}
		build.append("&phone=" + msg.getPhone());
		build.append("&port=" + (msg.getPort() == null ? "" : msg.getPort()));
		build.append("&sendtime=" + (msg.getSendtime() == null ? "" : msg.getSendtime()));
		return build.toString();
	}

	@Override
	public String smsrecord(SendMsg smsmsg) {
		return null;
	}
}
