package com.spring4.weixin.sdk.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spring4.utils.HttpClientUtil;
import com.spring4.utils.StrKit;
import com.spring4.weixin.sdk.VerifyKit;

public class UserTagApi {

	private String create_tag_url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";

	/**
	 * 参数说明 参数 说明 access_token 调用接口凭据 name 标签名（30个字符以内） 返回说明（正常时返回的json数据包示例） {
	 * "tag":{ "id":134,//标签id "name":"广东" } } 返回参数说明 参数 说明 id 标签id，由微信分配
	 * 
	 * @param access_token
	 * @param tag_name
	 * @return
	 */
	public String create_tag(String access_token, String tag_name) {

		Map<String, Tag> m = new HashMap<String, Tag>();
		m.put("tag", new Tag(tag_name));
		String jsonString = JSON.toJSONString(m);
		String json = HttpClientUtil.postJson(create_tag_url + access_token, jsonString);
		JSONObject parseObject = JSONObject.parseObject(json);
		JSONObject object = parseObject.getJSONObject("tag");
		String tagId = object.getString("id");
		return tagId;
	}

	private String tag_list_url = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=";

	/**
	 * 
	 * 获取公众号已创建的标签
	 * 
	 * @return
	 */
	public List<Tags> get_tag_list(String access_token) {
		String string = HttpClientUtil.get(tag_list_url + access_token);
		List<Tags> tags = new ArrayList<Tags>();
		if (string != null) {
			JSONObject object = JSONObject.parseObject(string);
			JSONArray jsonArray = object.getJSONArray("tag");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object2 = jsonArray.getJSONObject(i);
				Tags t = new Tags();
				t.setId(object2.getInteger("id"));
				t.setName(object2.getString("name"));
				t.setCount(object2.getInteger("count"));
				tags.add(t);
			}
		}
		return tags;
	}

	private String updata_tag_url = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=";

	/**
	 * 编辑标签
	 * 
	 * POST数据例子： { "tag" : { "id" : 134, "name" : "广东人" } } 返回说明 { "errcode":0,
	 * "errmsg":"ok" }
	 * 
	 * @param id
	 * @param name
	 */
	public void updata_tag(Integer id, String name, String access_token) {
		Map<String, Tags> m = new HashMap<String, Tags>();
		m.put("tag", new Tags(id, name, null));
		String jsonString = JSON.toJSONString(m);
		String json = HttpClientUtil.postJson(updata_tag_url + access_token, jsonString);
		VerifyKit.verify(json);
	}

	private String del_tag_url = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=";

	/**
	 * 删除标签
	 * 
	 * @param id
	 * @param access_token
	 */
	public void del_tag(Integer id, String access_token) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		HashMap<String, Object> tags = new HashMap<String, Object>();
		tags.put("id", id);
		data.put("tag", tags);
		String jsonString = JSON.toJSONString(data);
		String json = HttpClientUtil.postJson(del_tag_url + access_token, jsonString);
		VerifyKit.verify(json);
	}

	private String GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=";

	/**
	 * 根据标签获取标签下粉丝列表
	 * 
	 * @param tagId
	 * @param access_token
	 * @return
	 */
	public String get_tag_user(int tagId, String access_token) {
		return get_tag_user(tagId, null, access_token);
	}

	/**
	 * 根据标签获取标签下粉丝列表
	 * 
	 * @param tagId
	 * @param nextOpenId
	 * @param access_token
	 * @return
	 */
	public String get_tag_user(int tagId, String nextOpenId, String access_token) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("tagid", tagId);
		if (StrKit.notBlank(nextOpenId)) {
			data.put("next_openid", nextOpenId);
		}
		String jsonString = JSON.toJSONString(data);
		String json = HttpClientUtil.postJson(GET_USER_URL + access_token, jsonString);
		return json;

	}

	private String BATCH_TAGGING_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=";

	/**
	 * 标签功能目前支持公众号为用户打上最多20个标签。 1. 批量为用户打标签 接口调用请求说明
	 * 
	 * @param access_token
	 * @param tagId
	 * @param openIdList
	 */
	public void batchAddTag(String access_token, int tagId, List<String> openIdList) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("tagid", tagId);
		data.put("openid_list", openIdList);
		String string = JSON.toJSONString(data);
		String json = HttpClientUtil.postJson(BATCH_TAGGING_URL + access_token, string);
		VerifyKit.verify(json);

	}

	private String BATCH_UNTAGGING_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=";

	/**
	 * 批量为用户取消标签
	 * 
	 * @param access_token
	 * @param tagId
	 * @param openIdList
	 */
	public void batchDelTag(String access_token, int tagId, List<String> openIdList) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("tagid", tagId);
		data.put("openid_list", openIdList);
		String jsonString = JSON.toJSONString(data);
		String json = HttpClientUtil.postJson(BATCH_UNTAGGING_URL + access_token, jsonString);
		VerifyKit.verify(json);
	}

	private String GET_ID_LIST_URL = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=";

	/**
	 * 获取用户身上的tag
	 * 
	 * @param access_token
	 * @param openId
	 * @return 标签列表json字符串
	 */
	public String get_user_tag(String access_token, String openId) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("openid", openId);
		String jsonString = JSON.toJSONString(data);
		String json = HttpClientUtil.postJson(GET_ID_LIST_URL + access_token, jsonString);
		return json;
	}

	public static void main(String[] args) {
		// UserApi.create_tag("asdasd", "1111");
		// UserApi u = new UserApi();
		// u.updata_tag(22, "11");
	}

}
