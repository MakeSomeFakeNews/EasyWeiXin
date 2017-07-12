package com.spring4.weixin.sdk.menu;

import java.util.List;
/**
 * Date :2017年7月12日10:13:11
 * 
 * @author spring4
 */
public class WeixinMenu {
	private Integer id;
	private String name;
	private String type;
	private String url;
	private String key;
	private Integer pid;
	private List<WeixinMenu> sub_button;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List<WeixinMenu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeixinMenu> sub_button) {
		this.sub_button = sub_button;
	}
	
}
