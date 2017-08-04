package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.utils.XmlHelper;
import com.spring4.weixin.sdk.msg.in.event.InEventMessage;

/**
 * 审核事件推送
 * @author L.cm
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[toUser]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[FromUser]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;123456789&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[card_pass_check]]&gt;&lt;/Event&gt; //不通过为card_not_pass_check
 * &lt;CardId&gt;&lt;![CDATA[cardid]]&gt;&lt;/CardId&gt;
 * &lt;RefuseReason&gt;&lt;![CDATA[非法代制]]&gt;&lt;/RefuseReason&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InCardPassCheckEvent extends InEventMessage implements ICardMsgParse{
    public static final String EVENT_PASS = "card_pass_check";
    public static final String EVENT_NOT_PASS = "card_not_pass_check";

    /**
     * 卡券ID
     */
    private String cardId;
    /**
     * 审核不通过原因
     */
    private String refuseReason;

    public InCardPassCheckEvent(String toUserName, String fromUserName, Integer createTime, String event) {
        super(toUserName, fromUserName, createTime, event);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public void parse(XmlHelper xmlHelper) {
        setCardId(xmlHelper.getString("//CardId"));
        setRefuseReason(xmlHelper.getString("//RefuseReason"));
    }
}
