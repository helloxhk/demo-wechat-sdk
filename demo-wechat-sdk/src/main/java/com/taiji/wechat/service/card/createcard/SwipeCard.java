package com.taiji.wechat.service.card.createcard;

/**
 * 
 * @Description: 刷卡功能结构体
 * @Company: 卡联科技
 * @date 2017年10月16日 下午2:08:07
 */
public class SwipeCard {

	/**
	 * 是否设置该会员卡支持拉出微信支付刷卡界面
	 * 必填：否
	 */
	private boolean is_swipe_cardString;
	
	/**
	 * 是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码
	 * 必填：否
	 */
	private boolean is_pay_and_qrcode;

	public boolean getIs_swipe_cardString() {
		return is_swipe_cardString;
	}

	public void setIs_swipe_cardString(boolean is_swipe_cardString) {
		this.is_swipe_cardString = is_swipe_cardString;
	}

	public boolean getIs_pay_and_qrcode() {
		return is_pay_and_qrcode;
	}

	public void setIs_pay_and_qrcode(boolean is_pay_and_qrcode) {
		this.is_pay_and_qrcode = is_pay_and_qrcode;
	}
	
}
