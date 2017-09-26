package com.spring4.weixin.api.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.spring4.utils.HttpClientUtil;

/**
 * CardApi.java文件：作用简介 作者:周锦华 日期: 2017年8月7日 上午10:06:33
 */
public class CardApi {
	private static String create_card_Url = "https://api.weixin.qq.com/card/create?access_token=";

	private static String createQrcodeCard = "https://api.weixin.qq.com/card/qrcode/create?access_token=";

	private static String createLandingPageCard = "https://api.weixin.qq.com/card/landingpage/create?access_token=";

	private static String setWhiteList = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=";

	private static String getnewsUrl = "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=";

	private static String setPaycell = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=";

	private static String setSelfconsumecell = "https://api.weixin.qq.com/card/selfconsumecell/set?access_token=";

	private static String getCard = "https://api.weixin.qq.com/card/get?access_token=";

	private static String getBatch = "https://api.weixin.qq.com/card/batchget?access_token=";

	private static String update = "https://api.weixin.qq.com/card/update?access_token=";

	private static String unavailable = "https://api.weixin.qq.com/card/code/unavailable?access_token=";

	private static String delete = "https://api.weixin.qq.com/card/delete?access_token=";

	private static String modifystock = "https://api.weixin.qq.com/card/modifystock?access_token=";

	private static String getUserCardList = "https://api.weixin.qq.com/card/user/getcardlist?access_token=";

	/**
	 * 创建二维码接口
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @param access_token
	 *            基础
	 * @return {json}
	 */
	public static String create_qrcode(String jsonStr, String access_token) {
		String json = HttpClientUtil.postJson(createQrcodeCard + access_token, jsonStr);
		return json;
	}

	/**
	 * 创建会员卡接口
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {postJson}
	 */
	public static String create(String jsonStr, String access_token) {
		String postJson = HttpClientUtil.postJson(create_card_Url + access_token, jsonStr);
		return postJson;
	}

	/**
	 * 设置测试白名单
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @param access_token
	 *            基础
	 * @return {postJson}
	 */
	public static String set_white_list(String jsonStr, String access_token) {
		String postJson = HttpClientUtil.postJson(setWhiteList + access_token, jsonStr);
		return postJson;
	}

	/**
	 * 创建货架接口
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @param access_token
	 *            基础
	 * @return {json}
	 */
	public static String create_landing_page(String jsonStr, String access_token) {
		String json = HttpClientUtil.postJson(createLandingPageCard + access_token, jsonStr);

		return json;
	}

	/**
	 * 图文消息群发卡券
	 * 
	 * @param cardId
	 *            必填 否 卡券ID。
	 * @param access_token
	 *            基础
	 * @return {json}
	 */
	public static String get_html_mpnews(String cardId, String access_token) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("card_id", cardId);
		String jsonString = JSON.toJSONString(m);
		return HttpClientUtil.postJson(getnewsUrl + access_token, jsonString);
	}

	/**
	 * 设置买单接口
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param isOpen
	 *            是否开启买单功能，填true/false
	 * @param access_token
	 *            基础
	 * @return {json}
	 */
	public static String set_paycell(String cardId, boolean isOpen, String access_token) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("card_id", cardId);
		m.put("is_open", isOpen);
		String jsonString = JSON.toJSONString(m);
		return HttpClientUtil.postJson(setPaycell + access_token, jsonString);
	}

	/**
	 * 设置自助核销接口 默认为false
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param isOpen
	 *            是否开启买单功能，填true/false
	 * @param access_token
	 *            基础
	 * @return {jsonResult}
	 */
	public static String set_selfconsumecell(String cardId, String access_token, boolean isOpen) {
		return set_selfconsumecell(cardId, access_token, isOpen, false, false);
	}

	/**
	 * 设置自助核销接口
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param access_token
	 *            基础
	 * @param isOpen
	 *            是否开启买单功能，填true/false
	 * @param needVerifyCod
	 *            用户核销时是否需要输入验证码，填true/false，默认为false
	 * @param needRemarkAmount
	 *            用户核销时是否需要备注核销金额，填true/false，默认为false
	 * @return {jsonResult}
	 */
	public static String set_selfconsumecell(String cardId, String access_token, boolean isOpen, boolean needVerifyCod,
			boolean needRemarkAmount) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("is_open", isOpen);
		m.put("need_verify_cod", needVerifyCod);
		m.put("need_remark_amount", needRemarkAmount);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(setSelfconsumecell + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 获取用户已领取卡券接口
	 *
	 * @param openid
	 *            是 string(64) 需要查询的用户openid
	 * @param access_token
	 *            基础
	 * @return {jsonResult}
	 */
	public static String get_user_card_list(String openid, String access_token) {
		return get_user_card_list(openid, null, access_token);
	}

	/**
	 * 获取用户已领取卡券接口
	 *
	 * @param openid
	 *            是 string(64) 需要查询的用户openid
	 * @param cardId
	 *            否 string(32) 卡券ID。不填写时默认查询当前appid下的卡券。
	 * @param access_token
	 *            基础
	 * @return {jsonResult}
	 */
	public static String get_user_card_list(String openid, String cardId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("openid", openid);
		if (cardId != null) {
			m.put("card_id", cardId);
		}
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getUserCardList + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 查看卡券详情
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param access_token
	 *            基础
	 * @return {jsonResult}
	 */
	public static String get(String cardId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getCard + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 批量查询卡券列表
	 * 
	 * @param offset
	 *            查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取。
	 * @param count
	 *            需要查询的卡片的数量（数量最大50）。
	 * @param access_token
	 *            基础
	 * @return {jsonResult}
	 */
	public static String get_batch(int offset, String access_token, int count) {
		return get_batch(offset, access_token, count, null);
	}

	/**
	 * 批量查询卡券列表
	 * 
	 * @param offset
	 *            查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取。
	 * @param count
	 *            需要查询的卡片的数量（数量最大50）。
	 * @param access_token
	 *            基础
	 * @param statusList
	 *            支持开发者拉出指定状态的卡券列表“CARD_STATUS_NOT_VERIFY”,待审核；“CARD_STATUS_VERIFY_FAIL”,审核失败；“CARD_STATUS_VERIFY_OK”，通过审核；“CARD_STATUS_DELETE”，卡券被商户删除；“CARD_STATUS_DISPATCH”在公众平台投放过的卡券；
	 * @return {jsonResult}
	 */
	public static String get_batch(int offset, String access_token, int count, List<String> statusList) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("offset", offset);
		m.put("count", count);
		if (statusList != null && !statusList.isEmpty()) {
			m.put("status_list", statusList);
		}
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getBatch + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 更改卡券信息接口 access_token 基础
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {jsonResult}
	 */
	public static String update(String jsonStr, String access_token) {
		String jsonResult = HttpClientUtil.postJson(update + access_token, jsonStr);
		return jsonResult;
	}

	/**
	 * 修改库存接口 access_token 基础
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param stockValue
	 *            增减的库存数量 负数为减，正数为增加,0不增不减。
	 * @return {jsonResult}
	 */
	public static String modifystock(String cardId, int stockValue, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		if (stockValue >= 0) {
			m.put("increase_stock_value", stockValue);
		} else {
			m.put("reduce_stock_value", stockValue);
		}
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(modifystock + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 删除卡券接口
	 * 
	 * @param cardId
	 *            卡券ID
	 * @return {jsonResult}
	 */
	public static String delete(String cardId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(delete + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 设置卡券失效接口,自定义卡券的请求
	 * 
	 * @param code
	 *            设置失效的Code码。
	 * @param reason
	 *            用户发生退款 失效理由
	 * @return {jsonResult}
	 */
	public static String unavailable_by_code(String code, String reason, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("code", code);
		m.put("reason", reason);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(unavailable + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 设置卡券失效接口,自定义code卡券的请求。
	 * 
	 * @param cardId
	 *            卡券ID
	 * @param reason
	 *            用户发生退款 失效理由
	 * @return {jsonResult}
	 */
	public static String unavailable_by_card(String cardId, String reason, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("reason", reason);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(unavailable + access_token, jsonString);
		return jsonResult;
	}
}
