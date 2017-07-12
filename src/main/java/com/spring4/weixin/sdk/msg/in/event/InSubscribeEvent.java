package com.spring4.weixin.sdk.msg.in.event;

public class InSubscribeEvent extends InEventMessage {

	// 订阅：subscribe
	public static final String EVENT_INFOLLOW_SUBSCRIBE = "subscribe";
	// 取消订阅：unsubscribe
	public static final String EVENT_INFOLLOW_UNSUBSCRIBE = "unsubscribe";

	public InSubscribeEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

}
