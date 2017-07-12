package com.spring4.weixin.sdk.msg.in.event;

public class InScanQRCodeEvent extends InEventMessage {

	// 1. 用户未关注时，进行关注后的事件推送： subscribe
	public static final String EVENT_INQRCODE_SUBSCRIBE = "subscribe";
	// 2. 用户已关注时的事件推送： SCAN
	public static final String EVENT_INQRCODE_SCAN = "SCAN";

	// 1. 用户未关注时，进行关注后的事件推送： qrscene_123123
	// 2. 用户已关注时的事件推送： SCENE_VALUE
	private String eventKey;
	private String ticket;

	public InScanQRCodeEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
