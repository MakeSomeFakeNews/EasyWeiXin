package com.spring4.weixin.sdk.msg.in;

public class InTextMessage extends InMessage {
	/*
	 * Content 文本消息内容 MsgId 消息id，64位整型
	 */
	private String content;
	private String msgId;

	public InTextMessage(String toUserName, String fromUserName, Integer createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
}
