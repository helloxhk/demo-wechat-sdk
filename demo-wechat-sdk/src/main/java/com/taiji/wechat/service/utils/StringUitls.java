package com.taiji.wechat.service.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StringUitls {

	public static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 获取参数的字典排序
	 * 
	 * @param maps 参数key-value map集合
	 * @return String 排序后的字符串
	 */
	public static String getOrderByLexicographic(Map<String, Object> maps) {
		return splitParams(lexicographicOrder(getParamsName(maps)), maps);
	}
	
    /**
	 * 获取参数名称 key
	 * 
	 * @param maps 参数key-value map集合
	 * @return
	 */
	public static List<String> getParamsName(Map<String, Object> maps) {
		List<String> paramNames = new ArrayList<String>();
		for (Map.Entry<String, Object> entry : maps.entrySet()) {
			paramNames.add(entry.getKey());
		}
		return paramNames;
	}
	
	/**
	 * 参数名称按字典排序
	 * 
	 * @param paramNames 参数名称List集合
	 * @return 排序后的参数名称List集合
	 */
	public static List<String> lexicographicOrder(List<String> paramNames) {
		Collections.sort(paramNames);
		return paramNames;
	}
	
	/**
	 * 拼接排序好的参数名称和参数值
	 * 
	 * @param paramNames 排序后的参数名称集合
	 * @param maps 参数key-value map集合
	 * @return String 拼接后的字符串
	 */
	public static String splitParams(List<String> paramNames, Map<String, Object> maps) {
		StringBuilder paramStr = new StringBuilder();
		for (String paramName : paramNames) {
			paramStr.append(paramName);
			for (Map.Entry<String, Object> entry : maps.entrySet()) {
				if (paramName.equals(entry.getKey())) {
					paramStr.append("=" + String.valueOf(entry.getValue())
							+ "&");
				}
			}
		}
		paramStr.deleteCharAt(paramStr.length() - 1);
		return paramStr.toString();
	}

	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}
