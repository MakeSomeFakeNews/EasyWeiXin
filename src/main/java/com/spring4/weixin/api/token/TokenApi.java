package com.spring4.weixin.api.token;

import com.alibaba.fastjson.JSONObject;
import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.PropertiesUtil;

/**
 * @author spring4<br>
 *         2016-08-08
 */
public class TokenApi {
	private String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private String call_back_url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

	/**
	 * 获得access_token 这个token和网页授权的token不一样的。不要搞混了
	 * 
	 * @param appid
	 * @param appsecret
	 * @return access_token
	 */
	public Access_Token get_access_token() {
		String access_token = HttpClientUtil.get(access_token_url.replace("APPID", PropertiesUtil.getAppId())
				.replace("APPSECRET", PropertiesUtil.getSecret()));
		JSONObject jsonObject = JSONObject.parseObject(access_token);
		String token = jsonObject.getString("access_token");
		String expires = jsonObject.getString("expires_in");
		return new Access_Token(token, expires);
	}

	/**
	 * 获得微信服务器IP
	 * 
	 * @param access_token
	 * @return 微信服务器IP
	 */
	public String getCallBackIP(Access_Token access_token) {
		String accessToken = access_token.getAccess_token();
		String callBackIP = HttpClientUtil.get(call_back_url.replace("ACCESS_TOKEN", accessToken));
		return callBackIP;
	}
}
