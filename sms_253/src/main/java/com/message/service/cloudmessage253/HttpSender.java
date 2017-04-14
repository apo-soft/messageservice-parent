package com.message.service.cloudmessage253;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @param url
 *            应用地址，类似于http://ip:port/msg/
 * @param un
 *            账号
 * @param pw
 *            密码
 * @param phone
 *            手机号码，多个号码使用","分割
 * @param msg
 *            短信内容
 * @param rd
 *            是否需要状态报告，需要1，不需要0
 * @return 返回值定义参见HTTP协议文档
 * @throws Exception
 */
public class HttpSender {
	public static String sendMsg(String url, String un, String pw, String phone, String msg, String rd, String ex) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		InputStream is = null;
		// 封装请求参数
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("un", un));
		params.add(new BasicNameValuePair("pw", pw));
		params.add(new BasicNameValuePair("phone", phone));
		params.add(new BasicNameValuePair("rd", rd));
		params.add(new BasicNameValuePair("msg", msg));
		params.add(new BasicNameValuePair("ex", ex));
		String str = "";
		try {
			// 转换为键值对
			str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			System.out.println(str);
			// 创建Get请求
			HttpGet httpGet = new HttpGet(url + "?" + str);
			// 执行Get请求，
			response = httpClient.execute(httpGet);
			// 得到响应体
			HttpEntity entity = response.getEntity();
			int code = response.getStatusLine().getStatusCode();
			String res = EntityUtils.toString(entity);
			System.out.println("返回结果：" + res);
			return res;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭输入流，释放资源
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 消耗实体内容
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 关闭相应 丢弃http连接
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}