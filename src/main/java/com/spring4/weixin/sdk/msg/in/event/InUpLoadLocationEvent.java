package com.spring4.weixin.sdk.msg.in.event;

public class InUpLoadLocationEvent extends InEventMessage {
	private String latitude;
	private String longitude;
	private String precision;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}


	public InUpLoadLocationEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
		// TODO Auto-generated constructor stub
	}

}
