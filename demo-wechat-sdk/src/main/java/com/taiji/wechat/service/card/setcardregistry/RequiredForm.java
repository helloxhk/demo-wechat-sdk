package com.taiji.wechat.service.card.setcardregistry;

import java.util.List;
/**
 * @Description: 注册新会员-必填项
 * @Company: 卡联科技
 * @date 2017年10月10日 下午3:21:29
 */
public class RequiredForm {

	private boolean can_modify;//当前结构（required_form或者optional_form ）内的字段是否允许用户激活后再次修改，商户设置为true时，需要接收相应事件通知处理修改事件
	
	/**
	 * USER_FORM_INFO_FLAG_MOBILE				手机号
	 * USER_FORM_INFO_FLAG_SEX					性别
	 * USER_FORM_INFO_FLAG_NAME					姓名
	 * USER_FORM_INFO_FLAG_BIRTHDAY				生日
	 * USER_FORM_INFO_FLAG_IDCARD				身份证
	 * USER_FORM_INFO_FLAG_EMAIL				邮箱
	 * USER_FORM_INFO_FLAG_LOCATION				详细地址
	 * USER_FORM_INFO_FLAG_EDUCATION_BACKGRO	教育背景
	 * USER_FORM_INFO_FLAG_INDUSTRY				行业
	 * USER_FORM_INFO_FLAG_INCOME				收入
	 * USER_FORM_INFO_FLAG_HABIT				兴趣爱好
	 */
	private List<String> common_field_id_list;//微信格式化的选项类型
	
	private List<String> custom_field_list;//自定义选项名称，开发者可以分别在必填和选填中至多定义五个自定义选项
	
	private List<RichField> rich_field_list;//自定义富文本类型，包含以下三个字段，开发者可以分别在必填和选填中至多定义五个自定义选项

	public boolean isCan_modify() {
		return can_modify;
	}

	public void setCan_modify(boolean can_modify) {
		this.can_modify = can_modify;
	}

	public List<String> getCommon_field_id_list() {
		return common_field_id_list;
	}

	public void setCommon_field_id_list(List<String> common_field_id_list) {
		this.common_field_id_list = common_field_id_list;
	}

	public List<String> getCustom_field_list() {
		return custom_field_list;
	}

	public void setCustom_field_list(List<String> custom_field_list) {
		this.custom_field_list = custom_field_list;
	}

	public List<RichField> getRich_field_list() {
		return rich_field_list;
	}

	public void setRich_field_list(List<RichField> rich_field_list) {
		this.rich_field_list = rich_field_list;
	}

}
