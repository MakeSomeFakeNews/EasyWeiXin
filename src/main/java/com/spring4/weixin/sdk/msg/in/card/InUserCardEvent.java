package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;
import com.spring4.weixin.utils.XmlHelper;

/**
 * 微信会员卡卡券
 * 
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_7638cbc70355]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[o_CBes-OUGtQ4vxd_7r5-p5QRRXU]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1462420243&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[user_view_card]]&gt;&lt;/Event&gt;
 * &lt;CardId&gt;&lt;![CDATA[p_CBes55910LQGAOStjVKaTChpsg]]&gt;&lt;/CardId&gt;
 * &lt;UserCardCode&gt;&lt;![CDATA[777670435071]]&gt;&lt;/UserCardCode&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InUserCardEvent extends InEventMessage implements ICardMsgParse {
	// 微信会员卡激活接口
	public static final String EVENT_MEMBERCARD = "submit_membercard_user_info";
	// 微信会员卡二维码扫描领取接口
	public static final String EVENT_USER_VIEW = "user_view_card";
	// 从卡券进入公众号会话事件推送
	public static final String EVENT_USER_ENTER = "user_enter_session_from_card";
	// 卡券删除事件推送
	public static final String EVENT_USER_DEL = "user_del_card";

	private String cardId;
	private String userCardCode;

	public InUserCardEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
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

	public void parse(XmlHelper xmlHelper) {
		setCardId(xmlHelper.getString("//CardId"));
		setUserCardCode(xmlHelper.getString("//UserCardCode"));
	}
}
