package com.message.service.sms.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.message.service.sms.model.SendSmsRequest;
import com.message.service.sms220.SmsConfig;
import com.message.service.sms220.SmsService;
import com.message.service.sms220.impl.SendMessageService;
import com.message.service.sms220.impl.SendNotifaction;
import com.message.service.sms220.impl.SmsPropertiesconfig;

public class Test {
	SmsConfig config = new SmsPropertiesconfig("E:/environments/properties/sms/sms.properties", "utf-8");
	SmsService smsSer = new SendMessageService(config);

	public void sendMessage() {
		SendSmsRequest send = setSend();
		SendNotifaction notifaction = smsSer.sendMessage(send);
		System.out.println("发送描述：" + notifaction.getDescribe());
		System.out.println(
				"发送状态：" + ("1".equals(notifaction.getStatus()) ? "成功:" : "失败 ，异常编码-" + notifaction.getStatus()));
		System.out.println(notifaction.getBatchnum());
	}

	private SendSmsRequest setSend() {
		SendSmsRequest request = new SendSmsRequest();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		request.setMsg("hello,world。" + date);

		request.setPhone("90");

		request.setSendtime(date);

		return request;
	}

	private void getBalance() {
		String result = smsSer.getBalance();
		System.out.println("余额为：" + result);
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.sendMessage();
		test.getBalance();

	}

}
