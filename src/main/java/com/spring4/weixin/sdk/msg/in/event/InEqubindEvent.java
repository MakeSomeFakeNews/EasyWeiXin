package com.spring4.weixin.sdk.msg.in.event;



/**
 * lyb 微信硬件绑定和解绑事件类
 */
public class InEqubindEvent extends InEventMessage {
	// 事件
	public static final String DEVICE_EVENT = "device_event";
	// 设备具体事件类型
	public static final String UNBIND = "unbind";
	public static final String BIND = "bind";
	
	private String deviceType;
	private String deviceID;
	private String openID;
	private String sessionID;
	
	public InEqubindEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType);
		setEvent(event);
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

}