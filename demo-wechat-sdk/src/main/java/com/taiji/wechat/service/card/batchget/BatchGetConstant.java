package com.taiji.wechat.service.card.batchget;
/**
 * 支持开发者拉出指定状态的卡券列表
 * @Description: 
 * @Company: 卡联科技
 * @date 2017年12月11日 上午11:54:45
 */
public class BatchGetConstant {

	private static final String CARD_STATUS_NOT_VERIFY = "CARD_STATUS_NOT_VERIFY"; //待审核
	private static final String CARD_STATUS_VERIFY_FAIL = "CARD_STATUS_VERIFY_FAIL";//审核失败
	private static final String CARD_STATUS_VERIFY_OK = "CARD_STATUS_VERIFY_OK";//通过审核
	private static final String CARD_STATUS_DELETE = "CARD_STATUS_DELETE";//卡券被商户删除
	private static final String CARD_STATUS_DISPATCH = "CARD_STATUS_DISPATCH";//在公众平台投放过的卡券
}
