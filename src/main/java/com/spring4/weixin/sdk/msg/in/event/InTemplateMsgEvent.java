package com.spring4.weixin.sdk.msg.in.event;

/**
 * Copyright (c) 2011-2015, Unas 小强哥 (unas@qq.com).
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

/**
 * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者中心中填写的服务器配置地址中
 * 
 * <pre>
 &lt;xml&gt;
 &lt;ToUserName&gt;&lt;![CDATA[gh_7f083739789a]]&gt;&lt;/ToUserName&gt;
 &lt;FromUserName&gt;&lt;![CDATA[oia2TjuEGTNoeX76QEjQNrcURxG8]]&gt;&lt;/FromUserName&gt;
 &lt;CreateTime&gt;1395658920&lt;/CreateTime&gt;
 &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 &lt;Event&gt;&lt;![CDATA[TEMPLATESENDJOBFINISH]]&gt;&lt;/Event&gt;
 &lt;MsgID&gt;200163836&lt;/MsgID&gt;
 &lt;Status&gt;&lt;![CDATA[success]]&gt;&lt;/Status&gt;
 &lt;/xml&gt;
 * </pre>
 */
public class InTemplateMsgEvent extends InEventMessage {

	// "success": 成功
	public static final String EVENT_INTEMPLATEMSG_STATUS_SUCCESS = "success";
	// "block": 用户拒绝接收
	public static final String EVENT_INTEMPLATEMSG_STATUS_BLOCK = "block";
	// "failed: system failed": 发送失败（非用户拒绝）
	public static final String EVENT_INTEMPLATEMSG_STATUS_FAILED = "failed: system failed";

	private String msgId;

	/**
	 * "success": 成功 "block": 用户拒绝接收 "failed: system failed": 发送失败（非用户拒绝）
	 */
	private String status;

	public InTemplateMsgEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
