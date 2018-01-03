package com.taiji.wechat.service.message.templateMessage;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.kalian.thirdchannel.commons.exception.EStockThirdException;
import com.kalian.thirdchannel.commons.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.accesstoken.AccessTokenManagerService;

public class TemplateMessageManagerService extends BaseHttpClient {

	protected TemplateMessageManagerService(String url, int timeout,
			String charset) {
		super(url, timeout, charset);
	}

	@Override
	public Object sendData(Map paramMap) {
		return null;
	}
	
	public static Map<String, Object> setIndustry(String access_token,String industry_id1,String industry_id2) throws EStockThirdException{
		String setIndustryUrl = ConstantService.setIndustryUrl.replace("ACCESS_TOKEN",access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("industry_id1", industry_id1);
		req.put("industry_id2", industry_id2);
		String res = new TemplateMessageManagerService(setIndustryUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	public static Map<String, Object> getIndustry(String access_token) throws EStockThirdException{
		String getIndustryUrl = ConstantService.getIndustryUrl;
		StringBuffer dataStr = new StringBuffer("access_token=").append(access_token);
		String res = new TemplateMessageManagerService(getIndustryUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr.toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 获得模板ID
	 * @param access_token
	 * @param template_id_short 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> getTemplateId(String access_token,String template_id_short) throws EStockThirdException{
		String getTemplateIdUrl = ConstantService.getTemplateIdUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,String> req = new HashMap<String,String>();
		req.put("template_id_short", template_id_short);
		String res = new TemplateMessageManagerService(getTemplateIdUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 获取模板列表
	 * @param access_token
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> getAllPrivateTemplate(String access_token) throws EStockThirdException{
		String getAllPrivateTemplateUrl = ConstantService.getAllPrivateTemplateUrl;
		StringBuffer dataStr = new StringBuffer("access_token=").append(access_token);
		String res = new TemplateMessageManagerService(getAllPrivateTemplateUrl, 3000, ConstantService.CHARSET).sendHttpsByGet(dataStr.toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 发送模板消息
	 * @param access_token
	 * @param touser 接收者openid
	 * @param template_id 模板ID
	 * @param url 模板跳转链接
	 * @param data 模板数据
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> sendTemplateMessage(String access_token,String touser,String template_id,String url,Map data) throws EStockThirdException{
		String sendTemplateMessageUrl = ConstantService.sendTemplateMessageUrl.replace("ACCESS_TOKEN",access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("touser", touser);
		req.put("template_id", template_id);
		req.put("url", url);//
		req.put("data", data);
		String res = new TemplateMessageManagerService(sendTemplateMessageUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	public static void main(String[] args) throws EStockThirdException {
//		Map map = setIndustry(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"), "1","2");
//		System.out.println(map);
		
		
//		Map map1 = getIndustry(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"));
//		System.out.println(map1);
		
//		Map map = getAllPrivateTemplate(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"));
//		System.out.println(map);
		
		Map data = new HashMap();
		
		Map first = new HashMap();
		first.put("value", "恭喜你购买成功！");
		first.put("color", "#173177");
		
		Map keyword1 = new HashMap();
		keyword1.put("value", "巧克力");
		keyword1.put("color", "#173177");
		
		Map keyword2 = new HashMap();
		keyword2.put("value", "39.8元");
		keyword2.put("color", "#173177");
		
		Map keyword3 = new HashMap();
		keyword3.put("value", "2014年9月22日");
		keyword3.put("color", "#173177");
		
		Map remark = new HashMap();
		remark.put("value", "欢迎再次购买！");
		remark.put("color", "#173177");
		
		data.put("first", first);
		data.put("keyword1", keyword1);
		data.put("keyword2", keyword2);
		data.put("keyword3", keyword3);
		data.put("remark", remark);
		
		Map map = sendTemplateMessage(AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e"),"oPA9Ev6_BlwGBvoSjvVvCIx0Se2s","hs-qBUma42Io5_qUZ7UkTCA_g0DOx87hIahd31FnFko","http://www.baidu.com",data);
		System.out.println(map);
	}

}
