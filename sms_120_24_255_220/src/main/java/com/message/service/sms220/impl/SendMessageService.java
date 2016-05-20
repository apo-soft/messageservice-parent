package com.message.service.sms220.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.log4j.Logger;
import com.message.service.sms220.SendMsg;
import com.message.service.sms220.SmsConfig;
import com.message.service.sms220.SmsService;
import com.message.service.sms220.impl.util.FormatBeanUtil;

/**
 * 短信服务接口
 * 
 * @author Yu Jinshui
 * @createTime 2016年4月8日 下午10:05:27
 */
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
		setUser(build, config);
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

	/**
	 * 
	 * @see com.message.service.sms220.SmsService#smsrecord(com.message.service.sms220.SendMsg)
	 */
	@Override
	public String smsrecord() {
		// TODO
		return null;
	}

	/**
	 * 
	 * @see com.message.service.sms220.SmsService#getBalance()
	 */
	@Override
	public String getBalance() {
		String params = setBalanceParam(smsconfig);
		return HttpRequest.sendGet(smsconfig.url(), params, smsconfig.charset());

	}

	/**
	 * 短信余额部分赋值
	 *
	 * @param config
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午10:04:48
	 */
	private String setBalanceParam(SmsConfig config) {
		StringBuilder build = new StringBuilder();
		build.append("act=" + config.getbalance());
		setUser(build, config);
		return build.toString();
	}

	/**
	 * 账号配置部分
	 *
	 * @param build
	 * @param config
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午10:03:00
	 */
	private void setUser(StringBuilder build, SmsConfig config) {
		build.append("&unitid=" + config.unitid());
		build.append("&username=" + config.username());
		build.append("&passwd=" + config.passwd());
	}

	@Override
	public String updatePassword(String password) {
		String params = setUpPass(password);
		return HttpRequest.sendGet(smsconfig.url(), params, smsconfig.charset());
	}

	/**
	 * 
	 * 修改密码赋值
	 * 
	 * @param password
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午10:34:25
	 */
	private String setUpPass(String password) {
		StringBuilder build = new StringBuilder();
		build.append("act=" + smsconfig.uppasswd());
		setUser(build, smsconfig);
		build.append("&&newpasswd=" + password);
		return build.toString();
	}

	@Override
	public String getSmsStatue() {
		String params = setStatue(smsconfig);
		return HttpRequest.sendGet(smsconfig.url(), params, smsconfig.charset());
	}

	/**
	 * 获取回执赋值部分
	 *
	 * @param smsconfig2
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年5月11日 下午7:36:29
	 */
	private String setStatue(SmsConfig config) {
		StringBuilder build = new StringBuilder();
		build.append("act=" + config.getstatue());
		setUser(build, config);
		return build.toString();
	}
}
