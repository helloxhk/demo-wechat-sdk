package com.taiji.wechat.service.qrcode;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.accesstoken.AccessTokenManagerService;

public class TestQrcodeManagerService {

	@Test
	public void testCreateQrcode() throws EStockThirdException{
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		/**
		 * 3 生成卡券二维码
		 */
		CreateQrcodeBean createQrcodeBean = new CreateQrcodeBean();
		createQrcodeBean.setAction_name("QR_CARD");
		createQrcodeBean.setExpire_seconds(18000L);
		
		ActionInfo action_info = new ActionInfo();
		Card cardInfo = new Card();
		String cardId = "plgEOwQRwCiwEadXG1kzT58X_IQo";
		cardInfo.setCard_id(cardId);
		cardInfo.setCode("9999"+new Date().getTime());
		cardInfo.setOpenid("olgEOwUH7xhkTT33pNghOav3tAAg");
		cardInfo.setIs_unique_code(true);
		cardInfo.setOuter_str("12b");
		action_info.setCard(cardInfo);

		createQrcodeBean.setAction_info(action_info);
		
		QrcodeManagerService qrCodeManagerService = new QrcodeManagerService(ConstantService.createCardUrl,3000, ConstantService.CHARSET);
		Map<String, Object> res3 = qrCodeManagerService.createQrCode(token,createQrcodeBean);
		System.out.println("生成卡券二维码="+res3);
		System.out.println(res3.get("show_qrcode_url"));
	}
}
