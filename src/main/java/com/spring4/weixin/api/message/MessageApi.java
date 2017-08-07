package com.spring4.weixin.api.message;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.spring4.utils.HttpClientUtil;

/**
 * MessageApi.java文件：作用简介<br>
 * 作者:锦华<br>
 * 日期: 2017年8月7日 下午1:13:38
 */
public class MessageApi {

	private String sendAllUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";

	private String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";

	private String previewUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";

	private String getUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";

	private String deleteUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=";

	/**
	 * 根据分组进行群发【订阅号与服务号认证后均可用】
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @return {String}
	 */
	public String sendAll(String jsonStr, String access_token) {
		return HttpClientUtil.postJson(sendAllUrl + access_token, jsonStr);
	}

	/**
	 * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @return {String}
	 */
	public String send(String jsonStr, String access_token) {
		return HttpClientUtil.postJson(sendUrl + access_token, jsonStr);
	}

	/**
	 * 预览接口【订阅号与服务号认证后均可用】
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @return {String}
	 */
	public String preview(String jsonStr, String access_token) {
		return HttpClientUtil.postJson(previewUrl + access_token, jsonStr);
	}

	/**
	 * 查询群发消息发送状态【订阅号与服务号认证后均可用】
	 * 
	 * @param msgId
	 *            群发消息后返回的消息id
	 * @return json
	 */
	public String get(String msgId, String access_token) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("msg_id", msgId);
		String jsonString = JSON.toJSONString(m);
		return HttpClientUtil.postJson(getUrl + access_token, jsonString);
	}

	/**
	 * 删除群发【订阅号与服务号认证后均可用】 由于技术限制，群发只有在刚发出的半小时内可以删除，发出半小时之后将无法被删除。
	 * 
	 * @param msgId
	 *            群发消息后返回的消息id
	 * @return json
	 */
	public String delete(String msgId, String access_token) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("msg_id", msgId);
		String jsonString = JSON.toJSONString(m);
		return HttpClientUtil.postJson(deleteUrl, jsonString);
	}

}
