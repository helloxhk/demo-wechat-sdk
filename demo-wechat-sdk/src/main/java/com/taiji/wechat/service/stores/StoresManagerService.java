package com.taiji.wechat.service.stores;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.kalian.thirdchannel.commons.exception.EStockThirdException;
import com.kalian.thirdchannel.commons.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class StoresManagerService extends BaseHttpClient {

	protected StoresManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}

	@Override
	public Object sendData(Map paramMap) {
		return null;
	}

	/**
	 * 创建门店
	 * @param access_token
	 * @param baseInfo
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> addPoi(String access_token,StoresInfo storesInfo) throws EStockThirdException{
		String addPoiUrl = ConstantService.addPoiUrl.replace("ACCESS_TOKEN",access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		JSONObject baseInfoJb = JSONObject.fromObject(storesInfo);
		JSONObject businessJb = new JSONObject();
		businessJb.put("base_info", baseInfoJb);
		req.put("business", businessJb.toString());
		String res = new StoresManagerService(addPoiUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
}
