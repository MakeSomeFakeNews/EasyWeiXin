package com.spring4.weixin.sdk.jssdk;
/**
 * Date:2017年7月12日17:51:21 
 * @author spring4
 */
public class JsConfig {
	 private String appId;
	 private long timestamp;
	 private String nonceStr;
	 private String signature;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "JsConfig [appId=" + appId + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature="
				+ signature + "]";
	}
	public JsConfig(String appId, long time, String nonceStr, String signature) {
		super();
		this.appId = appId;
		this.timestamp = time;
		this.nonceStr = nonceStr;
		this.signature = signature;
	}
	public JsConfig() {
		super();
	}
	
}
