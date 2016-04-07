package com.message.service.sms220.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.message.service.sms220.SmsConfig;

public class SmsPropertiesconfig implements SmsConfig {
	private static final Logger logger = Logger.getLogger(SmsPropertiesconfig.class);
	private String url;
	private String unitid;
	private String username;
	private String passwd;
	private String getbalance;
	private String uppasswd;
	private String sendmsg;
	private String getstatue;
	private String smsrecord;
	private String charset;

	/**
	 * 默认实现
	 */
	public SmsPropertiesconfig() {
		getProperties("sms.properties");
	}

	/**
	 * 自定义配置文件名称
	 * 
	 * @param fileName
	 */
	public SmsPropertiesconfig(String fileName) {
		getProperties(fileName);
	}

	/**
	 * 外部文件加载方式
	 * 
	 * @param fileName
	 * @param encoding
	 */
	public SmsPropertiesconfig(String fileName, String encoding) {
		getOutFileProperties(fileName, encoding);
	}

	/**
	 * 读取项目配置文件参数
	 *
	 * @param fileName
	 * @Author Yu Jinshui
	 * @createTime 2016年4月7日 下午10:36:17
	 */
	private void getProperties(String fileName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 外部文件加载方式
	 *
	 * @param fileName
	 * @param encoding
	 * @Author Yu Jinshui
	 * @createTime 2016年4月7日 下午10:36:32
	 */
	private void getOutFileProperties(String fileName, String encoding) {
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName), encoding);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println("读取指定路径配置失败。" + fileName);
			logger.error("读取指定路径配置文件失败，请检查文件是否存在。" + fileName);
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);

	}

	/**
	 * 设置属性值
	 * 
	 * @param p
	 * @author Yujinshui
	 * @time 2016年4月1日 上午11:01:36
	 */
	private void setPropertiesValues(Properties p) {
		url = p.getProperty("url");
		unitid = p.getProperty("unitid");
		username = p.getProperty("username");
		passwd = p.getProperty("passwd");
		getbalance = p.getProperty("getbalance");
		uppasswd = p.getProperty("uppasswd");
		sendmsg = p.getProperty("sendmsg");
		getstatue = p.getProperty("getstatue");
		smsrecord = p.getProperty("smsrecord");
		charset = p.getProperty("charset");
	}

	/**
	 * 外部数据初始化
	 * 
	 * @param map
	 */
	public SmsPropertiesconfig(Map<String, String> map) {
		url = map.get("url");
		unitid = map.get("unitid");
		username = map.get("username");
		passwd = map.get("passwd");
		getbalance = map.get("getbalance");
		uppasswd = map.get("uppasswd");
		sendmsg = map.get("sendmsg");
		getstatue = map.get("getstatue");
		smsrecord = map.get("smsrecord");
		charset = map.get("charset");

	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#url()
	 */
	@Override
	public String url() {
		return url;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#unitid()
	 */
	@Override
	public String unitid() {
		return unitid;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#username()
	 */
	@Override
	public String username() {
		return username;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#passwd()
	 */
	@Override
	public String passwd() {
		return passwd;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#getbalance()
	 */
	@Override
	public String getbalance() {
		return getbalance;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#uppasswd()
	 */
	@Override
	public String uppasswd() {
		return uppasswd;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#sendmsg()
	 */
	@Override
	public String sendmsg() {
		return sendmsg;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#getstatue()
	 */
	@Override
	public String getstatue() {
		return getstatue;
	}

	/**
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#smsrecord()
	 */
	@Override
	public String smsrecord() {
		return smsrecord;
	}

	/**
	 * 字符编码格式
	 * 
	 * @see com.gumpcome.svmconfig.smspackage.SmsConfig#charset()
	 */
	@Override
	public String charset() {
		return charset;
	}

	@Override
	public String toString() {
		return "url=" + url//
				+ ";unitid=" + unitid//
				+ ";username=" + username//
				+ ";passwd=" + passwd//
				+ ";getbalance=" + getbalance//
				+ ";uppasswd=" + uppasswd//
				+ ";sendmsg=" + sendmsg//
				+ ";getstatue=" + getstatue//
				+ ";smsrecord=" + smsrecord;
	}
}
