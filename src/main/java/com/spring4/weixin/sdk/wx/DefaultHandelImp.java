package com.spring4.weixin.sdk.wx;

import com.spring4.weixin.sdk.msg.in.InEquDataMsg;
import com.spring4.weixin.sdk.msg.in.InImageMessage;
import com.spring4.weixin.sdk.msg.in.InLinkMessage;
import com.spring4.weixin.sdk.msg.in.InLocationMessage;
import com.spring4.weixin.sdk.msg.in.InNotDefinedMessage;
import com.spring4.weixin.sdk.msg.in.InShortVideoMessage;
import com.spring4.weixin.sdk.msg.in.InSpeechRecognittionRes;
import com.spring4.weixin.sdk.msg.in.InTextMessage;
import com.spring4.weixin.sdk.msg.in.InVideoMessage;
import com.spring4.weixin.sdk.msg.in.InVoiceMessage;
import com.spring4.weixin.sdk.msg.in.card.InCardPassCheckEvent;
import com.spring4.weixin.sdk.msg.in.card.InCardPayOrderEvent;
import com.spring4.weixin.sdk.msg.in.card.InCardSkuRemindEvent;
import com.spring4.weixin.sdk.msg.in.card.InMerChantOrderEvent;
import com.spring4.weixin.sdk.msg.in.card.InUpdateMemberCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserConsumeCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserGetCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserGiftingCardEvent;
import com.spring4.weixin.sdk.msg.in.card.InUserPayFromCardEvent;
import com.spring4.weixin.sdk.msg.in.event.InCustomEvent;
import com.spring4.weixin.sdk.msg.in.event.InEqubindEvent;
import com.spring4.weixin.sdk.msg.in.event.InMassEvent;
import com.spring4.weixin.sdk.msg.in.event.InMenuEvent;
import com.spring4.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.spring4.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.spring4.weixin.sdk.msg.in.event.InScanQRCodeEvent;
import com.spring4.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.spring4.weixin.sdk.msg.in.event.InSubscribeEvent;
import com.spring4.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.spring4.weixin.sdk.msg.in.event.InUpLoadLocationEvent;
import com.spring4.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.spring4.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.spring4.weixin.sdk.msg.in.event.InWifiEvent;
import com.spring4.weixin.sdk.msg.out.OutTextMessage;
/**
 * Date:2017年7月11日17:45:21 
 * @author spring4
 */
public class DefaultHandelImp extends DefaultHandel {

	@Override
	protected String processInTextMsg(InTextMessage inTextMsg) {
		OutTextMessage out = new OutTextMessage(inTextMsg);
		out.setContent("消息已收到");
		return out.toXml();

	}

	@Override
	protected String processInImageMsg(InImageMessage inImageMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inImageMsg);
		out.setContent("消息已收到");
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInVoiceMsg(InVoiceMessage inVoiceMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inVoiceMsg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInVideoMsg(InVideoMessage inVideoMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inVideoMsg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInShortVideoMsg(InShortVideoMessage inShortVideoMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inShortVideoMsg);
		out.setContent("消息已收到");

		return out.toXml();
	}

	@Override
	protected String processInLocationMsg(InLocationMessage inLocationMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inLocationMsg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInLinkMsg(InLinkMessage inLinkMsg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inLinkMsg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInCustomEvent(InCustomEvent inCustomEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inCustomEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInFollowEvent(InSubscribeEvent inFollowEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inFollowEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInQrCodeEvent(InScanQRCodeEvent inQrCodeEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inQrCodeEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInLocationEvent(InUpLoadLocationEvent inLocationEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inLocationEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInMassEvent(InMassEvent inMassEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inMassEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInMenuEvent(InMenuEvent inMenuEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inMenuEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInSpeechRecognitionResults(InSpeechRecognittionRes inSpeechRecognitionResults) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inSpeechRecognitionResults);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inTemplateMsgEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inShakearoundUserShakeEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inVerifySuccessEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inVerifyFailEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inPoiCheckNotifyEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInWifiEvent(InWifiEvent inWifiEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inWifiEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUserCardEvent(InUserCardEvent inUserCardEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inUserCardEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inUpdateMemberCardEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inUserPayFromCardEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inMerChantOrderEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(inNotDefinedEvent);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processIsNotDefinedMsg(InNotDefinedMessage msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUserGiftingCardEvent(InUserGiftingCardEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUserGetCardEvent(InUserGetCardEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInUserConsumeCardEvent(InUserConsumeCardEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInCardSkuRemindEvent(InCardSkuRemindEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInCardPayOrderEvent(InCardPayOrderEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInCardPassCheckEvent(InCardPassCheckEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInEqubindEvent(InEqubindEvent msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

	@Override
	protected String processInEquDataMsg(InEquDataMsg msg) {
		// TODO Auto-generated method stub
		OutTextMessage out = new OutTextMessage(msg);
		out.setContent("消息已收到");
		return out.toXml();
	}

}
