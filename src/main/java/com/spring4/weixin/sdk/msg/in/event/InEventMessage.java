package com.spring4.weixin.sdk.msg.in.event;

import com.spring4.weixin.sdk.msg.in.InMessage;

public abstract class InEventMessage extends InMessage {
	private static final String MESSAGE_TYPE = "event";
	protected String event;

	public InEventMessage(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, MESSAGE_TYPE);
		this.event = event;
		// TODO Auto-generated constructor stub
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public static String getMessageType() {
		return MESSAGE_TYPE;
	}

}
