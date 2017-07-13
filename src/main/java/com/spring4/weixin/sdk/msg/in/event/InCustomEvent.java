package com.spring4.weixin.sdk.msg.in.event;

public class InCustomEvent extends InEventMessage {
	// 接入会话：kf_create_session
	public static final String EVENT_INCUSTOM_KF_CREATE_SESSION = "kf_create_session";
	// 关闭会话：kf_close_session
	public static final String EVENT_INCUSTOM_KF_CLOSE_SESSION = "kf_close_session";
	// 转接会话：kf_switch_session
	public static final String EVENT_INCUSTOM_KF_SWITCH_SESSION = "kf_switch_session";

	private String kfAccount;
	private String toKfAccount;

	public InCustomEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public String getKfAccount() {
		return kfAccount;
	}

	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	public String getToKfAccount() {
		return toKfAccount;
	}

	public void setToKfAccount(String toKfAccount) {
		this.toKfAccount = toKfAccount;
	}
}
