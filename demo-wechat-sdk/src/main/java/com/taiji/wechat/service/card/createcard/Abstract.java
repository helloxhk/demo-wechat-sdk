package com.taiji.wechat.service.card.createcard;

import java.util.List;

public class Abstract {

	/**
	 * 封面摘要简介。
	 * 必填：否
	 */
	private String _abstract;
	
	/**
	 * 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。
	 * 建议图片尺寸像素850*350
	 * 必填：否
	 */
	private List<String> icon_url_list;

	public String get_abstract() {
		return _abstract;
	}

	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}

	public List<String> getIcon_url_list() {
		return icon_url_list;
	}

	public void setIcon_url_list(List<String> icon_url_list) {
		this.icon_url_list = icon_url_list;
	}
	
}
