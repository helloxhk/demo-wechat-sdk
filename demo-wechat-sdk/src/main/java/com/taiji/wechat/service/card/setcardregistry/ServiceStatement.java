package com.taiji.wechat.service.card.setcardregistry;
/**
 * 
 * @Description: 注册新会员-服务声明，用于放置商户会员卡守则
 * @Company: 卡联科技
 * @date 2017年10月10日 下午2:55:53
 */
public class ServiceStatement {

	private String name;//会员声明字段名称
	
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
