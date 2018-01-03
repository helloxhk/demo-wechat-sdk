package com.taiji.wechat.service.card.createcard;

public class Card {

	/**
	 * 会员卡类型
	 * 必填：是
	 */
	private String card_type;
	
	/**
	 * 会员卡信息
	 * 必填：否
	 */
	private MemberCard member_card;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public MemberCard getMember_card() {
		return member_card;
	}

	public void setMember_card(MemberCard member_card) {
		this.member_card = member_card;
	}
	
	
}
