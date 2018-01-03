package com.taiji.wechat.service.card.createcard;

import java.util.List;

public class AdvancedInfo {
	
	/**
	 * 使用门槛（条件）字段，若不填写使用条件则在券面拼写
	 * 	：无最低消费限制，全场通用，不限品类；并在使用说明显示：
	 * 	可与其他优惠共享
	 * 必填：否
	 */
	private UseCondition use_condition;
	
	/**
	 * 封面摘要结构体名称
	 * json
	 * 必填：否
	 */
	private Abstract _abstract;
	
	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表
	 * json
	 * 必填：否
	 */
	private List<TextImage> text_image_list;
	
	/**
	 * 使用时段限制
	 * 必填：否
	 */
	private List<TimeLimit> time_limit;
	
	/**
	 * 商家服务类型：
	 * BIZ_SERVICE_DELIVER 外卖服务；
	 * BIZ_SERVICE_FREE_PARK 停车位；
	 * BIZ_SERVICE_WITH_PET 可带宠物；
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，
	 * 可多选
	 * 必填：否
	 */
	private List<String> business_service;

	public UseCondition getUse_condition() {
		return use_condition;
	}

	public void setUse_condition(UseCondition use_condition) {
		this.use_condition = use_condition;
	}

	public Abstract get_abstract() {
		return _abstract;
	}

	public void set_abstract(Abstract _abstract) {
		this._abstract = _abstract;
	}

	public List<TextImage> getText_image_list() {
		return text_image_list;
	}

	public void setText_image_list(List<TextImage> text_image_list) {
		this.text_image_list = text_image_list;
	}

	public List<TimeLimit> getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(List<TimeLimit> time_limit) {
		this.time_limit = time_limit;
	}

	public List<String> getBusiness_service() {
		return business_service;
	}

	public void setBusiness_service(List<String> business_service) {
		this.business_service = business_service;
	}

}
