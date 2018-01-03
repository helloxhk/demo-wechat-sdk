package com.taiji.wechat.service.accesstoken;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kalian.thirdchannel.commons.exception.EStockThirdException;
import com.kalian.thirdchannel.commons.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class AccessTokenManagerService extends BaseHttpClient{
	
	private static final Logger log = Logger.getLogger(AccessTokenManagerService.class);
	
	protected AccessTokenManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
		// TODO Auto-generated constructor stub
	}
	
	private static String token;
	private static String createTime = String.valueOf(new Date().getTime());
	private static Map<String,String> tokenMap = new HashMap<String,String>();
	static{
		tokenMap.put("token", token);
		tokenMap.put("createTime", createTime);
	}
	
	/**
	 * 获取有效access_token
	 * @param appid
	 * @param appsecret
	 * @return access_token
	 * @throws EStockThirdException 
	 */
	public static synchronized String getAccessTokenService(String appid,String appsecret) throws EStockThirdException{
		String access_token = tokenMap.get("token");
		log.debug("access_token=="+access_token);
		String createTime = tokenMap.get("createTime");
		log.debug("createTime=="+createTime);
		long currentTime = System.currentTimeMillis();
		log.debug("currentTime=="+currentTime);
		//有效期1.5h
		if(access_token==null || (currentTime-Long.valueOf(createTime))>90*60*1000){
			log.debug("access_token已失效");
			access_token = getToken(appid,appsecret);
		}else{
			log.debug("access_token在有效期内");
		}
		return access_token;
	}
	
	/**
	 * 获取access_token
	 * @param appid
	 * @param appsecret
	 * @return
	 * @throws EStockThirdException
	 */
	private static String getToken(String appid,String appsecret) throws EStockThirdException{
		String access_token = null;
		String getTokenUrl = ConstantService.getTokenUrl;
		String dataStr = new String(new StringBuffer("grant_type=client_credential").append("&appid=").append(appid).append("&secret=").append(appsecret));
		String res = null;
		res = new AccessTokenManagerService(getTokenUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr);
		Map<String, String> map = (Map)JSONObject.fromObject(res);
		access_token = map.get("access_token");//获取失败返回null
		tokenMap.put("token", access_token);
		tokenMap.put("createTime", String.valueOf(new Date().getTime()));
		return access_token;
	}

	@Override
	public Object sendData(Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}

