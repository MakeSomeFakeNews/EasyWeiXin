package com.spring4.weixin.sdk.msg.in;

import com.spring4.utils.XmlHelper;

public class InNotDefinedMessage extends InMessage {
	 /**
     * 新增xmlHelper，用于用户扩展。
     * 对于不支持的消息类型中，获取xml中想要的参数。
     */
    protected transient XmlHelper xmlHelper;
    
    public InNotDefinedMessage(String toUserName, String fromUserName, Integer createTime, String msgType) {
        super(toUserName, fromUserName, createTime, msgType);
    }

    public XmlHelper getXmlHelper() {
        return xmlHelper;
    }

    public void setXmlHelper(XmlHelper xmlHelper) {
        this.xmlHelper = xmlHelper;
    }

}
