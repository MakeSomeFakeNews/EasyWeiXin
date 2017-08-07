package com.spring4.weixin.api.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.spring4.utils.HttpClientUtil;

/**
 * CardCodeApi.java文件：作用简介 <br>
 * 地址：https://mp.weixin.qq.com/wiki?action=doc&id=mp1451025239&t=0.5997588644623877#1.1<br>
 * 作者:周锦华 日期: 2017年8月7日 下午12:04:52
 */
public class CardCodeApi {
	// https://mp.weixin.qq.com/wiki?action=doc&id=mp1451025239&t=0.5997588644623877#1.1
	private String getCodeUrl = "https://api.weixin.qq.com/card/code/get?access_token=";

	private String consumeCode = "https://api.weixin.qq.com/card/code/consume?access_token=";

	private String decryptCode = "https://api.weixin.qq.com/card/code/decrypt?access_token=";

	private String setDeposit = "http://api.weixin.qq.com/card/code/deposit?access_token=";

	private String getDepositCount = "http://api.weixin.qq.com/card/code/getdepositcount?access_token=";

	private String checkCode = "http://api.weixin.qq.com/card/code/checkcode?access_token=";

	private String update = "https://api.weixin.qq.com/card/code/update?access_token=";

	private String mark = "https://api.weixin.qq.com/card/code/mark?access_token=";

	/**
	 * 查询Code接口
	 * 
	 * @param access_token
	 *            基础
	 * 
	 * @param code
	 *            单张卡券的唯一标准。
	 * @param cardId
	 *            卡券ID代表一类卡券。自定义code卡券必填。
	 * @param checkConsume
	 *            是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
	 * @return {jsonResult}
	 */
	public String get(String code, String cardId, String access_token, boolean checkConsume) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("code", code);
		if (cardId != null) {
			m.put("card_id", cardId);
		}
		m.put("check_consume", checkConsume);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getCodeUrl + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 核销Code接口
	 * 
	 * @param access_token
	 *            基础
	 * @param code
	 *            需核销的Code码。
	 * @return {jsonResult}
	 */
	public String consume(String code, String access_token) {
		return consume(code, null, access_token);
	}

	/**
	 * 核销Code接口
	 * 
	 * @param access_token
	 *            基础
	 * @param code
	 *            需核销的Code码。
	 * @param cardId
	 *            card_id卡券ID。创建卡券时use_custom_code填写true时必填。非自定义Code不必填写。
	 * @return {jsonResult}
	 */
	public String consume(String code, String cardId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("code", code);
		if (cardId != null) {
			m.put("card_id", cardId);
		}
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(consumeCode + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 线上核销Code接口
	 * 
	 * @param access_token
	 *            基础
	 * @param code
	 *            需核销的Code码。
	 * @param openid
	 *            是 string(20) 当前卡券使用者的openid，通常通过网页授权登录或自定义url跳转参数获得。
	 * @return {jsonResult}
	 */
	public String consume_online(String code, String openid, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("code", code);
		m.put(openid, openid);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(consumeCode + access_token, jsonString);
		return new String(jsonResult);
	}

	/**
	 * Code解码接口
	 * 
	 * @param access_token
	 *            基础
	 * @param encryptCode
	 *            经过加密的Code码。
	 * @return {jsonResult}
	 */
	public String decrypt(String encryptCode, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("encrypt_code", encryptCode);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(decryptCode + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 导入code接口，
	 * 
	 * @param access_token
	 *            基础
	 * @param cardId
	 *            需要进行导入code的卡券ID。
	 * @param codeList
	 *            需要进行导入code的卡券ID。
	 * @return {jsonResult}
	 */
	public String set_deposit(String cardId, List<String> codeList, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(setDeposit + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 查询导入code数目接口
	 * 
	 * @param access_token
	 *            基础
	 * @param cardId
	 *            需要进行导入code的卡券ID。
	 * @return {jsonResult}
	 */
	public String get_deposit_count(String cardId, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(getDepositCount + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 核查code接口
	 * 
	 * @param access_token
	 *            基础
	 * @param cardId
	 *            需要进行导入code的卡券ID。
	 * @param codeList
	 *            已经微信卡券后台的自定义code，上限为100个。
	 * @return {jsonResult}
	 */
	public String check_code(String cardId, List<String> codeList, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("code", codeList);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(checkCode + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 更改Code接口
	 * 
	 * @param code
	 *            需变更的Code码。
	 * @param newCode
	 *            变更后的有效Code码。
	 * @return {jsonResult}
	 */
	public String update(String code, String newCode, String access_token) {
		return update(null, code, newCode, access_token);
	}

	/**
	 * 更改Code接口
	 * 
	 * @param cardId
	 *            卡券ID。自定义Code码卡券为必填。
	 * @param code
	 *            需变更的Code码。
	 * @param newCode
	 *            变更后的有效Code码。
	 * @return {jsonResult}
	 */
	public String update(String cardId, String code, String newCode, String access_token) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("code", newCode);
		if (cardId != null) {
			m.put("card_id", cardId);
		}
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(update + access_token, jsonString);
		return jsonResult;
	}

	/**
	 * 朋友的券-Mark(占用)Code接口
	 * 
	 * @param code
	 *            是 卡券的code码。
	 * @param cardId
	 *            需要进行导入code的卡券ID。
	 * @param openid
	 *            是 用券用户的openid。
	 * @param isMark
	 *            是 是否要mark（占用）这个code，填写true或者false，表示占用或解除占用。
	 * @return {jsonResult}
	 */
	public String mark_code(String code, String cardId, String openid, String access_token, boolean isMark) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("card_id", cardId);
		m.put("code", code);
		m.put("openid", openid);
		m.put("is_mark", isMark);
		String jsonString = JSON.toJSONString(m);
		String jsonResult = HttpClientUtil.postJson(mark + access_token, jsonString);
		return jsonResult;
	}
}
