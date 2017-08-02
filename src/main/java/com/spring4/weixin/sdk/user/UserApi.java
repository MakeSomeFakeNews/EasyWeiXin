package com.spring4.weixin.sdk.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring4.weixin.sdk.VerifyKit;
import com.spring4.weixin.utils.HttpClientUtil;
/**
 * Date:2017年7月12日15:51:21 
 * @author spring4
 */
public class UserApi {
	private String user_name_url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";

	/**
	 * 设置用户备注名 开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。 接口调用请求说明 access_token
	 * 调用接口凭证 openid 用户标识 remark 新的备注名，长度必须小于30字符
	 * 
	 * @param access_token
	 * @param openId
	 * @param remark
	 */
	public void set_user_name(String access_token, String openId, String remark) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("openid", openId);
		m.put("remark", remark);
		String jsonString = JSON.toJSONString(m);
		String json = HttpClientUtil.postJson(user_name_url + access_token, jsonString);
		VerifyKit.verify(json);
	}

	private String user_info = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/**
	 * 获取用户基本信息(UnionID机制)
	 * 在关注者与公众号产生消息交互后，公众号可获得关注者的OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的。对于不同公众号，同一用户的openid不同）。公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
	 * 请注意，如果开发者有在多个公众号，或在公众号、移动应用之间统一用户帐号的需求，需要前往微信开放平台（open.weixin.qq.com）绑定公众号后，才可利用UnionID机制来满足上述需求。
	 * UnionID机制说明：
	 * 开发者可通过OpenID来获取用户基本信息。特别需要注意的是，如果开发者拥有多个移动应用、网站应用和公众帐号，可通过获取用户基本信息中的unionid来区分用户的唯一性，因为只要是同一个微信开放平台帐号下的移动应用、网站应用和公众帐号，用户的unionid是唯一的。换句话说，同一用户，对同一个微信开放平台下的不同应用，unionid是相同的。
	 * 
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public UserInfo get_user_info(String access_token, String openid) {
		String string = HttpClientUtil.get(user_info.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid));
		System.out.println(string);
		return user_info(string, openid);

	}

	private String get_user_list_url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
	/**
	 * 批量获取用户
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public List<UserInfo> get_user_info(String access_token, List<String> openid) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String, String>>>();

		for (int i = 0; i < openid.size(); i++) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("openid", openid.get(i));
			m.put("lang", "zh_CN");
			list.add(m);
		}
		map.put("user_list", list);
		String jsonString = JSON.toJSONString(map);
		String json = HttpClientUtil.postJson(get_user_list_url + access_token, jsonString);
		List<UserInfo> ulist = new ArrayList<UserInfo>();
		if (json != null) {
			JSONObject parseObject = JSONObject.parseObject(json);
			JSONArray jsonArray = parseObject.getJSONArray("user_info_list");
			for (int i = 0; i < jsonArray.size(); i++) {
				String string = openid.get(i);
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				UserInfo userInfo = user_info(jsonObject.toJSONString(), string);
				ulist.add(userInfo);
			}
		}
		return ulist;
	}

	private UserInfo user_info(String json_, String openid) {
		JSONObject json = JSONObject.parseObject(json_);
		String nickname = json.getString("nickname");
		String sex = null;
		String sexNum = json.getString("sex");
		if (sexNum.equals("1")) {
			sex = "男";
		} else if (sexNum.equals("2")) {
			sex = "女";
		} else {
			sex = "未知";
		}
		String province = json.getString("province");
		String city = json.getString("city");
		String country = json.getString("country");
		String headimgurl = json.getString("headimgurl");
		String unionid = json.getString("unionid");
		String subscribe_time = json.getString("subscribe_time");
		String remark = json.getString("remark");
		Integer groupid = json.getInteger("groupid");
		JSONArray tagid_list = json.getJSONArray("tagid_list");
		List<Integer> tagidList = new ArrayList<Integer>();
		for (int i = 0; i < tagid_list.size(); i++) {
			int value = tagid_list.getIntValue(i);
			tagidList.add(value);
		}
		return new UserInfo(openid, nickname, sex, province, city, country, headimgurl, unionid, subscribe_time, remark,
				groupid, tagidList);

	}
}
