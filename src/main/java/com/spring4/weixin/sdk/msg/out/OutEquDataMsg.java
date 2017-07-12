package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;

/**
 * <pre>
 * &lt;xml&gt;
 *	&lt;ToUserName&gt;&lt;![CDATA[%s]]&gt;&lt;/ToUserName&gt;
 *	&lt;FromUserName&gt;&lt;![CDATA[%s]]&gt;&lt;/FromUserName&gt;
 *	&lt;CreateTime&gt;%u&lt;/CreateTime&gt;
 *	&lt;MsgType&gt;&lt;![CDATA[%s]]&gt;&lt;/MsgType&gt;
 *	&lt;DeviceType&gt;&lt;![CDATA[%s]]&gt;&lt;/DeviceType&gt;
 *	&lt;DeviceID&gt;&lt;![CDATA[%s]]&gt;&lt;/DeviceID&gt;
 *	&lt;SessionID&gt;%u&lt;/SessionID&gt;
 *	&lt;Content&gt;&lt;![CDATA[%s]]&gt;&lt;/Content&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class OutEquDataMsg extends OutMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7097546874361706019L;
	private String DeviceType;
	private String DeviceID;
	private String content;
	private String SessionID;

	public OutEquDataMsg(InMessage inMsg) {
		super(inMsg);
		this.msgType = "device_text";
	}

	public OutEquDataMsg() {
		this.msgType = "device_text";
	}

	@Override
	protected void subXml(StringBuilder sb) {
		if (null == content) {
			throw new NullPointerException("content is null");
		}
		sb.append("<DeviceType><![CDATA[").append(DeviceType).append("]]></DeviceType>\n");
		sb.append("<DeviceID><![CDATA[").append(DeviceID).append("]]></DeviceID>\n");
		sb.append("<SessionID><![CDATA[").append(SessionID).append("]]></SessionID>\n");
		sb.append("<Content><![CDATA[").append(content).append("]]></Content>\n");
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getDeviceID() {
		return DeviceID;
	}

	public void setDeviceID(String deviceID) {
		DeviceID = deviceID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
}
