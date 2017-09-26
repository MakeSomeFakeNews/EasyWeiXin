package com.spring4.weixin;

import com.spring4.utils.HttpClientUtil;

/**
 * HttpTest.java文件：作用简介<br>
 * ============================================================================
 * 版权所有 2009-2017 广州亿纬智信息科技有限公司，并保留所有权利。
 * 网站地址: http://www.evlutiontv.com 

 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您只能在不用于商业目的的前提下对程序代码进行修改和
 * 使用；不允许对程序代码以任何形式任何目的的再发布。
 * ============================================================================
 * 作者:锦华<br>
 * 日期: 2017年9月18日 下午4:25:35
*/
public class HttpTest {
	public static void main(String[] args) {
		String string = HttpClientUtil.post("http://www.baidu.com/");
		System.out.println(string);
	}
}
