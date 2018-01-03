package com.taiji.wechat.service.openid;

import java.util.Map;

import net.sf.json.JSONObject;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class OpendIdManagerService extends BaseHttpClient<String> {

	protected OpendIdManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sendData(Map<String, String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Map<String,String> getOpenIdByCode(String appid,String appsecret,String code) throws EStockThirdException{
		String getOpenIdByCodeUrl = ConstantService.getOpenIdByCodeUrl;
		String dataStr = new String(new StringBuffer("&appid=").append(appid).append("&secret=").append(appsecret).append("&code=").append(code).append("&grant_type=authorization_code"));
		String res = new OpendIdManagerService(getOpenIdByCodeUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr);
		Map<String, String> map = (Map)JSONObject.fromObject(res);
		return map;
	}
	
}
