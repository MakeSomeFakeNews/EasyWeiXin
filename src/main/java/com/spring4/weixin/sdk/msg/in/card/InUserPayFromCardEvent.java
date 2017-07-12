package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;

/**
 * Created by L.cm on 2016/5/5.
 * 微信会员卡快速买单
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_7638cbc70355]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[o_CBes-OUGtQ4vxd_7r5-p5QRRXU]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1462420332&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[user_pay_from_pay_cell]]&gt;&lt;/Event&gt;
 * &lt;CardId&gt;&lt;![CDATA[p_CBes55910LQGAOStjVKaTChpsg]]&gt;&lt;/CardId&gt;
 * &lt;UserCardCode&gt;&lt;![CDATA[777670435071]]&gt;&lt;/UserCardCode&gt;
 * &lt;TransId&gt;&lt;![CDATA[4001802001201605055526028099]]&gt;&lt;/TransId&gt;
 * &lt;LocationId&gt;403808221&lt;/LocationId&gt;
 * &lt;Fee&gt;100&lt;/Fee&gt;
 * &lt;OriginalFee&gt;100&lt;/OriginalFee&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InUserPayFromCardEvent extends InEventMessage {
    public static final String EVENT = "user_pay_from_pay_cell";

    private String cardId;
    private String userCardCode;
    private String transId;
    private String locationId;
    private String fee;
    private String originalFee;

    public InUserPayFromCardEvent(String toUserName, String fromUserName, Integer createTime) {
        super(toUserName, fromUserName, createTime, EVENT);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getOriginalFee() {
        return originalFee;
    }

    public void setOriginalFee(String originalFee) {
        this.originalFee = originalFee;
    }
}
