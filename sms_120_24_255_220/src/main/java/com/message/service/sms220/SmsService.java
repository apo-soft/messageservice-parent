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
	 * 返回用户余额
	 * <p>
	 * 失败则直接返回错误编号信息
	 *
	 * @param smsmsg
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午9:52:42
	 */
	String getBalance();

	/**
	 * 修改账户密码，直接返回结果编号
	 *
	 * @param password
	 *            新密码
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午10:13:32
	 */
	String updatePassword(String password);

	/**
	 * 获取回复信息【仅能获取一次，再次获取，则结果返回0】
	 * <p>
	 * 格式: 序号|^|上行号码|^|内容|^|时间|^| sp端口号 <br>
	 * 两条记录这间用|;|分隔<br>
	 * 32221|15800000000|^|这是回复测试|^|2000-07-16 15:10:27|^|1065788<br>
	 * |;|32222|^|15800000000|^|这是回复测试2|^|2000-07-16 15:10:27|^|1065788
	 *
	 * @param smsmsg
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年3月29日 下午2:45:22
	 */
	String smsrecord();

	/**
	 * 取回执，仅能获取一次
	 * <p>
	 * 格式: 批号|^|号码|^|状态<br>
	 * 两条记录这间用|;|分隔<br>
	 * 316|^|15800000000|^|DELIVRD|;|317|^|13300000000|^|DELIVRD|;|318|^|
	 * 13900000000|^|DELIVRD|;|319|^|18800000000|^|'UNDELIV
	 *
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2016年4月8日 下午10:26:04
	 */
	String getSmsStatue();

}
