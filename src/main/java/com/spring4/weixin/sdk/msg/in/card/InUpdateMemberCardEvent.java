package com.spring4.weixin.sdk.msg.in.card;

import com.spring4.weixin.sdk.msg.in.event.InEventMessage;

/**
 * Created by L.cm on 2016/5/5. 微信会员卡积分变更
 * 
 * <pre>
 * &lt;xml&gt;
 * &lt;ToUserName&gt;&lt;![CDATA[gh_7638cbc70355]]&gt;&lt;/ToUserName&gt;
 * &lt;FromUserName&gt;&lt;![CDATA[o_CBes-OUGtQ4vxd_7r5-p5QRRXU]]&gt;&lt;/FromUserName&gt;
 * &lt;CreateTime&gt;1462420730&lt;/CreateTime&gt;
 * &lt;MsgType&gt;&lt;![CDATA[event]]&gt;&lt;/MsgType&gt;
 * &lt;Event&gt;&lt;![CDATA[update_member_card]]&gt;&lt;/Event&gt;
 * &lt;CardId&gt;&lt;![CDATA[p_CBes55910LQGAOStjVKaTChpsg]]&gt;&lt;/CardId&gt;
 * &lt;UserCardCode&gt;&lt;![CDATA[777670435071]]&gt;&lt;/UserCardCode&gt;
 * &lt;ModifyBonus&gt;1000&lt;/ModifyBonus&gt;
 * &lt;ModifyBalance&gt;0&lt;/ModifyBalance&gt;
 * &lt;/xml&gt;
 * </pre>
 */
public class InUpdateMemberCardEvent extends InEventMessage {
	public static final String EVENT = "update_member_card";

	private String cardId;
	private String userCardCode;
	private String modifyBonus;
	private String modifyBalance;

	public InUpdateMemberCardEvent(String toUserName, String fromUserName, Integer createTime) {
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

	public String getModifyBalance() {
		return modifyBalance;
	}

	public void setModifyBalance(String modifyBalance) {
		this.modifyBalance = modifyBalance;
	}

	public String getModifyBonus() {
		return modifyBonus;
	}

	public void setModifyBonus(String modifyBonus) {
		this.modifyBonus = modifyBonus;
	}
}
