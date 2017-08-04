package com.spring4.weixin.sdk.wx;

import com.spring4.utils.ApiConfigKit;
import com.spring4.utils.PropertiesUtil;
import com.spring4.weixin.sdk.msg.InMessageResolve;
import com.spring4.weixin.sdk.msg.in.InEquDataMsg;
import com.spring4.weixin.sdk.msg.in.InImageMessage;
import com.spring4.weixin.sdk.msg.in.InLinkMessage;
import com.spring4.weixin.sdk.msg.in.InLocationMessage;
import com.spring4.weixin.sdk.msg.in.InMessage;
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
/**
 * Date:2017年7月1日1:51:21 
 * @author spring4
 */
public class WeiXinMessageHandel {
	private String defaultMessageHandel = "com.spring4.weixin.sdk.wx.DefaultHandelImp";

	public String getOutMsg(String inMsg) {
		DefaultHandel handel = null;
		// 开发模式输出微信服务发送过来的 xml 消息
		if (ApiConfigKit.isDevMode()) {
			System.out.println("接收消息:");
			System.out.println();
		}

		try {
			// 如果用户重写消息处理器则实例化用户的消息处理器
			String handler = PropertiesUtil.getProperty("handler");
			// 否则使用默认
			if (handler != null) {
				defaultMessageHandel = handler;
			}
			Class<?> z = Class.forName(defaultMessageHandel);
			try {
				// 实例化处理器
				handel = (DefaultHandel) z.newInstance();
			} catch (InstantiationException e) {
				System.err.println("初始化异常:" + e.getMessage());
			} catch (IllegalAccessException e) {
				System.err.println("非法存取异常：" + e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.err.println("未找到类：" + e.getMessage());
			e.printStackTrace();
		}

		// 解析消息并根据消息类型分发到相应的处理方法
		InMessage msg = InMessageResolve.parse(inMsg);
		String out = null;
		if (msg instanceof InTextMessage)
			out = handel.processInTextMsg((InTextMessage) msg);
		else if (msg instanceof InImageMessage)
			out = handel.processInImageMsg((InImageMessage) msg);
		else if (msg instanceof InSpeechRecognittionRes) // update by unas at
															// 2016-1-29,
															// 由于继承InVoiceMsg，需要在InVoiceMsg前判断类型
			out = handel.processInSpeechRecognitionResults((InSpeechRecognittionRes) msg);
		else if (msg instanceof InVoiceMessage)
			out = handel.processInVoiceMsg((InVoiceMessage) msg);
		else if (msg instanceof InVideoMessage)
			out = handel.processInVideoMsg((InVideoMessage) msg);
		else if (msg instanceof InShortVideoMessage) // 支持小视频
			out = handel.processInShortVideoMsg((InShortVideoMessage) msg);
		else if (msg instanceof InLocationMessage)
			out = handel.processInLocationMsg((InLocationMessage) msg);
		else if (msg instanceof InLinkMessage)
			out = handel.processInLinkMsg((InLinkMessage) msg);
		else if (msg instanceof InCustomEvent)
			out = handel.processInCustomEvent((InCustomEvent) msg);
		else if (msg instanceof InSubscribeEvent)
			out = handel.processInFollowEvent((InSubscribeEvent) msg);
		else if (msg instanceof InScanQRCodeEvent)
			out = handel.processInQrCodeEvent((InScanQRCodeEvent) msg);
		else if (msg instanceof InUpLoadLocationEvent)
			out = handel.processInLocationEvent((InUpLoadLocationEvent) msg);
		else if (msg instanceof InMassEvent)
			out = handel.processInMassEvent((InMassEvent) msg);
		else if (msg instanceof InMenuEvent)
			out = handel.processInMenuEvent((InMenuEvent) msg);
		else if (msg instanceof InTemplateMsgEvent)
			out = handel.processInTemplateMsgEvent((InTemplateMsgEvent) msg);
		else if (msg instanceof InShakearoundUserShakeEvent)
			out = handel.processInShakearoundUserShakeEvent((InShakearoundUserShakeEvent) msg);
		else if (msg instanceof InVerifySuccessEvent)
			out = handel.processInVerifySuccessEvent((InVerifySuccessEvent) msg);
		else if (msg instanceof InVerifyFailEvent)
			out = handel.processInVerifyFailEvent((InVerifyFailEvent) msg);
		else if (msg instanceof InPoiCheckNotifyEvent)
			out = handel.processInPoiCheckNotifyEvent((InPoiCheckNotifyEvent) msg);
		else if (msg instanceof InWifiEvent)
			out = handel.processInWifiEvent((InWifiEvent) msg);
		else if (msg instanceof InUserCardEvent)
			out = handel.processInUserCardEvent((InUserCardEvent) msg);
		else if (msg instanceof InUpdateMemberCardEvent)
			out = handel.processInUpdateMemberCardEvent((InUpdateMemberCardEvent) msg);
		else if (msg instanceof InUserPayFromCardEvent)
			out = handel.processInUserPayFromCardEvent((InUserPayFromCardEvent) msg);
		else if (msg instanceof InMerChantOrderEvent)
			out = handel.processInMerChantOrderEvent((InMerChantOrderEvent) msg);
		else if (msg instanceof InCardPassCheckEvent)
			out = handel.processInCardPassCheckEvent((InCardPassCheckEvent) msg);
		else if (msg instanceof InCardPayOrderEvent)
			out = handel.processInCardPayOrderEvent((InCardPayOrderEvent) msg);
		else if (msg instanceof InCardSkuRemindEvent)
			out = handel.processInCardSkuRemindEvent((InCardSkuRemindEvent) msg);
		else if (msg instanceof InUserConsumeCardEvent)
			out = handel.processInUserConsumeCardEvent((InUserConsumeCardEvent) msg);
		else if (msg instanceof InUserGetCardEvent)
			out = handel.processInUserGetCardEvent((InUserGetCardEvent) msg);
		else if (msg instanceof InUserGiftingCardEvent)
			out = handel.processInUserGiftingCardEvent((InUserGiftingCardEvent) msg);
		else if (msg instanceof InEqubindEvent)
			out = handel.processInEqubindEvent((InEqubindEvent) msg);
		else if (msg instanceof InEquDataMsg)
			out = handel.processInEquDataMsg((InEquDataMsg) msg);
		// ===================微信智能硬件========================//
		else if (msg instanceof InEqubindEvent)
			out = handel.processInEqubindEvent((InEqubindEvent) msg);
		else if (msg instanceof InEquDataMsg)
			out = handel.processInEquDataMsg((InEquDataMsg) msg);
		// ===================微信智能硬件========================//
		else if (msg instanceof InNotDefinedEvent) {
			System.err.println("未能识别的事件类型。 消息 xml 内容为：\n" + inMsg);
			out = handel.processIsNotDefinedEvent((InNotDefinedEvent) msg);
		} else if (msg instanceof InNotDefinedEvent) {
			System.err.println("未能识别的消息类型。 消息 xml 内容为：\n" + inMsg);
			out = handel.processIsNotDefinedMsg((InNotDefinedMessage) msg);
		}
		return out;
	}

}
