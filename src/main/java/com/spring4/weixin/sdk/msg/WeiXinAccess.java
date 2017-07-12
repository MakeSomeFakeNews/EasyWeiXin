package com.spring4.weixin.sdk.msg;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.spring4.weixin.utils.SHA1Util;

/**
 * Date :2017年7月12日10:13:11
 * 
 * @author spring4
 */
public class WeiXinAccess {
	/**
	 * 对微信验证参数进行校验。
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return 返回一个布尔值。
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkSignature(String token,String signature, String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        //1. 将token、timestamp、nonce参数按照字典序排序
        Collections.sort(params, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //2. 将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1Util.toSHA1(params.get(0) + params.get(1) + params.get(2));
        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return temp.equals(signature);
    }
}
