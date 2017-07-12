package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;
public class OutImageMessage extends OutMessage{

	private static final long serialVersionUID = 358409331788313826L;
	private String mediaId;

    public OutImageMessage() {
        this.msgType = "image";
    } 

    public OutImageMessage(InMessage inMsg) {
        super(inMsg);
        this.msgType = "image";
    }

    protected void subXml(StringBuilder sb) {
        if (null == mediaId) {
            throw new NullPointerException("mediaId is null");
        }
        sb.append("<Image>\n");
        sb.append("<MediaId><![CDATA[").append(mediaId).append("]]></MediaId>\n");
        sb.append("</Image>\n");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
