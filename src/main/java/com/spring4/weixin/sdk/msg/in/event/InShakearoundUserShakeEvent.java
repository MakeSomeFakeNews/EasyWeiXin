package com.spring4.weixin.sdk.msg.in.event;

import java.util.ArrayList;
import java.util.List;

public class InShakearoundUserShakeEvent extends InEventMessage {
	private String event;// 事件
	private String uuid;
	private Integer major;
	private Integer minor;
	private Float distance;// 设备与用户的距离（浮点数；单位：米）

	private List<AroundBeacon> aroundBeaconList = new ArrayList<AroundBeacon>();

	public InShakearoundUserShakeEvent(String toUserName, String fromUserName, Integer createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public List<AroundBeacon> getAroundBeaconList() {
		return aroundBeaconList;
	}

	public void setAroundBeaconList(List<AroundBeacon> aroundBeaconList) {
		this.aroundBeaconList = aroundBeaconList;
	}

	public static class AroundBeacon {
		private String uuid;
		private Integer major;
		private Integer minor;
		private Float distance;// 设备与用户的距离（浮点数；单位：米）

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public Integer getMajor() {
			return major;
		}

		public void setMajor(Integer major) {
			this.major = major;
		}

		public Integer getMinor() {
			return minor;
		}

		public void setMinor(Integer minor) {
			this.minor = minor;
		}

		public Float getDistance() {
			return distance;
		}

		public void setDistance(Float distance) {
			this.distance = distance;
		}
	}
}
