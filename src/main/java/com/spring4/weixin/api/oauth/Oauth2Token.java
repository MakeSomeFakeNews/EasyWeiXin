package com.spring4.weixin.api.oauth;

public class Oauth2Token {
	private String access_token;
	private String expires_in;
	private String openid;
	private String refresh_token;
	private String scope;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "Oauth2Token [access_token=" + access_token + ", expires_in=" + expires_in + ", openid=" + openid + ", refresh_token=" + refresh_token + ", scope=" + scope
				+ "]";
	}

	public Oauth2Token(String access_token, String expires_in,  String openid,
			String refresh_token, String scope) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.openid = openid;
		this.refresh_token = refresh_token;
		this.scope = scope;
	}

	public Oauth2Token() {
		super();
	}

}
