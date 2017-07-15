package com.spring4.weixin.sdk.media;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.spring4.weixin.sdk.VerifyKit;
import com.spring4.weixin.utils.HttpClientUtil;
/**
 * Date:2017年7月13日15:21:21 
 * @author spring4
 */
public class MediaApi {
	/**
	 * 上传一个临时素材
	 * 
	 * @param access_token
	 * @param type
	 *            文件类型
	 * @param fileUrl
	 *            上传的文件路径
	 * @throws IOException
	 * @return 返回mediaId
	 */
	public String upload_temp_media(String access_token, String type, String fileUrl) throws IOException {
		String media = HttpClientUtil.uploadMedia(access_token, type, fileUrl);
		return media;
	}

	private String newsUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

	public String addNews(List<MediaArticles> mediaArticles) {
		String json = null;
		if (mediaArticles != null) {
			json = JSON.toJSONString(mediaArticles);
		}
		String media_id_json = HttpClientUtil.postJson(newsUrl, json);
		return media_id_json;
	}

	/**
	 * 
	 * @param access_token
	 * @param fileUrl
	 * @return 返回说明 正常情况下的返回结果为： { "url":
	 *         "http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs
	 *         CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0" }
	 * @throws IOException
	 */
	public String upload_image(String access_token, String fileUrl) throws IOException {
		String url = HttpClientUtil.uploadImg(access_token, fileUrl);
		return url;
	}

	/**
	 * 新增其他类型永久素材 接口调用请求说明
	 * 通过POST表单来调用接口，表单id为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
	 * 
	 * @param access_token
	 * @param type
	 * @param fileUrl
	 * @return media
	 * @throws IOException
	 */
	public String upload_material_media(String access_token, String type, String fileUrl) throws IOException {
		String media = HttpClientUtil.uploadMaterial(access_token, type, fileUrl);
		return media;
	}

	/**
	 * access_token 是 调用接口凭证 type 是
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb） media 是
	 * form-data中媒体文件标识，有filename、filelength、content-type等信息 新增永久视频素材需特别注意
	 * 在上传视频素材时需要POST另一个表单，id为description
	 * 
	 * media_id 新增的永久素材的media_id url 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
	 * 
	 * @param access_token
	 * @param type
	 * @param fileUrl
	 * @param title
	 * @param introduction
	 * @return
	 * @throws IOException
	 */

	public String upload_video(String access_token, String type, String fileUrl, String title, String introduction)
			throws IOException {
		Map<String, String> m = new HashMap<String, String>();
		m.put("title", title);
		m.put("introduction", introduction);
		String json = JSON.toJSONString(m);
		String uploadMaterial = HttpClientUtil.uploadMaterial(access_token, type, fileUrl, json);
		return uploadMaterial;
	}

	// 获取永久素材
	private String get_material_url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";

	/**
	 * 获取永久素材
	 * 
	 * @param media_id
	 *            要获取的素材的media_id
	 * @return InputStream 流，考虑到这里可能返回json或file请自行使用IOUtils转换
	 */
	public void getMaterial(String media_id, String access_token) {
		String url = get_material_url + access_token;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("media_id", media_id);
		String json = JSON.toJSONString(dataMap);
		HttpClientUtil.downLoad(access_token, json, url);
	}

	private String del_media_url = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";

	/**
	 * 删除永久素材
	 * 
	 * @param mediaID
	 */
	public void del_material_media(String mediaId, String access_token) {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("media_id", mediaId);
		String json = JSON.toJSONString(m);
		String result = HttpClientUtil.postJson(del_media_url.replace("access_token", access_token), json);
		VerifyKit.verify(result);
	}

	private String update_news_url = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";

	/**
	 * 修改永久图文素材
	 * 
	 * @param media_id
	 *            要修改的图文消息的id
	 * @param index
	 *            要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
	 * @param mediaArticles
	 *            图文素材
	 * @return ApiResult 返回信息
	 */
	public void updata_news(String media_id, int index, MediaArticles mediaArticles, String access_token) {
		String url = update_news_url + access_token;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("media_id", media_id);
		dataMap.put("index", index);
		dataMap.put("articles", mediaArticles);
		String jsonString = JSON.toJSONString(dataMap);
		String json = HttpClientUtil.postJson(url, jsonString);
		VerifyKit.verify(json);
	}

	private String media_count_url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";

	/**
	 * 获取素材总数 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。 请注意： 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
	 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000 3.调用该接口需https协议 接口调用请求说明
	 * 
	 * @param access_token
	 */
	public String get_meida_count(String access_token) {
		String string = HttpClientUtil.get(media_count_url);
		VerifyKit.verify(string);
		return string;
	}

	private String batchget_material_url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";

	/**
	 * 获取素材列表
	 * 
	 * @param mediaType
	 *            素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	 * @param offset
	 *            从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count
	 *            返回素材的数量，取值在1到20之间
	 * @return ApiResult 返回信息
	 */
	public String batchGetMaterial(MediaType mediaType, int offset, int count, String access_token) {
		String url = batchget_material_url + access_token;

		if (offset < 0)
			offset = 0;
		if (count > 20)
			count = 20;
		if (count < 1)
			count = 1;

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("type", mediaType.get());
		dataMap.put("offset", offset);
		dataMap.put("count", count);
		String para = JSON.toJSONString(dataMap);
		String string = HttpClientUtil.postJson(url, para);
		return string;
	}
}
