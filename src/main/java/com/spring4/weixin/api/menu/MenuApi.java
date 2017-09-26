/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.spring4.weixin.api.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.PropertiesUtil;
import com.spring4.weixin.sdk.VerifyKit;

/**
 * Date :2017年7月12日10:13:11
 * 
 * @author spring4
 */
public  class MenuApi {
	private static String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	private static String testMenu = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";

	private static String delConditionaMenu = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";

	private static String createConditionalMenu = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";

	private static String delMenu = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	private static String MENU_SEARCH = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	public static  void createMenu(WeixinMenu menu, String access_token) {
		List<WeixinMenu> wm = new ArrayList<WeixinMenu>();
		wm.add(menu);
		Map<String, List<WeixinMenu>> map = new HashMap<String, List<WeixinMenu>>();
		map.put("button", wm);
		String json = JSONObject.toJSONString(map);
		String postJson = HttpClientUtil.postJson(MENU_URL.replace("ACCESS_TOKEN", access_token), json);
		if (PropertiesUtil.isDebug()) {
			System.out.println("--------菜单创建------");
			System.out.println(postJson);
			System.out.println("--------菜单创建------");
		}

		VerifyKit.verify(postJson);

	}

	public static  String getMenu(String access_token) {
		String menu = HttpClientUtil.get(MENU_SEARCH.replace("ACCESS_TOKEN", access_token));
		if (PropertiesUtil.isDebug()) {
			System.out.println("--------获取菜单------");
			System.out.println(menu);
			System.out.println("--------获取菜单------");
		}
		return menu;
	}

	public static  void delMenu(String access_token) {
		String resString = HttpClientUtil.get(delMenu.replace("ACCESS_TOKEN", access_token));
		if (PropertiesUtil.isDebug()) {
			System.out.println("--------删除菜单------");
			System.out.println(resString);
			System.out.println("--------删除菜单------");
		}
		VerifyKit.verify(resString);
	}

	public static  String createConditionalMenu(String access_token, String jsonStr) {
		String menuId = HttpClientUtil.postJson(createConditionalMenu.replace("ACCESS_TOKEN", access_token), jsonStr);
		if (PropertiesUtil.isDebug()) {
			System.out.println("--------创建Conditional菜单------");
			System.out.println(menuId);
			System.out.println("--------创建Conditional菜单------");
		}
		return menuId;
	}

	/**
	 * 请求示例 { "menuid":"208379533" }
	 */
	public static  void delConditionaMenu(String access_token, String jsonstr) {
		String resString = HttpClientUtil.postJson(delConditionaMenu.replace("ACCESS_TOKEN", access_token), jsonstr);
		if (PropertiesUtil.isDebug()) {
			System.out.println("--------删除Conditional菜单------");
			System.out.println(resString);
			System.out.println("--------删除Conditional菜单------");
		}
		VerifyKit.verify(resString);
	}

	/**
	 * 请求示例 { "user_id":"weixin" }
	 * 
	 * @param access_token
	 * @param jsonStr
	 * @return
	 */
	public static  String testMenu(String access_token, String jsonStr) {
		String resString = HttpClientUtil.postJson(testMenu.replace("ACCESS_TOKEN", access_token), jsonStr);

		return resString;
	}

}