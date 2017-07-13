package com.spring4.weixin.sdk.msg.in;

/**
 * <pre>
 * &lt;xml&gt;
 * 	&lt;ToUserName&gt;&lt;![CDATA[%s]]&gt;&lt;/ToUserName&gt;
 * 	&lt;FromUserName&gt;&lt;![CDATA[%s]]&gt;&lt;/FromUserName&gt;
 * 	&lt;CreateTime&gt;%u&lt;/CreateTime&gt;
 * 	&lt;MsgType&gt;&lt;![CDATA[%s]]&gt;&lt;/MsgType&gt;
 * 	&lt;DeviceType&gt;&lt;![CDATA[%s]]&gt;&lt;/DeviceType&gt;
 * 	&lt;DeviceID&gt;&lt;![CDATA[%s]]&gt;&lt;/DeviceID&gt;
 * 	&lt;Content&gt;&lt;![CDATA[%s]]&gt;&lt;/Content&gt;
 * 	&lt;SessionID&gt;%lu&lt;/SessionID&gt;
 * 	&lt;MsgID&gt;%lu&lt;/MsgID&gt;
 * 	&lt;OpenID&gt;&lt;![CDATA[%s]]&gt;&lt;/OpenID&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InEquDataMsg extends InMessage {
	// 消息
	public static final String DEVICE_TEXT = "device_text";

	private String deviceType;
	private String deviceID;
	private String content;
	private String msgId;
	private String sessionID;
	private String openID;

	public InEquDataMsg(String toUserName, String fromUserName, Integer createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
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

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}
}