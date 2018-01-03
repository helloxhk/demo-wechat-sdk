package com.taiji.wechat.service.card.createcard;

public class CustomField {

	/**
	 * 会员信息类目半自定义名称，当开发者变更这类类目信息的value值时
	 * 可以选择触发系统模板消息通知用户。
	 * FIELD_NAME_TYPE_LEVEL              等级
	 * FIELD_NAME_TYPE_COUPON        优惠券                
	 * FIELD_NAME_TYPE_STAMP            印花
	 * FIELD_NAME_TYPE_DISCOUNT      折扣
	 * FIELD_NAME_TYPE_ACHIEVEMEN  成就
	 * FIELD_NAME_TYPE_MILEAGE          里程
	 * FIELD_NAME_TYPE_SET_POINTS     集点
	 * FIELD_NAME_TYPE_TIMS                次数
	 * 
	 * 必填：否
	 */
	private String name_type;
	
	/**
	 * 会员信息类目自定义名称，当开发者变更这类类目信息的value值时不会触发系统模板消息通知用户.
	 * 必填：否
	 */
	private String name;
	
	/**
	 * 点击类目跳转外链url
	 * 必填：否
	 */
	private String url;

	public String getName_type() {
		return name_type;
	}

	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
