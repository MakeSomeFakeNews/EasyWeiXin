package com.spring4.weixin.api.card;

import com.spring4.utils.HttpClientUtil;

/**
 * CardExApi.java文件：作用简介<br>
 * 特殊卡券API接口<br>
 * 作者:周锦华<br>
 * 日期: 2017年8月7日 下午12:56:18
 */
public class CardExApi {
	private static String meetingTicketUpdateUserUrl = "https://api.weixin.qq.com/card/meetingticket/updateuser?access_token=";

	private static String movieTicketUpdateUserUrl = "https://api.weixin.qq.com/card/movieticket/updateuser?access_token=";

	private static String checkinBoardingpassUrl = "https://api.weixin.qq.com/card/boardingpass/checkin?access_token=";

	/**
	 * 更新会议门票
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {json}
	 */
	public static String update_meeting_ticket_user(String jsonStr, String access_token) {
		String jsonResult = HttpClientUtil.postJson(meetingTicketUpdateUserUrl + access_token, jsonStr);
		return jsonResult;
	}

	/**
	 * 更新电影票
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {json}
	 */
	public static String UpdateMovieTicketUser(String jsonStr, String access_token) {
		String jsonResult = HttpClientUtil.postJson(movieTicketUpdateUserUrl + access_token, jsonStr);
		return jsonResult;
	}

	/**
	 * 更新飞机票信息接口
	 * 
	 * @param jsonStr
	 *            JSON数据
	 * @return {json}
	 */
	public static String checkinBoardingpass(String jsonStr, String access_token) {
		String jsonResult = HttpClientUtil.postJson(checkinBoardingpassUrl + access_token, jsonStr);
		return jsonResult;
	}
}
