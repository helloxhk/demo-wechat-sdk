package com.taiji.wechat.service.wxuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class WxUserManagerService extends BaseHttpClient{
	
	private List allOpenIdlist;
	
	protected WxUserManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}

	@Override
	public Object sendData(Map paramMap) {
		return null;
	}
	
	/**
	 * 获取某个openid的用户信息
	 * @param access_token
	 * @param openId
	 * @param lang
	 * @return
	 * @throws EStockThirdException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getWxUserInfo(String access_token,String openId) throws EStockThirdException{
		String addMenuUrl = ConstantService.getWxUserInfoUrl;
		StringBuffer dataStr = new StringBuffer("access_token=").append(access_token).append("&openid=").append(openId).append("&lang=zh_CN");
		String res = new WxUserManagerService(addMenuUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr.toString());
		Map<String, Object> map = (Map<String, Object>)JSONObject.fromObject(res);
		return map;
	}
	
	/**
	 * 获取所有的openId
	 * @param access_token
	 * @param next_openid
	 * @return
	 * @throws EStockThirdException
	 */
	public List getOpenIdList(String access_token,String next_openid) throws EStockThirdException{
		allOpenIdlist = new ArrayList();
		getOpenIdProcess(access_token,next_openid);
		return allOpenIdlist;
	}
	
	public void getOpenIdProcess(String access_token,String next_openid) throws EStockThirdException{
		String getOpenIdListUrl = ConstantService.getOpenIdListUrl;
		StringBuffer dataStr = new StringBuffer("access_token=").append(access_token).append("&next_openid=").append(next_openid);
		String res = new WxUserManagerService(getOpenIdListUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr.toString());
		Map<String, Object> temp = (Map)JSONObject.fromObject(res);
		Map<String,Object> data = (Map<String, Object>) temp.get("data");
		next_openid = (String)temp.get("next_openid");
		if(StringUtils.isNotBlank(next_openid)){
			List list = new ArrayList();
			list = (List) data.get("openid");
			allOpenIdlist.addAll(list);
			getOpenIdProcess(access_token,next_openid);
		}
	}
	
	/**
	 * 单次获取openId列表 
	 * 一次拉取调用最多拉取10000个关注者的OpenID。
	 * @param access_token
	 * @param next_openid
	 * @throws EStockThirdException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static List<String> getOpenIds(String access_token,String next_openid) throws EStockThirdException{
		List<String> list = new ArrayList<String>();
		String getOpenIdListUrl = ConstantService.getOpenIdListUrl;
		StringBuffer dataStr = new StringBuffer("access_token=").append(access_token).append("&next_openid=").append(next_openid);
		String res = new WxUserManagerService(getOpenIdListUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr.toString());
		Map<String, Object> respMap = (Map<String, Object>)JSONObject.fromObject(res);
		Map<String,Object> data = (Map<String, Object>) respMap.get("data");
		next_openid = (String)respMap.get("next_openid");
		if(StringUtils.isNotBlank(next_openid)){
			list = (List<String>)data.get("openid");
		}
		return list;
	}
	
//	public static void main(String[] args) throws EStockThirdException {
////		Map map = getWxUserInfo(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"),"oPA9Ev6_BlwGBvoSjvVvCIx0Se2s","zh_CN");
////		System.out.println(map);
//		
//		List list = getOpenIdList(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"),"");
//		System.out.println(list);
//	}
}
