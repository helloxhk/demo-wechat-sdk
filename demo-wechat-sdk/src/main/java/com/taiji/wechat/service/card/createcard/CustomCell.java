package com.taiji.wechat.service.card.createcard;

public class CustomCell {
	
	/**
	 * 入口名称。
	 * 必填：是
	 */
	private String name;
	
	/**
	 * 入口右侧提示语，6个汉字内。
	 * 必填：是
	 */
	private String tips;
	
	/**
	 * 入口跳转链接。
	 * 必填：是
	 */
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
