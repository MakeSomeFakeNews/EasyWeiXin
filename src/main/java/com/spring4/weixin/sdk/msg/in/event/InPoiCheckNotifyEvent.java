package com.spring4.weixin.sdk.msg.in.event;


public class InPoiCheckNotifyEvent extends InEventMessage {
	// UniqId商户自己内部 ID,即字段中的 sid
	// PoiId 微信的门店 ID,微信内门店唯一标示 ID
	// Result 审核结果,成功 succ 或失败 fail
	// Msg 成功的通知信息,或审核失败的驳回理由

	private String uniqId;
	private String poiId;
	private String result;
	private String msg;

	public InPoiCheckNotifyEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		// unas update at 2016-1-29,add event param & extends EventInMsg
		super(toUserName, fromUserName, createTime, event);
	}

	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	public String getPoiId() {
		return poiId;
	}

	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
