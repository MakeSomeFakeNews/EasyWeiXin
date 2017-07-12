package com.spring4.weixin.sdk.msg.in.event;

public class InMenuEvent extends InEventMessage {

	// 1. 点击菜单拉取消息时的事件推送： CLICK
	public static final String EVENT_INMENU_CLICK = "CLICK";
	// 2. 点击菜单跳转链接时的事件推送： VIEW
	public static final String EVENT_INMENU_VIEW = "VIEW";
	// 3. scancode_push：扫码推事件
	public static final String EVENT_INMENU_SCANCODE_PUSH = "scancode_push";
	// 4. scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框
	public static final String EVENT_INMENU_scancode_waitmsg = "scancode_waitmsg";
	// 5. pic_sysphoto：弹出系统拍照发图
	public static final String EVENT_INMENU_PIC_SYSPHOTO = "pic_sysphoto";
	// 6. pic_photo_or_album：弹出拍照或者相册发图，先推送菜单事件，再推送图片消息
	public static final String EVENT_INMENU_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	// 7. pic_weixin：弹出微信相册发图器
	public static final String EVENT_INMENU_PIC_WEIXIN = "pic_weixin";
	// 8. location_select：弹出地理位置选择器
	public static final String EVENT_INMENU_LOCATION_SELECT = "location_select";
	// 9. media_id：下发消息（除文本消息）
	public static final String EVENT_INMENU_MEDIA_ID = "media_id";
	// 10. view_limited：跳转图文消息URL
	public static final String EVENT_INMENU_VIEW_LIMITED = "view_limited";

	private String eventKey;
	private ScanInfo scanCodeInfo;

	public InMenuEvent(String toUserName, String fromUserName, Integer createTime, String event) {
		super(toUserName, fromUserName, createTime, event);
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public ScanInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanInfo scanInfo) {
		this.scanCodeInfo = scanInfo;
	}

}
