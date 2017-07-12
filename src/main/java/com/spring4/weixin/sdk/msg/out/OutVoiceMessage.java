package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;

public class OutVoiceMessage extends OutMessage {

	private static final long serialVersionUID = 1251123319899605449L;
	 private String mediaId;

	    public OutVoiceMessage() {
	        this.msgType = "voice";
	    }

	    public OutVoiceMessage(InMessage inMsg) {
	        super(inMsg);
	        this.msgType = "voice";
	    }

	    @Override
	    protected void subXml(StringBuilder sb) {
	        if (null == mediaId) {
	            throw new NullPointerException("mediaId is null");
	        }
	        sb.append("<Voice>\n");
	        sb.append("<MediaId><![CDATA[").append(mediaId).append("]]></MediaId>\n");
	        sb.append("</Voice>\n");
	    }

	    public String getMediaId() {
	        return mediaId;
	    }

	    public void setMediaId(String mediaId) {
	        this.mediaId = mediaId;
	    }

}
