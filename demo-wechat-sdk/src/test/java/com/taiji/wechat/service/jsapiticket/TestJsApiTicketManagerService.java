package com.taiji.wechat.service.jsapiticket;

import org.junit.Test;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.accesstoken.AccessTokenManagerService;

public class TestJsApiTicketManagerService {

	@Test
	public void TestGetJsApiTicket() throws EStockThirdException{
		JsApiTicketManagerService service = new JsApiTicketManagerService(ConstantService.getJsApiTicketUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		String jsApiTicket = service.getJsApiTicket(token);
		System.out.println(jsApiTicket);
		//kgt8ON7yVITDhtdwci0qeV_1QxA_Sk0XnphTHE3m3XegZZEfMYdIciJAbjjPfAaeET59lYi6c-ytAg05DQtgVQ
	}
	
	
}
