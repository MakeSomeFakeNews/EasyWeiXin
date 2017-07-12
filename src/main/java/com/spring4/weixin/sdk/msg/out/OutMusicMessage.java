package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;

public class OutMusicMessage extends OutMessage {

	private static final long serialVersionUID = 763221284053284448L;
	private String title; // 不是必须
	private String description; // 不是必须
	private String musicUrl; // 不是必须
	private String hqMusicUrl; // 不是必须
	// private String thumbMediaId; // 官方文档有误，无此属性
	private String funcFlag = "0";

	public OutMusicMessage() {
		this.msgType = "music";
	}

	public OutMusicMessage(InMessage inMsg) {
		super(inMsg);
		this.msgType = "music";
	}

	@Override
	protected void subXml(StringBuilder sb) {
		sb.append("<Music>\n");
		sb.append("<Title><![CDATA[").append(nullToBlank(title)).append("]]></Title>\n");
		sb.append("<Description><![CDATA[").append(nullToBlank(description)).append("]]></Description>\n");
		sb.append("<MusicUrl><![CDATA[").append(nullToBlank(musicUrl)).append("]]></MusicUrl>\n");
		sb.append("<HQMusicUrl><![CDATA[").append(nullToBlank(hqMusicUrl)).append("]]></HQMusicUrl>\n");
		sb.append("<FuncFlag>").append(funcFlag).append("</FuncFlag>\n");
		sb.append("</Music>\n");
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getFuncFlag() {
		return funcFlag;
	}

	// 设置为星标
	public void setFuncFlag(boolean funcFlag) {
		this.funcFlag = funcFlag ? "1" : "0";
	}

	/*
	 * 官方文档有误，无此属性 public String getThumbMediaId() { return thumbMediaId; }
	 * 
	 * public void setThumbMediaId(String thumbMediaId) { this.thumbMediaId =
	 * thumbMediaId; }
	 */

}
