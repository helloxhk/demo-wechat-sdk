package com.taiji.wechat.service.qrcode;

import java.util.Map;

import net.sf.json.JSONObject;

import com.kalian.thirdchannel.commons.exception.EStockThirdException;
import com.kalian.thirdchannel.commons.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class QrcodeManagerService extends BaseHttpClient {


	protected QrcodeManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 创建二维码接口
	 * @param access_token
	 * @param storesInfo
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> createQrCode(String access_token,CreateQrcodeBean createQrcodeBean) throws EStockThirdException{
		String createQrCodeUrl = ConstantService.createQrCodeUrl.replace("ACCESS_TOKEN",access_token);
		String res = new QrcodeManagerService(createQrCodeUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(createQrcodeBean).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}

	@Override
	public Object sendData(Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
