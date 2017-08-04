# EasyWeiXin
让微信开发变得更加简单
作者:QQ:[1239181712](http://wpa.qq.com/msgrd?v=3&uin=1239181712&site=qq&menu=yes)<br>
交流群:454197074
# 快速搭建微信公众平台服务器<br>
简单封装了所有与微信服务器交互的消息:文本消息、图片消息、图文消息等等<br>
提供MenuAPI、UserApi、UserTagAPI、MediaAPI、OauthAPI。。。。等等等等用于实现所有高级接口功能，使用极其简单<br>

Demo---传送门：(https://github.com/adminzhou/EasyWeChatDemo)
## 关于函数名 
 我喜欢get_xxx_xxx的方式命名。虽然 ！！不规范，   那你来打我啊
# 使用步骤
## 1.下载EasyWeChat
## 2.将EasyWechat引入项目
## 3.新建weixin.properties
### 3.1配置weixin.properties文件
开发者模式<br>
devMode = true<br>
微信接入token<br>
token = easywechat<br>
第三方用户凭证<br>
appid = wx0f687dead13778fb<br>
第三方用户密钥<br>
appsecret = fa593b36a401c7c59d8ea978018f9a5b<br>
oauthUrl 网页授权链接<br>
url = http://1467a8b6.ngrok.io/oauth<br>
消息处理器<br>
handler = cn.spring4.weixin.WeixinHandler<br>
### 3.2更换配置信息
==================================================
## 基于`springmvc`项目的集成方法
```Java
@Controller
public class HelloWorld {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 接入微信，并且向微信返回信息</br>
	 * 接入流程请看 拦截器
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/weixin", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String weixin(HttpServletRequest request) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String outMsg = Weixin.getOutMsg(inputStream);
		return outMsg;
	}

	/**
	 * 获取用户授权，并且获取用户资料
	 * 
	 * @param code
	 * @param resp
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/oauth")
	public void oauth(String code, HttpServletResponse resp) throws IOException, NoSuchAlgorithmException {
		Oauth2 o2 = new Oauth2();
		if (StrKit.isBlank(code)) {
			resp.sendRedirect(o2.getSnsapi_userinfoUrl());
			return;
		}
		Oauth2Token token = o2.login(code);
		UserInfo info = o2.getUserInfo(token.getAccess_token(), token.getOpenid());
		System.out.println("info==" + info.toString());
		return;
	}
}
```
## 拦截器
```Java
public class WeixinInterceptor implements HandlerInterceptor {
	/**
	 * 如果请求为get，则为微信认证接入
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			return true;
		}
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		boolean checkSignature = WeiXinAccess.checkSignature(PropertiesUtil.getToken(), signature, timestamp, nonce);
		if (!checkSignature) {
			System.out.println("请确认请求是否来自微信");
			return false;
		}
		response.getOutputStream().write(echostr.getBytes("utf-8"));
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
```
<br>
web.xml配置

```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
	<filter>
		<filter-name>CharacterEncodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>CharacterEncodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	<servlet>
		<servlet-name>spring</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/springmvc.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>spring</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
</web-app>
```

<br>
springmvc

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/aop   
        http://www.springframework.org/schema/aop/spring-aop-3.0.xsd   
        http://www.springframework.org/schema/beans   
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd   
        http://www.springframework.org/schema/context   
        http://www.springframework.org/schema/context/spring-context-3.0.xsd   
        http://www.springframework.org/schema/mvc   
        http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd   
        http://www.springframework.org/schema/tx   
        http://www.springframework.org/schema/tx/spring-tx-3.0.xsd">

	<mvc:annotation-driven />
	<context:component-scan base-package="cn.spring4.controller" />
	<!--配置拦截器, 多个拦截器,顺序执行 -->
	<mvc:interceptors>
		<mvc:interceptor>
			<!-- 匹配的是url路径， 如果不配置或/**,将拦截所有的Controller -->
			<mvc:mapping path="/weixin" />
			<bean class="cn.spring4.interceptor.WeixinInterceptor"></bean>
		</mvc:interceptor>
		<!-- 当设置多个拦截器时，先按顺序调用preHandle方法，然后逆序调用每个拦截器的postHandle和afterCompletion方法 -->
	</mvc:interceptors>
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/" />
		<property name="suffix" value=".jsp" />
	</bean>

</beans>  
```




Maven 项目引入
==========
```xml
<dependency>
	<groupId>org.apache.httpcomponents</groupId>
	<artifactId>httpmime</artifactId>
	<version>4.5.2</version>
</dependency>
<dependency>
	<groupId>commons-codec</groupId>
	<artifactId>commons-codec</artifactId>
	<version>1.9</version>
</dependency>
<dependency>
	<groupId>org.apache.httpcomponents</groupId>
	<artifactId>httpclient</artifactId>
	<version>4.5.2</version>
</dependency>
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
	<version>1.2.7</version>
</dependency>
<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency>
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-webmvc</artifactId>
	<version>4.3.9.RELEASE</version>
</dependency>

<dependency>
	<groupId>com.spring4</groupId>
	<artifactId>EasyWeChat</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<scope>provided</scope>
</dependency>
```
