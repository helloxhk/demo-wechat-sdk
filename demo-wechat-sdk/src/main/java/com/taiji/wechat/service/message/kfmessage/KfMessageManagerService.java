package com.taiji.wechat.service.message.kfmessage;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.message.groupmessage.GroupMessageTypeConstant;

/**
 * 
 * @Description: 客服消息管理
 * @Company: 卡联科技
 * @author tushikun
 * @date 2017年7月5日 上午10:50:01
 */
public class KfMessageManagerService extends BaseHttpClient {
	
	protected KfMessageManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param access_token
	 * @param toUser
	 * @param msgType
	 * @param content
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> sendKfMessageService(String access_token,String toUser,String msgType,String content,String media_id) throws EStockThirdException{
		//服务地址
		String sendKfMessageUrl = ConstantService.sendKfMessageUrl.replace("ACCESS_TOKEN",access_token);
		
		//请求报文
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("touser", toUser);
		req.put("msgtype", msgType);
		
		if(msgType.equals(GroupMessageTypeConstant.MSGTYPE_TEXT)){
			Map<String,String> textMap = new HashMap<String,String>();
			textMap.put("content", content);
			req.put("text", textMap);
		}else if(msgType.equals(GroupMessageTypeConstant.MSGTYPE_IMAGE)){
			Map<String,String> imageMap = new HashMap<String,String>();
			imageMap.put("media_id", media_id);
			req.put(msgType, imageMap);
		}else if(msgType.equals(GroupMessageTypeConstant.MSGTYPE_MPNEWS)){
			Map<String,String> mpnewsMap = new HashMap<String,String>();
			mpnewsMap.put("media_id", media_id);
			req.put(msgType, mpnewsMap);
		}
		String res = new KfMessageManagerService(sendKfMessageUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 客服消息--文本
	 * @param access_token
	 * @param toUser
	 * @param msgType
	 * @param content
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> sendKfMessageTextService(String access_token,String toUser,String msgType,String content) throws EStockThirdException{
		return sendKfMessageService(access_token,toUser,msgType,content,null);
	}
	
	/**
	 * 客服消息--图片
	 * @param access_token
	 * @param toUser
	 * @param msgType
	 * @param media_id
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> sendKfMessageImageService(String access_token,String toUser,String msgType,String media_id) throws EStockThirdException{
		return sendKfMessageService(access_token,toUser,msgType,null,media_id);
	}
	
	/**
	 * 客服消息--图文
	 * @param access_token
	 * @param toUser
	 * @param msgType
	 * @param media_id
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> sendKfMessageMpnewsService(String access_token,String toUser,String msgType,String media_id) throws EStockThirdException{
		return sendKfMessageService(access_token,toUser,msgType,null,media_id);
	}

	@Override
	public Object sendData(Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
