package com.spring4.weixin.sdk.msg.in.event;

/**
 * Copyright (c) 2011-2015, Unas 小强哥 (unas@qq.com).
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

/**
 * <pre>
 &lt;xml&gt;&lt;ToUserName&gt;&lt;![CDATA[toUser]]&gt;&lt;/ToUserName&gt;
 &lt;FromUserName&gt;&lt;![CDATA[FromUser]]&gt;&lt;/FromUserName&gt;
 &lt;CreateTime&gt;1442401061&lt;/CreateTime&gt;
 &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 &lt;Event&gt;&lt;![CDATA[naming_verify_fail]]&gt;&lt;/Event&gt;
 &lt;FailTime&gt;1442401061&lt;/FailTime&gt;
 &lt;FailReason&gt;&lt;![CDATA[by time]]&gt;&lt;/FailReason&gt;
 &lt;/xml&gt;
 * </pre>
 */
public class InVerifyFailEvent extends InEventMessage {
	// 资质认证失败
	public static final String EVENT_IN_QUALIFICATION_VERIFY_FAIL = "qualification_verify_fail";
	// 名称认证失败
	public static final String EVENT_IN_NAMING_VERIFY_FAIL = "naming_verify_fail";

	private String failTime;
	private String failReason;

	public InVerifyFailEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public String getFailTime() {
		return failTime;
	}

	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
}
