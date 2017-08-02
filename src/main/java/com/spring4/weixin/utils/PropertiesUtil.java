package com.spring4.weixin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties defaultProperty;

	static {
		init();
	}

	static void init() {
		// 初始化默认配置
		defaultProperty = new Properties();
		defaultProperty.setProperty("devMode", "true");
		defaultProperty.setProperty("token", "easywechat");
		// 读取自定义配置
		String Props = "weixin.properties";
		boolean loaded = loadProperties(defaultProperty, "." + File.separatorChar + Props)
				|| loadProperties(defaultProperty, PropertiesUtil.class.getResourceAsStream("/WEB-INF/" + Props))
				|| loadProperties(defaultProperty, PropertiesUtil.class.getClassLoader().getResourceAsStream(Props));
		if (!loaded) {
			System.out.println("fastweixin:没有加载到properties属性文件!");
		}
	}

	/**
	 * 加载属性文件
	 *
	 * @param props
	 *            属性文件实例
	 * @param path
	 *            属性文件路径
	 * @return 是否加载成功
	 */
	private static boolean loadProperties(Properties props, String path) {
		try {
			File file = new File(path);
			if (file.exists() && file.isFile()) {
				props.load(new FileInputStream(file));
				return true;
			}
		} catch (IOException ignore) {
			// 异常忽略
			ignore.printStackTrace();
		}
		return false;
	}

	/**
	 * 加载属性文件
	 *
	 * @param props
	 *            属性文件实例
	 * @param is
	 *            属性文件流
	 * @return 是否加载成功
	 */
	private static boolean loadProperties(Properties props, InputStream is) {
		try {
			if (is != null) {
				props.load(is);
				return true;
			}
		} catch (IOException ignore) {
			// 异常忽略
			ignore.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取token
	 *
	 * @return token
	 */
	public static String getToken() {
		return getProperty("token");
	}

	public static String getToken(String token) {
		return getProperty("token", token);
	}

	/**
	 * 获取开发者第三方用户唯一凭证
	 *
	 * @return 第三方用户唯一凭证
	 */
	public static String getAppId() {
		return getProperty("appid");
	}

	/**
	 * 获取开发者第三方用户唯一凭证
	 *
	 * @param appid
	 *            默认第三方用户唯一凭证
	 * @return 第三方用户唯一凭证
	 */
	public static String getAppId(String appid) {
		return getProperty("appid", appid);
	}

	/**
	 * 获取开发者第三方用户唯一凭证密钥
	 *
	 * @return 第三方用户唯一凭证密钥
	 */
	public static String getSecret() {
		return getProperty("appsecret");
	}

	/**
	 * 获取开发者第三方用户唯一凭证密钥
	 *
	 * @param secret
	 *            默认第三方用户唯一凭证密钥
	 * @return 第三方用户唯一凭证密钥
	 */
	public static String getSecret(String secret) {
		return getProperty("appsecret", secret);
	}

	/**
	 * 获取 是否为调试模式
	 *
	 * @return 是否为调试模式
	 */
	public static boolean isDebug() {
		return getBoolean("devMode");
	}

	public static boolean getBoolean(String name) {
		String value = getProperty(name);
		return Boolean.valueOf(value);
	}

	public static int getIntProperty(String name) {
		String value = getProperty(name);
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	public static int getIntProperty(String name, int fallbackValue) {
		String value = getProperty(name, String.valueOf(fallbackValue));
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	/**
	 * 获取属性值
	 *
	 * @param name
	 *            属性名称
	 * @return 属性值
	 */
	public static String getProperty(String name) {
		return getProperty(name, null);
	}

	/**
	 * 获取属性值
	 *
	 * @param name
	 *            属性名
	 * @param fallbackValue
	 *            默认返回值
	 * @return 属性值
	 */
	public static String getProperty(String name, String fallbackValue) {
		String value;
		try {
			// 从全局系统获取
			value = System.getProperty(name, null);
			if (null == value) {
				// 先从系统配置文件获取
				value = defaultProperty.getProperty(name, fallbackValue);
			}
		} catch (AccessControlException ace) {
			// Unsigned applet cannot access System properties
			value = fallbackValue;
		}
		return value;
	}
}
