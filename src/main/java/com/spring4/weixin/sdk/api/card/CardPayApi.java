package com.spring4.weixin.sdk.api.card;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.spring4.utils.HttpClientUtil;

/**
 * CardPayApi.java文件：作用简介<br>
 * 作者:锦华<br>
 * 日期: 2017年8月7日 下午1:01:49
 */
public class CardPayApi {
	private String activateUrl = "https://api.weixin.qq.com/card/pay/activate?access_token=";

	private String getPayPriceUrl = "https://api.weixin.qq.com/card/pay/getpayprice?access_token=";

	private String getCoinsInfoUrl = "https://api.weixin.qq.com/card/pay/getcoinsinfo?access_token=";

	private String confirmUrl = "https://api.weixin.qq.com/card/pay/confirm?access_token=";

	private String rechargeUrl = "https://api.weixin.qq.com/card/pay/recharge?access_token=";

	private String getOrderUrl = "https://api.weixin.qq.com/card/pay/getorder?access_token=";

	private String getOrderListUrl = "https://api.weixin.qq.com/card/pay/getorderlist?access_token=";

	/**
	 * 开通券点账户接口
	 * 
	 * @return {String}
	 */
	public String activate(String access_token) {
		String jsonResult = HttpClientUtil.get(activateUrl + access_token);
		return jsonResult;
	}

	/**
	 * 对优惠券批价
	 * 
	 * @param cardId
	 *            是 string(32) 需要来配置库存的card_id
	 * @param quantity
	 *            是 int 本次需要兑换的库存数目
	 * @return {String}
	 */
	public String get_pay_price(String cardId, int quantity, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("quantity", quantity);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getPayPriceUrl + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 查询券点余额接口
	 * 
	 * @return {String}
	 */
	public String get_coins_info(String access_token) {
		String jsonResult = HttpClientUtil.get(getCoinsInfoUrl + access_token);
		return jsonResult;
	}

	/**
	 * 确认兑换库存接口
	 * 
	 * @param cardId
	 *            是 string(32) 需要来配置库存的card_id
	 * @param quantity
	 *            是 int 本次需要兑换的库存数目
	 * @param orderId
	 *            是 string 仅可以使用批价得到的订单号，保证批价有效性
	 * @return {String}
	 */
	public String confirm(String cardId, int quantity, String orderId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("quantity", quantity);
		m.put("order_id", orderId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(confirmUrl + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 充值券点接口
	 * 
	 * @param coinCount
	 *            是 int 需要充值的券点数目，1点=1元
	 * @return {String}
	 */
	public String recharge(int coinCount, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("coin_count", coinCount);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(rechargeUrl + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 查询订单详情接口
	 * 
	 * @param orderId
	 *            是 int 充值券点接口中获得的订单号，作为一次交易的唯一凭证，由于类型不是100%确定改为Stirng
	 * @return {String}
	 */
	public String get_order(String orderId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("order_id", orderId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getOrderUrl + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 查询券点流水详情接口
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {String}
	 */
	public String get_orderList(String jsonStr, String access_token) {
		String jsonResult = HttpClientUtil.postJson(getOrderListUrl + access_token, jsonStr);
		return jsonResult;
	}
}
