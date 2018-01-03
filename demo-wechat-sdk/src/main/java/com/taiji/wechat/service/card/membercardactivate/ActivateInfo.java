package com.taiji.wechat.service.card.membercardactivate;

/**
 * @Description: 激活会员卡的数据
 * @Company: 卡联科技
 * @date 2017年10月11日 上午9:20:19
 */
public class ActivateInfo {
	
	private String membership_number;//not null 会员卡编号，由开发者填入，作为序列号显示在用户的卡包里。可与Code码保持等值。
	private String code;//not null 领取会员卡用户获得的code（UserCardCode 会员卡序列号）
	private String card_id;//卡券ID,自定义code卡券必填
	private String background_pic_url;//商家自定义会员卡背景图，须先调用上传图片接口将背景图上传至CDN，否则报错，卡面设计请遵循微信会员卡自定义背景设计规范
	private String activate_begin_time;//激活后的有效起始时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式。
	private String activate_end_time;//激活后的有效截至时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式。
	private String init_bonus;//初始积分，不填为0
	private String init_bonus_record;//积分同步说明
	private String init_balance;//初始余额，不填为0
	private String init_custom_field_value1;//创建时字段custom_field1定义类型的初始值，限制为4个汉字，12字节
	private String init_custom_field_value2;//创建时字段custom_field2定义类型的初始值，限制为4个汉字，12字节
	private String init_custom_field_value3;//创建时字段custom_field3定义类型的初始值，限制为4个汉字，12字节
	
	public String getMembership_number() {
		return membership_number;
	}
	public void setMembership_number(String membership_number) {
		this.membership_number = membership_number;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}
	public String getActivate_begin_time() {
		return activate_begin_time;
	}
	public void setActivate_begin_time(String activate_begin_time) {
		this.activate_begin_time = activate_begin_time;
	}
	public String getActivate_end_time() {
		return activate_end_time;
	}
	public void setActivate_end_time(String activate_end_time) {
		this.activate_end_time = activate_end_time;
	}
	public String getInit_bonus() {
		return init_bonus;
	}
	public void setInit_bonus(String init_bonus) {
		this.init_bonus = init_bonus;
	}
	public String getInit_bonus_record() {
		return init_bonus_record;
	}
	public void setInit_bonus_record(String init_bonus_record) {
		this.init_bonus_record = init_bonus_record;
	}
	public String getInit_balance() {
		return init_balance;
	}
	public void setInit_balance(String init_balance) {
		this.init_balance = init_balance;
	}
	public String getInit_custom_field_value1() {
		return init_custom_field_value1;
	}
	public void setInit_custom_field_value1(String init_custom_field_value1) {
		this.init_custom_field_value1 = init_custom_field_value1;
	}
	public String getInit_custom_field_value2() {
		return init_custom_field_value2;
	}
	public void setInit_custom_field_value2(String init_custom_field_value2) {
		this.init_custom_field_value2 = init_custom_field_value2;
	}
	public String getInit_custom_field_value3() {
		return init_custom_field_value3;
	}
	public void setInit_custom_field_value3(String init_custom_field_value3) {
		this.init_custom_field_value3 = init_custom_field_value3;
	}
	
}
