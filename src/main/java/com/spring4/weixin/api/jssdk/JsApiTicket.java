package com.spring4.weixin.api.jssdk;
/**
 * Date:2017年7月12日15:52:21 
 * @author spring4
 */
public class JsApiTicket {
	private String ticket;
	private String expires_in;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public JsApiTicket(String ticket, String expires_in) {
		super();
		this.ticket = ticket;
		this.expires_in = expires_in;
	}
	public JsApiTicket() {
		super();
	}
	@Override
	public String toString() {
		return "JsApiTicket [ticket=" + ticket + ", expires_in=" + expires_in + "]";
	}
	
}
