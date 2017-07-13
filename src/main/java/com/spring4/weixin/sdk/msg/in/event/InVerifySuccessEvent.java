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
 &lt;CreateTime&gt;1442401156&lt;/CreateTime&gt;
 &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 &lt;Event&gt;&lt;![CDATA[qualification_verify_success]]&gt;&lt;/Event&gt;
 &lt;ExpiredTime&gt;1442401156&lt;/ExpiredTime&gt;
 &lt;/xml&gt;
 * </pre>
 */
public class InVerifySuccessEvent extends InEventMessage {
    //资质认证成功
    public static final String EVENT_IN_QUALIFICATION_VERIFY_SUCCESS = "qualification_verify_success";
    //名称认证成功
    public static final String EVENT_IN_NAMING_VERIFY_SUCCESS = "naming_verify_success";
    //年审通知
    public static final String EVENT_IN_ANNUAL_RENEW = "annual_renew";
    //认证过期失效通知
    public static final String EVENT_IN_VERIFY_EXPIRED = "verify_expired";

    private String expiredTime;

    public InVerifySuccessEvent(String toUserName, String fromUserName, Integer createTime, String event)
    {
        super(toUserName, fromUserName, createTime, event);
    }

    public String getExpiredTime()
    {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime)
    {
        this.expiredTime = expiredTime;
    }
}






