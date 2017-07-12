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
/**
 * Date:2017年7月12日11:33:11 
 * @author spring4
 */
public abstract class DefaultHandel {
	/**
	 * 处理接收到的文本消息
	 * 
	 * @param inTextMsg
	 *            处理接收到的文本消息
	 */
	protected abstract String processInTextMsg(InTextMessage inTextMsg);

	/**
	 * 处理接收到的图片消息
	 * 
	 * @param inImageMsg
	 *            处理接收到的图片消息
	 */
	protected abstract String processInImageMsg(InImageMessage inImageMsg);

	/**
	 * 处理接收到的语音消息
	 * 
	 * @param inVoiceMsg
	 *            处理接收到的语音消息
	 */
	protected abstract String processInVoiceMsg(InVoiceMessage inVoiceMsg);

	/**
	 * 处理接收到的视频消息
	 * 
	 * @param inVideoMsg
	 *            处理接收到的视频消息
	 */
	protected abstract String processInVideoMsg(InVideoMessage inVideoMsg);

	/**
	 * 处理接收到的小视频消息
	 * 
	 * @param inShortVideoMsg
	 *            处理接收到的小视频消息
	 */
	protected abstract String processInShortVideoMsg(InShortVideoMessage inShortVideoMsg);

	/**
	 * 处理接收到的地址位置消息
	 * 
	 * @param inLocationMsg
	 *            处理接收到的地址位置消息
	 */
	protected abstract String processInLocationMsg(InLocationMessage inLocationMsg);

	/**
	 * 处理接收到的链接消息
	 * 
	 * @param inLinkMsg
	 *            处理接收到的链接消息
	 */
	protected abstract String processInLinkMsg(InLinkMessage inLinkMsg);

	/**
	 * 处理接收到的多客服管理事件
	 * 
	 * @param inCustomEvent
	 *            处理接收到的多客服管理事件
	 */
	protected abstract String processInCustomEvent(InCustomEvent inCustomEvent);

	/**
	 * 处理接收到的关注/取消关注事件
	 * 
	 * @param inFollowEvent
	 *            处理接收到的关注/取消关注事件
	 */
	protected abstract String processInFollowEvent(InSubscribeEvent inFollowEvent);

	/**
	 * 处理接收到的扫描带参数二维码事件
	 * 
	 * @param inQrCodeEvent
	 *            处理接收到的扫描带参数二维码事件
	 */
	protected abstract String processInQrCodeEvent(InScanQRCodeEvent inQrCodeEvent);

	/**
	 * 处理接收到的上报地理位置事件
	 * 
	 * @param inLocationEvent
	 *            处理接收到的上报地理位置事件
	 */
	protected abstract String processInLocationEvent(InUpLoadLocationEvent inLocationEvent);

	/**
	 * 处理接收到的群发任务结束时通知事件
	 * 
	 * @param inMassEvent
	 *            处理接收到的群发任务结束时通知事件
	 */
	protected abstract String processInMassEvent(InMassEvent inMassEvent);

	/**
	 * 处理接收到的自定义菜单事件
	 * 
	 * @param inMenuEvent
	 *            处理接收到的自定义菜单事件
	 */
	protected abstract String processInMenuEvent(InMenuEvent inMenuEvent);

	/**
	 * 处理接收到的语音识别结果
	 * 
	 * @param inSpeechRecognitionResults
	 *            处理接收到的语音识别结果
	 */
	protected abstract String processInSpeechRecognitionResults(InSpeechRecognittionRes inSpeechRecognitionResults);

	/**
	 * 处理接收到的模板消息是否送达成功通知事件
	 * 
	 * @param inTemplateMsgEvent
	 *            处理接收到的模板消息是否送达成功通知事件
	 */
	protected abstract String processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent);

	/**
	 * 处理微信摇一摇事件
	 * 
	 * @param inShakearoundUserShakeEvent
	 *            处理微信摇一摇事件
	 */
	protected abstract String processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent);

	/**
	 * 资质认证成功 || 名称认证成功 || 年审通知 || 认证过期失效通知
	 * 
	 * @param inVerifySuccessEvent
	 *            资质认证成功 || 名称认证成功 || 年审通知 || 认证过期失效通知
	 */
	protected abstract String processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent);

	/**
	 * 资质认证失败 || 名称认证失败
	 * 
	 * @param inVerifyFailEvent
	 *            资质认证失败 || 名称认证失败
	 */
	protected abstract String processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent);

	/**
	 * 门店在审核事件消息
	 * 
	 * @param inPoiCheckNotifyEvent
	 *            门店在审核事件消息
	 */
	protected abstract String processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent);

	/**
	 * WIFI连网后下发消息 by unas at 2016-1-29
	 * 
	 * @param inWifiEvent
	 *            WIFI连网后下发消息
	 */
	protected abstract String processInWifiEvent(InWifiEvent inWifiEvent);

	/**
	 * 1. 微信会员卡二维码扫描领取接口 2. 微信会员卡激活接口 3. 卡券删除事件推送 4. 从卡券进入公众号会话事件推送
	 * 
	 * @param inUserCardEvent
	 *            InUserCardEvent
	 */
	protected abstract String processInUserCardEvent(InUserCardEvent inUserCardEvent);

	/**
	 * 微信会员卡积分变更
	 * 
	 * @param inUpdateMemberCardEvent
	 *            微信会员卡积分变更
	 */
	protected abstract String processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent);

	/**
	 * 微信会员卡快速买单
	 * 
	 * @param inUserPayFromCardEvent
	 *            微信会员卡快速买单
	 */
	protected abstract String processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent);

	/**
	 * 微信小店订单支付成功接口消息
	 * 
	 * @param inMerChantOrderEvent
	 *            微信小店订单支付成功接口消息
	 */
	protected abstract String processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent);

	//
	/**
	 * 没有找到对应的事件消息
	 * 
	 * @param inNotDefinedEvent
	 *            没有对应的事件消息
	 */
	protected abstract String processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent);

	/**
	 * 没有找到对应的消息
	 * 
	 * @param msg
	 *            没有对应消息
	 */
	protected abstract String processIsNotDefinedMsg(InNotDefinedMessage msg);

	/**
	 * 卡券转赠事件推送
	 * 
	 * @param msg
	 *            卡券转赠事件推送
	 */
	protected abstract String processInUserGiftingCardEvent(InUserGiftingCardEvent msg);

	/**
	 * 卡券领取事件推送
	 * 
	 * @param msg
	 *            卡券领取事件推送
	 */
	protected abstract String processInUserGetCardEvent(InUserGetCardEvent msg);

	/**
	 * 卡券核销事件推送
	 * 
	 * @param msg
	 *            卡券核销事件推送
	 */
	protected abstract String processInUserConsumeCardEvent(InUserConsumeCardEvent msg);

	/**
	 * 卡券库存报警事件
	 * 
	 * @param msg
	 *            卡券库存报警事件
	 */
	protected abstract String processInCardSkuRemindEvent(InCardSkuRemindEvent msg);

	/**
	 * 券点流水详情事件
	 * 
	 * @param msg
	 *            券点流水详情事件
	 */
	protected abstract String processInCardPayOrderEvent(InCardPayOrderEvent msg);

	/**
	 * 审核事件推送
	 * 
	 * @param msg
	 *            审核事件推送
	 */
	protected abstract String processInCardPassCheckEvent(InCardPassCheckEvent msg);

	/**
	 * 处理微信硬件绑定和解绑事件
	 * 
	 * @param msg
	 *            处理微信硬件绑定和解绑事件
	 */
	protected abstract String processInEqubindEvent(InEqubindEvent msg);

	/**
	 * 处理微信硬件发来数据
	 * 
	 * @param msg
	 *            处理微信硬件发来数据
	 */
	protected abstract String processInEquDataMsg(InEquDataMsg msg);

}
