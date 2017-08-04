package com.spring4.weixin.sdk.oauth;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.PropertiesUtil;
import com.spring4.weixin.sdk.VerifyKit;

public class Oauth2 {
	private String baseUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect ";
	private String access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	private String user_info_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	public String getSnsapi_baseUrl() {
		return baseUrl.replace("APPID", PropertiesUtil.getAppId())
				.replace("REDIRECT_URI", PropertiesUtil.getProperty("url")).replace("SCOPE", "snsapi_base");
	}

	public String getSnsapi_userinfoUrl() {
		return baseUrl.replace("APPID", PropertiesUtil.getAppId())
				.replace("REDIRECT_URI", PropertiesUtil.getProperty("url")).replace("SCOPE", "snsapi_userinfo");
	}

	/**
	 * 获取普通授权信息
	 * 
	 * @param appid
	 * @param secret
	 * @param code
	 *            你的code
	 * @return Oauth2Token对象
	 */
	public Oauth2Token login(String code) {
		String token = HttpClientUtil.get(access_token_url.replace("APPID", PropertiesUtil.getAppId())
				.replace("SECRET", PropertiesUtil.getSecret()).replace("CODE", code));
		JSONObject json = JSONObject.parseObject(token);
		String access_token = json.getString("access_token");
		String expires_in = json.getString("expires_in");
		String refresh_token = json.getString("refresh_token");
		String openid = json.getString("openid");
		String scope = json.getString("scope");
		return new Oauth2Token(access_token, expires_in, openid, refresh_token, scope);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param access_token
	 * @param openid
	 * @param lang
	 * @return 用户信息
	 */
	public UserInfo getUserInfo(String access_token, String openid, String lang) {
		String userInfo = HttpClientUtil.get(
				user_info_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid).replace("zh_CN", lang));
		JSONObject json = JSONObject.parseObject(userInfo);
		String openId = json.getString("openid");
		String nickname = json.getString("nickname");
		String sex = null;
		String sexNum = json.getString("sex");
		if (sexNum.equals("0")) {
			sex = "男";
		} else if (sexNum.equals("1")) {
			sex = "女";
		} else {
			sex = "未知";
		}
		String province = json.getString("province");
		String city = json.getString("city");
		String country = json.getString("country");
		String headimgurl = json.getString("headimgurl");
		// 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）好像必须做特殊处理
		JSONArray jsonArray = json.getJSONArray("privilege");
		List<String> privilege = null;
		if (jsonArray.size() > 0) {
			privilege = new ArrayList<String>();
			for (Object object : jsonArray) {
				privilege.add((String) object);
			}
		}
		String unionid = json.getString("unionid");
		return new UserInfo(openId, nickname, sex, province, city, country, headimgurl, privilege, unionid);
	}

	/**
	 * 获取用户信息 默认获取中文信息
	 * 
	 * @param access_token
	 * @param openid
	 * @param lang
	 * @return 用户信息
	 */
	public UserInfo getUserInfo(String access_token, String openid) {
		String userInfo = HttpClientUtil
				.get(user_info_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid));
		System.out.println("userInfo"+userInfo);
		JSONObject json = JSONObject.parseObject(userInfo);
		String openId = json.getString("openid");
		String nickname = json.getString("nickname");
		String sex = null;
		String sexNum = json.getString("sex");
		if (sexNum.equals("0")) {
			sex = "男";
		} else if (sexNum.equals("1")) {
			sex = "女";
		} else {
			sex = "未知";
		}
		String province = json.getString("province");
		String city = json.getString("city");
		String country = json.getString("country");
		String headimgurl = json.getString("headimgurl");
		// 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）好像必须做特殊处理
		JSONArray jsonArray = json.getJSONArray("privilege");
		List<String> privilege = null;
		if (jsonArray.size() > 0) {
			privilege = new ArrayList<String>();
			for (Object object : jsonArray) {
				privilege.add((String) object);
			}
		}
		String unionid = json.getString("unionid");
		return new UserInfo(openId, nickname, sex, province, city, country, headimgurl, privilege, unionid);
	}

	private String verify_access_token = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";

	/**
	 * 检验access_token是否有效
	 * 
	 * @return 正确的JSON返回结果： { "errcode":0,"errmsg":"ok"}
	 */
	public String verify_access_token() {
		String json = HttpClientUtil.get(verify_access_token);
		VerifyKit.verify(json);
		return json;
	}

	private String refresh_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

	/**
	 * appid 是 公众号的唯一标识 grant_type 是 填写为refresh_token refresh_token 是
	 * 填写通过access_token获取到的refresh_token参数
	 * 
	 * @param refreshToken
	 *            填写通过access_token获取到的refresh_token参数
	 * @return Oauth2Token 对象
	 */
	public Oauth2Token get_refresh_token(String refreshToken) {
		String token = HttpClientUtil
				.get(refresh_token.replace("APPID", PropertiesUtil.getAppId()).replace("refresh_token", refreshToken));

		JSONObject json = JSONObject.parseObject(token);
		String access_token = json.getString("access_token");
		String expires_in = json.getString("expires_in");
		String refresh_token = json.getString("refresh_token");
		String openid = json.getString("openid");
		String scope = json.getString("scope");
		return new Oauth2Token(access_token, expires_in, openid, refresh_token, scope);
	}
}
