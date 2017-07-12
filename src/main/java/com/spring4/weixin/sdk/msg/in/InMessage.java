package com.spring4.weixin.sdk.msg.in;

public abstract class InMessage {
	// 开发者微信号
	protected String toUserName;

	// 发送方帐号（一个OpenID）
	protected String fromUserName;

	// 消息创建时间 （整型）
	protected Integer createTime;

	/**
	 * 消息类型 1：text 文本消息 2：image 图片消息 3：voice 语音消息 4：video 视频消息 5：location 地址位置消息
	 * 6：link 链接消息 7：event 事件
	 */
	protected String msgType;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public InMessage(String toUserName, String fromUserName, Integer createTime, String msgType) {
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
	}

	@Override
	public String toString() {
		return "InMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
				+ ", msgType=" + msgType + "]";
	}
}
