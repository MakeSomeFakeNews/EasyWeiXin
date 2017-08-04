package com.spring4.weixin.sdk.jssdk;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.PropertiesUtil;
import com.spring4.utils.SHA1Util;

/**
 * Date:2017年7月12日15:58:21
 * 
 * @author spring4
 */
public class Js_api {
	/**
	 * 获得config接口注入参数
	 * 
	 * @param appid
	 * @param access_Token
	 *            注意：不是授权登录的token
	 * @param jsapi_ticket
	 *            jsapi票据
	 * @param url
	 *            需要需要授权的网址
	 * @return config接口注入参数
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public JsConfig getSign(String jsapi_ticket) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (PropertiesUtil.isDebug()) {
			System.out.println("getSign__jsapi_ticket---:" + jsapi_ticket);
		}
		String uuid = UUID.randomUUID().toString().replace("-", "");
		long time = System.currentTimeMillis() / 1000;
		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + uuid + "&timestamp=" + time + "&url="
				+ PropertiesUtil.getProperty("url");
		String signature = null;
		signature = SHA1Util.toSHA1(str);
		return new JsConfig(PropertiesUtil.getAppId(), time, uuid, signature);

	}

	private String jsapi = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	/**
	 * 获取jsapi_ticket 有效期7200秒，和 api_ticket不一樣
	 * 
	 * @param jsapi_ticket
	 */
	public JsApiTicket getJsApiTicket(String access_Token) {
		String ticket = HttpClientUtil.get(jsapi.replace("ACCESS_TOKEN", access_Token));
		if (PropertiesUtil.isDebug()) {
			System.out.println("getJsApiTicket__access_Token---:" + access_Token);
			System.out.println("getJsApiTicket__return_ticket---:" + ticket);
		}
		System.out.println(ticket);
		JSONObject jsonObject = JSONObject.parseObject(ticket);
		String jsApiTicket = jsonObject.getString("ticket");
		String expires_in = jsonObject.getString("expires_in");
		return new JsApiTicket(jsApiTicket, expires_in);
	}
}
