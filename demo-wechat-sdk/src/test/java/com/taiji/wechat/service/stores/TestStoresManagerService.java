package com.taiji.wechat.service.stores;

import java.util.Map;

import org.junit.Test;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.accesstoken.AccessTokenManagerService;
import com.taiji.wechat.service.stores.StoresInfo;
import com.taiji.wechat.service.stores.StoresManagerService;

public class TestStoresManagerService {

	@Test
	public void testAddPoi() throws EStockThirdException{
		StoresManagerService s = new StoresManagerService(ConstantService.addPoiUrl,3000, ConstantService.CHARSET);
		//订阅号测试测试
		//String token = AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e");
		
		//服务号生产
		//String token = AccessTokenManagerService.getAccessTokenService("wxc751f09fc7fd39f3","57bee3ec04edb056ca3f8ab88b536ce9");
		
		//服务号测试
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		StoresInfo storesInfo = new StoresInfo();
		Map<String, Object> res = s.addPoi(token,storesInfo);
		System.out.println(res);
	}
}
