package com.spring4.weixin.sdk.msg.out;

import java.io.Serializable;

import com.spring4.weixin.sdk.msg.in.InMessage;

public abstract class OutMessage implements Serializable {
	private static final long serialVersionUID = 849033975906519150L;

	// 接收方帐号（收到的OpenID）
    protected String toUserName;

    // 开发者微信号
    protected String fromUserName;

    // 消息创建时间 （整型）
    protected Integer createTime;

    /**
     * 被动响应消息类型
     * 1：text 文本消息
     * 2：image 图片消息
     * 3：voice 语音消息
     * 4：video 视频消息
     * 5：music 音乐消息
     * 6：news 图文消息
     */
    protected String msgType;

    /**
     * 用接收到的消息初始化要发出去的消息，关键在于两者 toUserName 与 fromUserName 相反
     * @param inMsg inMsg
     */
    public OutMessage(InMessage inMsg) {
        this.toUserName = inMsg.getFromUserName();
        this.fromUserName = inMsg.getToUserName();
        this.createTime = now();
    }

    public OutMessage() {

    }

    protected abstract void subXml(StringBuilder sb);

    /**
     * 转换xml
     * @return {String}
     */
    public String toXml() {
        StringBuilder sb = new StringBuilder();

        sb.append("<xml>\n");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>\n");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>\n");
        sb.append("<CreateTime>").append(createTime).append("</CreateTime>\n");
        sb.append("<MsgType><![CDATA[").append(msgType).append("]]></MsgType>\n");
        subXml(sb);
        sb.append("</xml>");

        return sb.toString();
    }

    protected String nullToBlank(String str) {
        return null == str ? "" : str;
    }

    public Integer now() {
        return (int)(System.currentTimeMillis() / 1000);
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
