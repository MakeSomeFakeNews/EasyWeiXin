package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;
import com.spring4.weixin.utils.XmlHelper;

/**
 * 转赠事件推送
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_3fcea188bf78]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[obLatjjwDolFjRRd3doGIdwNqRXw]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1474181868&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[user_gifting_card]]&gt;&lt;/Event&gt;
 * &lt;CardId&gt;&lt;![CDATA[pbLatjhU-3pik3d4PsbVzvBxZvJc]]&gt;&lt;/CardId&gt;
 * &lt;UserCardCode&gt;&lt;![CDATA[297466945104]]&gt;&lt;/UserCardCode&gt;
 * &lt;IsReturnBack&gt;0&lt;/IsReturnBack&gt;
 * &lt;FriendUserName&gt;&lt;![CDATA[obLatjlNerkb62HtSdQUx66C4NTU]]&gt;&lt;/FriendUserName&gt;
 * &lt;IsChatRoom&gt;0&lt;/IsChatRoom&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InUserGiftingCardEvent extends InEventMessage implements ICardMsgParse {
    public static final String EVENT = "user_gifting_card";

    private String cardId;
    private String userCardCode;
    private String isReturnBack;
    private String friendUserName;
    private String isChatRoom;

    public InUserGiftingCardEvent(String toUserName, String fromUserName, Integer createTime) {
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

    public String getIsReturnBack() {
        return isReturnBack;
    }

    public void setIsReturnBack(String isReturnBack) {
        this.isReturnBack = isReturnBack;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public String getIsChatRoom() {
        return isChatRoom;
    }

    public void setIsChatRoom(String isChatRoom) {
        this.isChatRoom = isChatRoom;
    }

    public void parse(XmlHelper xmlHelper) {
        setCardId(xmlHelper.getString("//CardId"));
        setUserCardCode(xmlHelper.getString("//UserCardCode"));
        setIsReturnBack(xmlHelper.getString("//IsReturnBack"));
        setFriendUserName(xmlHelper.getString("//FriendUserName"));
        setIsChatRoom(xmlHelper.getString("//IsChatRoom"));
    }
}
