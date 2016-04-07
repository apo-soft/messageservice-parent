package com.message.service.sms220;

public interface SmsConfig {
	/**
	 * 服务访问URL地址
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String url();

	/**
	 * 企业代码
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String unitid();

	/**
	 * 用户账号
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String username();

	/**
	 * 用户密码
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String passwd();

	/**
	 * 查询用户短信量
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String getbalance();

	/**
	 * 更改用户密码
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String uppasswd();

	/**
	 * 发送短信
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String sendmsg();

	/**
	 * 取回执
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String getstatue();

	/**
	 * 获取回复信息
	 * 
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午12:05:23
	 */
	String smsrecord();

	/**
	 * 字符编码
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:54:31
	 */
	String charset();
}
