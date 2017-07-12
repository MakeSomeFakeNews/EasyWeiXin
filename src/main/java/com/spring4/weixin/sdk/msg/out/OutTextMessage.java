package com.spring4.weixin.sdk.msg.out;

import com.spring4.weixin.sdk.msg.in.InMessage;

public class OutTextMessage extends OutMessage {

	  /**
	 * 
	 */
	private static final long serialVersionUID = -1508820660541663030L;
	private String content;

	    public OutTextMessage() {
	        this.msgType = "text";
	    }

	    public OutTextMessage(InMessage inMsg) {
	        super(inMsg);
	        this.msgType = "text";
	    }

	    @Override
	    protected void subXml(StringBuilder sb) {
	        if (null == content) {
	            throw new NullPointerException("content is null");
	        }
	        sb.append("<Content><![CDATA[").append(content).append("]]></Content>\n");
	    }

	    public String getContent() {
	        return content;
	    }

	    public OutTextMessage setContent(String content) {
	        this.content = content;
	        return this;
	    }

}
