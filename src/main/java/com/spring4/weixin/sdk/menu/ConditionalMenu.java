package com.spring4.weixin.sdk.menu;

import java.util.List;

public class ConditionalMenu {
	/*
	 * button 是 一级菜单数组，个数应为1~3个 sub_button 否 二级菜单数组，个数应为1~5个 type 是
	 * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型 name 是
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节 key click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节 url
	 * view、miniprogram类型必须
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节。当type为miniprogram时，不支持小程序的老版本客户端将打开本url
	 * media_id media_id类型和view_limited类型必须 调用新增永久素材接口返回的合法media_id appid
	 * miniprogram类型必须 小程序的appid pagepath miniprogram类型必须 小程序的页面路径 matchrule 是
	 * 菜单匹配规则 tag_id 否 用户标签的id，可通过用户标签管理接口获取 sex 否 性别：男（1）女（2），不填则不做匹配
	 * client_platform_type 否 客户端版本，当前只具体到系统型号：IOS(1),
	 * Android(2),Others(3)，不填则不做匹配 country 否 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
	 * province 否 省份信息，是用户在微信中设置的地区，具体请参考地区信息表 city 否
	 * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表 language 否 语言信息，是用户在微信中设置的语言，具体请参考语言表：
	 * 
	 */
	private String type;
	private String name;
	private String key;
	private String media_id;
	private String appid;
	private String miniprogram;
	private String pagepath;
	private String url;
	private String matchrule;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(String miniprogram) {
		this.miniprogram = miniprogram;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMatchrule() {
		return matchrule;
	}
	public void setMatchrule(String matchrule) {
		this.matchrule = matchrule;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClient_platform_type() {
		return client_platform_type;
	}
	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<ConditionalMenu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<ConditionalMenu> sub_button) {
		this.sub_button = sub_button;
	}
	private String tag_id;
	private String sex;
	private String client_platform_type;
	private String country;
	private String province;
	private String city;
	private String language;
	private List<ConditionalMenu> sub_button;
	

}
