package com.taiji.wechat.service.card.createcard;

/**
 * @Description: 商品信息
 * @Company: 卡联科技
 * @date 2017年10月16日 下午2:39:17
 */
public class SKU {

	/**
	 * 卡券库存的数量，不支持填写0，上限为100000000(一亿)。
	 * 必填：是
	 */
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
