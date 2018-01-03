package com.taiji.wechat.service.card.createcard;

/**
 * 
 * @Description: 会员卡信息
 * @Company: 卡联科技
 * @date 2017年10月16日 下午1:30:40
 */
public class MemberCard {

	/**
	 * 商家自定义会员卡背景图，须先调用上传图片接口将背景图上传至CDN，否则报错，
	 * 卡面设计请遵循微信会员卡自定义背景设计规范  ,像素大小控制在1000像素*600像素以下
	 * 必填：否
	 */
	private String background_pic_url;
	
	/**
	 * 基本的卡券数据，所有卡券类型通用
	 * 必填：是
	 */
	private BaseInfo base_info;
	
	/**
	 * 创建优惠券特有的高级字段
	 * 必填：否
	 */
	private AdvancedInfo advanced_info;
	
	/**
	 * 显示积分，填写true或false，如填写true，积分相关字段均为必填。若设置为true则后续不可以被关闭
	 * 必填：是
	 */
	private boolean supply_bonus;
	
	/**
	 * 设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
	 * 必填：否
	 */
	private String bonus_url;
	
	/**
	 * 是否支持储值，填写true或false。如填写true，储值相关字段均为必填
	 * 若设置为true则后续不可以被关闭。该字段须开通储值功能后方可使用，
	 * 详情见：获取特殊权限
	 * 必填：是
	 */
	private boolean supply_balance;
	
	/**
	 * 设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
	 * 必填：否
	 */
	private String balance_url;
	
	/**
	 * 会员卡特权说明,限制1024汉字
	 * 必填：是
	 */
	private String prerogative;
	
	/**
	 * 设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见自动激活。
	 * 必填：否
	 */
	private boolean auto_activate;
	
	/**
	 * 激活会员卡的url
	 */
	/*private String activate_url;*/
	
	/**
	 * 激活会原卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
	 * 必填：否
	 */
	/*private String activate_app_brand_user_name;*/
	
	/**
	 * 激活会原卡url对应的小程序path
	 * 必填：否
	 */
	/*private String activate_app_brand_pass;*/
	
	/**
	 * 设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。
	 * 填入该字段后仍需调用接口设置开卡项方可生效，详情见一键开卡。 
	 * 必填：否
	 */
	private boolean wx_activate;
	
	/**
	 * 自定义会员信息类目，会员卡激活后显示,包含name_type(name)和url字段
	 * 必填：否
	 */
	private CustomField custom_field1;
	
	/**
	 * 自定义会员信息类目，会员卡激活后显示,包含name_type(name)和url字段
	 * 必填：否
	 */
	private CustomField custom_field2;
	
	/**
	 * 自定义会员信息类目，会员卡激活后显示,包含name_type(name)和url字段
	 * 必填：否
	 */
	private CustomField custom_field3;
	
	/**
	 * 积分清零规则。 
	 * 必填：否
	 * String(128)
	 */
	private String bonus_cleared;
	
	/**
	 * 自定义会员信息类目，会员卡激活后显示。
	 * 必填：否
	 */
	private CustomCell custom_cell1;
	
	/**
	 * 积分规则
	 * 必填：否
	 */
	private BonusRule bonus_rule;
	
	/**
	 * 储值说明。
	 * 必填：否
	 */
	private String balance_rules;
	
	/**
	 * 折扣，该会员卡享受的折扣优惠,填10就是九折。
	 * 必填：否
	 */
	private Long discount;

	public String getBackground_pic_url() {
		return background_pic_url;
	}

	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}

	public void setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}

	public boolean isSupply_bonus() {
		return supply_bonus;
	}

	public void setSupply_bonus(boolean supply_bonus) {
		this.supply_bonus = supply_bonus;
	}

	public boolean isSupply_balance() {
		return supply_balance;
	}

	public void setSupply_balance(boolean supply_balance) {
		this.supply_balance = supply_balance;
	}

	public String getPrerogative() {
		return prerogative;
	}

	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}

	public CustomField getCustom_field1() {
		return custom_field1;
	}

	public void setCustom_field1(CustomField custom_field1) {
		this.custom_field1 = custom_field1;
	}

	public CustomField getCustom_field2() {
		return custom_field2;
	}

	public void setCustom_field2(CustomField custom_field2) {
		this.custom_field2 = custom_field2;
	}

	public CustomField getCustom_field3() {
		return custom_field3;
	}

	public void setCustom_field3(CustomField custom_field3) {
		this.custom_field3 = custom_field3;
	}

	public String getBonus_cleared() {
		return bonus_cleared;
	}

	public void setBonus_cleared(String bonus_cleared) {
		this.bonus_cleared = bonus_cleared;
	}

	public CustomCell getCustom_cell1() {
		return custom_cell1;
	}

	public void setCustom_cell1(CustomCell custom_cell1) {
		this.custom_cell1 = custom_cell1;
	}

	public String getBalance_rules() {
		return balance_rules;
	}

	public void setBalance_rules(String balance_rules) {
		this.balance_rules = balance_rules;
	}

	public BonusRule getBonus_rule() {
		return bonus_rule;
	}

	public void setBonus_rule(BonusRule bonus_rule) {
		this.bonus_rule = bonus_rule;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public boolean isWx_activate() {
		return wx_activate;
	}

	public void setWx_activate(boolean wx_activate) {
		this.wx_activate = wx_activate;
	}

	public String getBonus_url() {
		return bonus_url;
	}

	public void setBonus_url(String bonus_url) {
		this.bonus_url = bonus_url;
	}

	public String getBalance_url() {
		return balance_url;
	}

	public void setBalance_url(String balance_url) {
		this.balance_url = balance_url;
	}

	public boolean isAuto_activate() {
		return auto_activate;
	}

	public void setAuto_activate(boolean auto_activate) {
		this.auto_activate = auto_activate;
	}
	
}
