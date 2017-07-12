package com.spring4.weixin.sdk.msg.out;

import java.util.ArrayList;
import java.util.List;
import com.spring4.weixin.sdk.msg.in.InMessage;

public class OutNewsMessage extends OutMessage {

	private static final long serialVersionUID = -4443886181809202917L;
	private List<News> articles = new ArrayList<News>();

	public OutNewsMessage() {
		this.msgType = "news";
	}

	public OutNewsMessage(InMessage inMsg) {
		super(inMsg);
		this.msgType = "news";
	}

	@Override
	protected void subXml(StringBuilder sb) {
		sb.append("<ArticleCount>").append(getArticleCount()).append("</ArticleCount>\n");
		sb.append("<Articles>\n");
		for (News x : articles) {
			sb.append("<item>\n");

			sb.append("<Title><![CDATA[").append(nullToBlank(x.getTitle())).append("]]></Title>\n");
			sb.append("<Description><![CDATA[").append(nullToBlank(x.getDescription())).append("]]></Description>\n");
			sb.append("<PicUrl><![CDATA[").append(nullToBlank(x.getPicUrl())).append("]]></PicUrl>\n");
			sb.append("<Url><![CDATA[").append(nullToBlank(x.getUrl())).append("]]></Url>\n");

			sb.append("</item>\n");
		}
		sb.append("</Articles>\n");
	}

	public Integer getArticleCount() {
		return articles.size();
	}

	public List<News> getArticles() {
		return articles;
	}

	public void setArticles(List<News> articles) {
		if (articles != null)
			this.articles = articles;
	}

	public OutNewsMessage addNews(List<News> articles) {
		if (articles != null)
			this.articles.addAll(articles);
		return this;
	}

	public OutNewsMessage addNews(String title, String description, String picUrl, String url) {
		this.articles.add(new News(title, description, picUrl, url));
		return this;
	}

	public OutNewsMessage addNews(News news) {
		this.articles.add(news);
		return this;
	}

}
