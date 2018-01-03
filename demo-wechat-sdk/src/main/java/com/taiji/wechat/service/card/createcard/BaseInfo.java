package com.taiji.wechat.service.card.createcard;

import java.util.List;

public class BaseInfo {
	
	/**
	 * 卡券的商户logo，建议像素为300*300。
	 * 必填：是
	 */
	private String logo_url;
	
	/**
	 * 商户名字,字数上限为12个汉字。
	 * 必填：是
	 */
	private String brand_name;
	
	/**
	 * Code展示类型， 
	 * "CODE_TYPE_TEXT" 文本 
	 * "CODE_TYPE_BARCODE" 一维码 
	 * "CODE_TYPE_QRCODE" 二维码
	 * "CODE_TYPE_ONLY_QRCODE" 仅显示二维码 
	 * "CODE_TYPE_ONLY_BARCODE" 仅显示一维码
	 * "CODE_TYPE_NONE" 不显示任何码型
	 * 必填：是
	 */
	private String code_type;
	
	/**
	 * 卡券名，字数上限为9个汉字(建议涵盖卡券属性、服务及金额)。
	 * 必填：是
	 */
	private String title;
	
	/**
	 * 券颜色。按色彩规范标注填写Color010-Color100 
	 * 必填：是
	 */
	private String color;
	
	/**
	 * 卡券使用提醒，字数上限为16个汉字。
	 * 必填：是
	 */
	private String notice;
	
	/**
	 * 客服电话 
	 * 必填：否
	 */
	private String service_phone;
	
	/**
	 * 卡券使用说明，字数上限为1024个汉字。
	 * 必填：是
	 */
	private String description;
	
	/**
	 * 使用日期，有效期的信息。
	 * json
	 * 必填：是
	 */
	private DateInfo date_info;
	
	/**
	 * 支付功能结构体
	 * json
	 * 否
	 */
	private SwipeCard pay_info;
	
	/**
	 * 商品信息。
	 * json
	 * 必填：是
	 */
	private SKU sku;
	
	/**
	 * 每人可领券的数量限制，建议会员卡每人限领一张 
	 * 必填：否
	 */
	private Integer get_limit;
	
	/**
	 * 是否自定义Code码。填写true或false，默认为false
	 * 通常自有优惠码系统的开发者选择自定义Code码，详情见
	 * 是否自定义code 
	 * 必填：否
	 */
	private boolean use_custom_code;
	
	/**
	 * 导入code模式 GET_CUSTOM_CODE_MODE_DEPOSIT
	 * 需配合2个属性:
	 *1） use_custom_code true
	 *1） quantity: 0 //建卡库存为0
	 * 导入code后，调接口查询code数
	 * 调接口更新卡库存量为查询到的code数
	 */
	private String get_custom_code_mode;
	
	/**
	 * 是否指定用户领取，填写true或false。默认为false    
	 * 必填：否
	 */
	private boolean bind_openid;

	/**
	 * 卡券领取页面是否可分享，默认为true
	 * 必填：否
	 */
	private boolean can_share;
	
	/**
	 * 卡券是否可转赠,默认为true 
	 * 必填：否
	 */
	private boolean can_give_friend;
	
	/**
	 * 门店位置ID。调用POI门店管理接口获取门店位置ID。
	 * 必填：否
	 */
	private List<Integer> location_id_list;
	
	/**
	 * 会员卡是否支持全部门店，填写后商户门店更新时会自动同步至卡券
	 * 必填：否
	 */
	private boolean use_all_locations;
	
	/**
	 * 卡券中部居中的按钮，仅在卡券激活后且可用状态时显示 
	 * 必填：否
	 */
	private String center_title;
	
	/**
	 * 显示在入口下方的提示语，仅在卡券激活后且可用状态时显示
	 * 必填：否
	 */
	private String center_sub_title;
	
	/**
	 * 顶部居中的url，仅在卡券激活后且可用状态时显示 
	 * 必填：否
	 */
	private String center_url;
	
	/**
	 * 自定义跳转外链的入口名字。
	 * 必填：否
	 */
	private String custom_url_name;
	
	/**
	 * 自定义跳转的URL。
	 * 必填：否
	 */
	private String custom_url;
	
	/**
	 * 显示在入口右侧的提示语。
	 * 必填：否
	 */
	private String custom_url_sub_title;
	
	/**
	 * 营销场景的自定义入口名称。  
	 * 必填：否
	 */
	private String promotion_url_name;
	
	/**
	 * 入口跳转外链的地址链接。
	 * 必填：否
	 */
	private String promotion_url;
	
	/**
	 * 显示在营销入口右侧的提示语。
	 * 必填：否
	 */
	private String promotion_url_sub_title;
	
	/**
	 * 填写true为用户点击进入会员卡时推送事件，默认为false。详情见进入会员卡事件推送
	 * 必填：否
	 */
	private boolean need_push_on_view;

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isBind_openid() {
		return bind_openid;
	}

	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateInfo getDate_info() {
		return date_info;
	}

	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}

	public SKU getSku() {
		return sku;
	}

	public void setSku(SKU sku) {
		this.sku = sku;
	}

	public Integer getGet_limit() {
		return get_limit;
	}

	public void setGet_limit(Integer get_limit) {
		this.get_limit = get_limit;
	}

	public boolean isUse_custom_code() {
		return use_custom_code;
	}

	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public boolean isCan_give_friend() {
		return can_give_friend;
	}

	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}

	public List<Integer> getLocation_id_list() {
		return location_id_list;
	}

	public void setLocation_id_list(List<Integer> location_id_list) {
		this.location_id_list = location_id_list;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public boolean isNeed_push_on_view() {
		return need_push_on_view;
	}

	public void setNeed_push_on_view(boolean need_push_on_view) {
		this.need_push_on_view = need_push_on_view;
	}

	public SwipeCard getPay_info() {
		return pay_info;
	}

	public void setPay_info(SwipeCard pay_info) {
		this.pay_info = pay_info;
	}

	public boolean isCan_share() {
		return can_share;
	}

	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}

	public boolean isUse_all_locations() {
		return use_all_locations;
	}

	public void setUse_all_locations(boolean use_all_locations) {
		this.use_all_locations = use_all_locations;
	}

	public String getCenter_title() {
		return center_title;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return center_url;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}

	public String getGet_custom_code_mode() {
		return get_custom_code_mode;
	}

	public void setGet_custom_code_mode(String get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}
	
}
