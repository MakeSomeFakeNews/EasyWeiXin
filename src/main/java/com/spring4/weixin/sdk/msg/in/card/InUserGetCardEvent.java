package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;
import com.spring4.weixin.utils.XmlHelper;

/**
 * 领取事件推送
 * @author Dreamlu
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt; &lt;![CDATA[gh_fc0a06a20993]]&gt; &lt;/ToUserName&gt;
 * &lt;FromUserName&gt; &lt;![CDATA[oZI8Fj040-be6rlDohc6gkoPOQTQ]]&gt; &lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1472551036&lt;/CreateTime&gt;
 * &lt;MsgType&gt; &lt;![CDATA[event]]&gt; &lt;/MsgType&gt;
 * &lt;Event&gt; &lt;![CDATA[user_get_card]]&gt; &lt;/Event&gt;
 * &lt;CardId&gt; &lt;![CDATA[pZI8Fjwsy5fVPRBeD78J4RmqVvBc]]&gt; &lt;/CardId&gt;
 * &lt;IsGiveByFriend&gt;0&lt;/IsGiveByFriend&gt;
 * &lt;UserCardCode&gt; &lt;![CDATA[226009850808]]&gt; &lt;/UserCardCode&gt;
 * &lt;FriendUserName&gt; &lt;![CDATA[]]&gt; &lt;/FriendUserName&gt;
 * &lt;OuterId&gt;0&lt;/OuterId&gt;
 * &lt;OldUserCardCode&gt; &lt;![CDATA[]]&gt; &lt;/OldUserCardCode&gt;
 * &lt;OuterStr&gt; &lt;![CDATA[12b]]&gt; &lt;/OuterStr&gt;
 * &lt;IsRestoreMemberCard&gt;0&lt;/IsRestoreMemberCard&gt;
 * &lt;IsRecommendByFriend&gt;0&lt;/IsRecommendByFriend&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InUserGetCardEvent extends InEventMessage implements ICardMsgParse {
    public static final String EVENT = "user_get_card";

    private String cardId;
    private String isGiveByFriend;
    private String userCardCode;
    private String friendUserName;
    private String outerId;
    private String oldUserCardCode;
    private String outerStr;
    private String isRestoreMemberCard;
    private String isRecommendByFriend;

    public InUserGetCardEvent(String toUserName, String fromUserName, Integer createTime) {
        super(toUserName, fromUserName, createTime, EVENT);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getIsGiveByFriend() {
        return isGiveByFriend;
    }

    public void setIsGiveByFriend(String isGiveByFriend) {
        this.isGiveByFriend = isGiveByFriend;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public String getOldUserCardCode() {
        return oldUserCardCode;
    }

    public void setOldUserCardCode(String oldUserCardCode) {
        this.oldUserCardCode = oldUserCardCode;
    }

    public String getOuterStr() {
        return outerStr;
    }

    public void setOuterStr(String outerStr) {
        this.outerStr = outerStr;
    }

    public String getIsRestoreMemberCard() {
        return isRestoreMemberCard;
    }

    public void setIsRestoreMemberCard(String isRestoreMemberCard) {
        this.isRestoreMemberCard = isRestoreMemberCard;
    }

    public String getIsRecommendByFriend() {
        return isRecommendByFriend;
    }

    public void setIsRecommendByFriend(String isRecommendByFriend) {
        this.isRecommendByFriend = isRecommendByFriend;
    }

    public void parse(XmlHelper xmlHelper) {
        setCardId(xmlHelper.getString("//CardId"));
        setIsGiveByFriend(xmlHelper.getString("//IsGiveByFriend"));
        setUserCardCode(xmlHelper.getString("//UserCardCode"));
        setFriendUserName(xmlHelper.getString("//FriendUserName"));
        setOuterId(xmlHelper.getString("//OuterId"));
        setOldUserCardCode(xmlHelper.getString("//OldUserCardCode"));
        setOuterStr(xmlHelper.getString("//OuterStr"));
        setIsRestoreMemberCard(xmlHelper.getString("//IsRestoreMemberCard"));
        setIsRecommendByFriend(xmlHelper.getString("//IsRecommendByFriend"));
    }
}
