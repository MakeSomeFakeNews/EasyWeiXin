package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;
import com.spring4.weixin.utils.XmlHelper;

/**
 * 库存报警事件
 * @author L.cm
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_2d62d*****0]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[oa3LFuBvWb7*********]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1443838506&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[card_sku_remind]]&gt;&lt;/Event&gt;
 * &lt;CardId&gt;&lt;![CDATA[pa3LFuAh2P65**********]]&gt;&lt;/CardId&gt;
 * &lt;Detail&gt;&lt;![CDATA[the card&#x27;s quantity is equal to 0]]&gt;&lt;/Detail&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InCardSkuRemindEvent extends InEventMessage implements ICardMsgParse {
    public static final String EVENT = "card_pay_order";

    public InCardSkuRemindEvent(String toUserName, String fromUserName, Integer createTime) {
        super(toUserName, fromUserName, createTime, EVENT);
    }

    private String cardId; //卡券ID
    private String detail; //报警详细信息

    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public void parse(XmlHelper xmlHelper) {
        setCardId(xmlHelper.getString("//CardId"));
        setDetail(xmlHelper.getString("//Detail"));
    }
}
