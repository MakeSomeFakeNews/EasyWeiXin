package com.spring4.wxapp.api;

import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.PropertiesUtil;

/**
 * WxLoginApi.java文件：作用简介<br>
 * 微信小程序Api
 * ============================================================================
 * 作者:周锦华 日期: 2017年8月4日 上午10:17:08
 */
public class WxUserApi {
	private String session_key_url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

	/**
	 * 参数 必填 说明<br>
	 * appid 是 小程序唯一标识<br>
	 * secret 是 小程序的 app secret<br>
	 * js_code 是 登录时获取的 code<br>
	 * grant_type 是 填写为 authorization_code<br>
	 * 
	 * @param code
	 *            登录时获取到的code
	 */
	public void get_session_key(String code) {
		HttpClientUtil.get(session_key_url.replace("APPID", PropertiesUtil.getProperty("wxAppid"))
				.replace("SECRET", PropertiesUtil.getProperty("wxSecret")).replace("JSCODE", code));
	}
	
}
