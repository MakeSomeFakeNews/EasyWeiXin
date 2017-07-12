package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;

public class OutVideoMessage extends OutMessage {

	private static final long serialVersionUID = -8909433378636816141L;
	private String mediaId;
	private String title; // 不是必须
	private String description; // 不是必须

	public OutVideoMessage() {
		this.msgType = "video";
	}

	public OutVideoMessage(InMessage inMsg) {
		super(inMsg);
		this.msgType = "video";
	}

	@Override
	protected void subXml(StringBuilder sb) {
		if (null == mediaId) {
			throw new NullPointerException("mediaId is null");
		}
		sb.append("<Video>\n");
		sb.append("<MediaId><![CDATA[").append(mediaId).append("]]></MediaId>\n");
		sb.append("<Title><![CDATA[").append(nullToBlank(title)).append("]]></Title>\n");
		sb.append("<Description><![CDATA[").append(nullToBlank(description)).append("]]></Description>\n");
		sb.append("</Video>\n");
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
