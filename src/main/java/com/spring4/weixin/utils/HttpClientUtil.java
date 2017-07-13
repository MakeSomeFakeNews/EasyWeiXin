package com.spring4.weixin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("deprecation")
public class HttpClientUtil {
	public static HttpClient client = HttpClients.createDefault();

	public static String get(String url) {
		HttpGet get = new HttpGet(url);
		try {
			String response = null;
			HttpResponse httpResponse = client.execute(get);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				response = EntityUtils.toString(httpEntity);
			}
			return response;
		} catch (Exception e) {
			throw new RuntimeException("get请求出现异常" + e.getMessage());
		}
	}

	public static String postJson(String url, String para) {
		HttpPost post = new HttpPost(url);
		try {
			post.setHeader("Content-type", "application/json");
			StringEntity entity = new StringEntity(para, ContentType.create("application/json", "utf-8"));
			System.out.println(entity);
			String response = null;
			post.setEntity(entity);
			HttpResponse httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				response = new String(EntityUtils.toString(httpEntity).getBytes("8859_1"));

			}
			return response;
		} catch (Exception e) {
			throw new RuntimeException("post请求出现异常" + e.getMessage());
		}

	}

	public static String postJson(String url) {
		HttpPost post = new HttpPost(url);
		try {
			post.setHeader("Content-type", "application/json");
			String response = null;
			HttpResponse httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				response = new String(EntityUtils.toString(httpEntity).getBytes("8859_1"));

			}
			return response;
		} catch (Exception e) {
			throw new RuntimeException("post请求出现异常" + e.getMessage());
		}

	}

	/**
	 * 上传多媒体文件 1为临时 2 w
	 * 
	 * @param access_token
	 * @param type
	 *            图片（image）、语音（voice）、视频（video）和缩略图（thumb） 图片（image）: 1M，支持JPG格式
	 *            语音（voice）：2M，播放长度不超过60s，支持AMR\MP3\SPEEX格式
	 *            视频（video）：10MB，支持MP4格式 缩略图（thumb）：64KB，支持JPG格式
	 * @param fileUrl
	 * @return media_id
	 * @throws IOException
	 */
	public static String uploadMedia(String access_token, String type, String fileUrl) throws IOException {
		String media_id = null;
		CloseableHttpResponse response = null;
		String url = "http://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + access_token + "&type=" + type;
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// MultipartEntity mpEntity = new MultipartEntity(); // 文件传输
		FileBody bin = new FileBody(new File(fileUrl));
		builder.addPart("media", bin);
		builder.addPart("access_token", new StringBody(access_token, ContentType.TEXT_PLAIN));
		builder.addPart("type", new StringBody(type, ContentType.TEXT_PLAIN));
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			response = httpclient.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entitys = response.getEntity();
				String jsonString = EntityUtils.toString(entitys);
				JSONObject fromObject = JSONObject.parseObject(jsonString);
				Object media_idObject = fromObject.get("media_id");
				if (media_idObject != null) {
					media_id = media_idObject.toString();
				} else {
					System.out.println(fromObject.toString());
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			if (httpclient != null) {
				httpclient.close();
			}
		}
		return media_id;
	}

	/**
	 * 多媒体下载接口
	 * 
	 * @comment 不支持视频文件的下载
	 * @param fileName
	 *            素材存储文件路径
	 * @param token
	 *            认证token
	 * @param mediaId
	 *            素材ID（对应上传后获取到的ID）
	 * @return 素材文件
	 */
	public static File downloadMedia(String fileName, String token, String mediaId) {
		String url = getDownloadUrl(token, mediaId);
		return httpRequestToFile(fileName, url, "GET", null);
	}

	/**
	 * 以http方式发送请求,并将请求响应内容输出到文件
	 * 
	 * @param path
	 *            请求路径
	 * @param method
	 *            请求方法
	 * @param body
	 *            请求数据
	 * @return 返回响应的存储到文件
	 */
	public static File httpRequestToFile(String fileName, String path, String method, String body) {
		if (fileName == null || path == null || method == null) {
			return null;
		}

		File file = null;
		HttpURLConnection conn = null;
		InputStream inputStream = null;
		FileOutputStream fileOut = null;
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			if (null != body) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(body.getBytes("UTF-8"));
				outputStream.close();
			}

			inputStream = conn.getInputStream();
			if (inputStream != null) {
				file = new File(fileName);
			} else {
				return file;
			}

			// 写入到文件
			fileOut = new FileOutputStream(file);
			if (fileOut != null) {
				int c = inputStream.read();
				while (c != -1) {
					fileOut.write(c);
					c = inputStream.read();
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}

			/*
			 * 必须关闭文件流 否则JDK运行时，文件被占用其他进程无法访问
			 */
			try {
				inputStream.close();
				fileOut.close();
			} catch (IOException execption) {
				System.err.println(execption);
			}
		}
		return file;
	}

	public static String getDownloadUrl(String token, String mediaId) {
		return "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
				.replace("ACCESS_TOKEN", token).replace("MEDIA_ID", mediaId);
	}

	public static String uploadImg(String access_token, String fileUrl) throws IOException {
		String media_id = null;
		CloseableHttpResponse response = null;
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + access_token;
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// MultipartEntity mpEntity = new MultipartEntity(); // 文件传输
		FileBody bin = new FileBody(new File(fileUrl));
		builder.addPart("media", bin);
		builder.addPart("access_token", new StringBody(access_token, ContentType.TEXT_PLAIN));
		builder.addPart("type", new StringBody("image", ContentType.TEXT_PLAIN));
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			response = httpclient.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entitys = response.getEntity();
				media_id = EntityUtils.toString(entitys);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			if (httpclient != null) {
				httpclient.close();
			}
		}
		return media_id;
	}

	public static String uploadMaterial(String access_token, String type, String fileUrl) throws IOException {
		String media_id = null;
		CloseableHttpResponse response = null;
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + access_token + "&type="
				+ type;
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// MultipartEntity mpEntity = new MultipartEntity(); // 文件传输
		FileBody bin = new FileBody(new File(fileUrl));
		builder.addPart("media", bin);
		builder.addPart("access_token", new StringBody(access_token, ContentType.TEXT_PLAIN));
		builder.addPart("type", new StringBody(type, ContentType.TEXT_PLAIN));
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			response = httpclient.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entitys = response.getEntity();
				String jsonString = EntityUtils.toString(entitys);
				JSONObject fromObject = JSONObject.parseObject(jsonString);
				Object media_idObject = fromObject.get("media_id");
				if (media_idObject != null) {
					media_id = media_idObject.toString();
				} else {
					System.out.println(fromObject.toString());
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			if (httpclient != null) {
				httpclient.close();
			}
		}
		return media_id;
	}

	public static String uploadMaterial(String access_token, String type, String fileUrl, String json)
			throws IOException {
		String media_id = null;
		CloseableHttpResponse response = null;
		String url = "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + access_token + "&type="
				+ type;
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// MultipartEntity mpEntity = new MultipartEntity(); // 文件传输
		FileBody bin = new FileBody(new File(fileUrl));
		builder.addPart("media", bin);
		builder.addPart("access_token", new StringBody(access_token, ContentType.TEXT_PLAIN));
		builder.addPart("type", new StringBody(type, ContentType.TEXT_PLAIN));
		builder.addPart("description", new StringBody(json, ContentType.APPLICATION_JSON));
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			response = httpclient.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity entitys = response.getEntity();
				media_id = EntityUtils.toString(entitys);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			if (httpclient != null) {
				httpclient.close();
			}
		}
		return media_id;
	}

	public static void downLoad(String localFileName,String para,String url) {
		@SuppressWarnings("resource")
		DefaultHttpClient httpClient = new DefaultHttpClient();
        OutputStream out = null;
        InputStream in = null;
        
        try {
        	HttpPost httpPost = new HttpPost("");
        	httpPost.setHeader("Content-type", "application/json");
			StringEntity entitys = new StringEntity(para, ContentType.create("application/json", "utf-8"));
            httpPost.setEntity(entitys);
			

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            in = entity.getContent();

            long length = entity.getContentLength();
            if (length <= 0) {
                System.out.println("下载文件不存在！");
                return;
            }

            System.out.println("The response value of token:" + httpResponse.getFirstHeader("token"));

            File file = new File(localFileName);
            if(!file.exists()){
                file.createNewFile();
            }
            
            out = new FileOutputStream(file);  
            byte[] buffer = new byte[4096];
            int readLength = 0;
            while ((readLength=in.read(buffer)) > 0) {
                byte[] bytes = new byte[readLength];
                System.arraycopy(buffer, 0, bytes, 0, readLength);
                out.write(bytes);
            }
            
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try {
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	
	
}
