package com.message.service.sms220;

/**
 * 发送短信接口
 * 
 * @author Yu Jinshui
 * @createTime 2016年3月29日 下午2:23:51
 */
public interface SendMsg {
	/**
	 * 发送的短信内容，发送手机70字，发送小灵通50字 ,调用接口时内容要进行urlencode，并使用GBK编码
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:25:48
	 */
	String getMsg();

	/**
	 * 发送号码（号码以’,’号分隔）
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:26:36
	 */
	String getPhone();

	/**
	 * 扩展端口号
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:26:48
	 */
	String getPort();

	/**
	 * 设置发送时间 - 定时发送使用
	 * <p>
	 * 时间格式：yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月30日 下午12:15:00
	 */
	String getSendtime();
}
