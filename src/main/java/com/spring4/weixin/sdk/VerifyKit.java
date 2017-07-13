package com.spring4.weixin.sdk;

import com.alibaba.fastjson.JSONObject;

/**
 * Date :2017年7月12日10:13:11
 * 
 * @author spring4
 */
public class VerifyKit {
	public static void verify(String str) {
		if (str != null) {
			JSONObject parse = JSONObject.parseObject(str);
			Integer code = parse.getInteger("errcode");
			if (code != null) {
				String res = parse.getString("errmsg");
				if (code != 0) {
					try {
						throw new IllegalAccessException(res);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
