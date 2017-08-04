package com.spring4.weixin.sdk.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;

/**
 * 作者:周锦华 日期: 2017年8月3日 上午10:49:13
 */
public class Weixin {
	public static String getOutMsg(ServletInputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		StringBuilder sb = new StringBuilder();
		String outMsg = null;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			WeiXinMessageHandel wx = new WeiXinMessageHandel();
			outMsg = wx.getOutMsg(sb.toString());

		} catch (IOException e) {
			System.err.println("xml格式有误");
			e.printStackTrace();
		}
		System.out.println(outMsg);
		return outMsg;
	}
}
