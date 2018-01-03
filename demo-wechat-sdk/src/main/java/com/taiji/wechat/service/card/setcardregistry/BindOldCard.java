package com.taiji.wechat.service.card.setcardregistry;

/**
 * @Description: 绑定老会员链接
 * @Company: 卡联科技
 * @date 2017年10月10日 下午2:55:46
 */
public class BindOldCard {

	private String name;//链接名称
	
	private String url;//自定义url 请填写http:// 或者https://开头的链接

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
