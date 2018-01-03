package com.taiji.wechat.service.menu;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class MenuManagerService extends BaseHttpClient<String> {

	protected MenuManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}
	
	@Override
	public String sendData(Map<String, String> paramMap) {
		return null;
	}

	/**
	 * 自定义菜单创建接口
	 * @param access_token
	 * @param MenuMap
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> addOrUpdateMenuConfig(String access_token,Map<String,Object> MenuMap) throws EStockThirdException{
		String addMenuUrl = ConstantService.addMenuUrl.replace("ACCESS_TOKEN",access_token);
		String res = new MenuManagerService(addMenuUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(MenuMap).toString());
		Map<String, Object> map = (Map)JSONObject.fromObject(res);
		return map;
	}
	
	/**
	 * 自定义菜单查询接口
	 * @param access_token
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> queryMenuConfig(String access_token) throws EStockThirdException{
		String getMenuUrl = ConstantService.getMenuUrl;
		Map<String,String> req = new HashMap<String,String>();
		String dataStr = new String(new StringBuffer("access_token=").append(access_token));
		String res = new MenuManagerService(getMenuUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr);
		Map<String, Object> map = (Map)JSONObject.fromObject(res);
		return map;
	}
	
//	public static void main(String[] args) throws EStockThirdException {
//		Map<String,Object> menuMap = new HashMap<String,Object>();//button:button
//		List buttonlist_level1 = new ArrayList();//button
//		
//		Map<String,Object> label1_level1_menu1 = new HashMap<String,Object>();
//		label1_level1_menu1.put("name", "商城");
//		label1_level1_menu1.put("type", "view");
//		label1_level1_menu1.put("key", "1");
//		label1_level1_menu1.put("url", "http://172.16.1.235:8067/test-css/test/init");
//		
//		Map<String,Object> label2_level1_menu1 = new HashMap<String,Object>();
//		label2_level1_menu1.put("name", "充值");
//		label2_level1_menu1.put("type", "view");
//		label2_level1_menu1.put("key", "2");
//		label2_level1_menu1.put("url", "http://172.16.1.235:8067/test-css/test/detail");
//		
//		Map<String,Object> label3_level1_menu1 = new HashMap<String,Object>();
//		label3_level1_menu1.put("name", "会员中心");
//		List label3_level2_menulist = new ArrayList();
//		JSONObject label3_level2_menu1 = new JSONObject();
//		label3_level2_menu1.put("name", "会员注册");
//		label3_level2_menu1.put("type", "view");
//		label3_level2_menu1.put("key", "3");
//		label3_level2_menu1.put("url", "http://172.16.1.235:8067/test-css/test/zhuce");
//		label3_level2_menulist.add(label3_level2_menu1);
//		label3_level1_menu1.put("sub_button", label3_level2_menulist);
//		
//		buttonlist_level1.add(label1_level1_menu1);
//		buttonlist_level1.add(label2_level1_menu1);
//		buttonlist_level1.add(label3_level1_menu1);
//		
//		menuMap.put("button", buttonlist_level1);
//		addOrUpdateMenuConfig(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"), menuMap);
//		
//		System.out.println(queryMenuConfig(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e")));
//	}
	
}
