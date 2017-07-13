package com.spring4.weixin.sdk.msg.in.event;

public class InWifiEvent extends InEventMessage {
	public static final String EVENT = "WifiConnected";
	private String connectTime;
	private String expireTime;
	private String vendorId;
	private String shopId;

	public String getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(String connectTime) {
		this.connectTime = connectTime;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	private String deviceNo;

	public InWifiEvent(String toUserName, String fromUserName, Integer createTime) {
		super(toUserName, fromUserName, createTime, EVENT);
	}
}
