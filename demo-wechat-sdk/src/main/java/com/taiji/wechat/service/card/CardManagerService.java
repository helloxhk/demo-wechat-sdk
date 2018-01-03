package com.taiji.wechat.service.card;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.card.createcard.Card;
import com.taiji.wechat.service.card.membercardactivate.ActivateInfo;
import com.taiji.wechat.service.card.setcardregistry.BindOldCard;
import com.taiji.wechat.service.card.setcardregistry.OptionalForm;
import com.taiji.wechat.service.card.setcardregistry.RequiredForm;
import com.taiji.wechat.service.card.setcardregistry.ServiceStatement;
import com.taiji.wechat.service.utils.StringUitls;

public class CardManagerService extends BaseHttpClient {

	public CardManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}

	@Override
	public Object sendData(Map paramMap) {
		return null;
	}

	/**
	 * 创建会员卡 优先级：auto_activate 自动激活 > activate_url 接口激活 > wx_activate 一键激活
	 * 1.填入了自动激活auto_activate字段，激活链接activate_url和一键开卡接口设置都会失效；
	 * 2.若同时传入了activate_url，则一键开卡接口设置会失效；
	 * 3.建议开发者activate_url、auto_activate和wx_activate只填写一项。
	 * 
	 * @param access_token
	 * @param baseInfo
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> createCard(String access_token, Card card)
			throws EStockThirdException {
		String createCardUrl = ConstantService.createCardUrl.replace(
				"ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card", card);
		String reqStr = JSONObject.fromObject(req).toString();
		reqStr = reqStr.replace("_abstract", "abstract");
		//普通一键激活
		//String reqStr = "{\"card\":{\"card_type\":\"MEMBER_CARD\",\"member_card\":{\"wx_activate\":true,\"background_pic_url\":\"https://mmbiz.qlogo.cn/mmbiz/\",\"base_info\":{\"logo_url\":\"http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZ/0\",\"brand_name\":\"海底捞\",\"code_type\":\"CODE_TYPE_TEXT\",\"title\":\"海底捞会员卡\",\"color\":\"Color010\",\"notice\":\"使用时向服务员出示此券\",\"service_phone\":\"020-88888888\",\"description\":\"不可与其他优惠同享\",\"date_info\":{\"type\":\"DATE_TYPE_PERMANENT\"},\"sku\":{\"quantity\":50000000},\"get_limit\":1000,\"use_custom_code\":true,\"bind_openid\":false,\"can_give_friend\":true,\"location_id_list\":[123,12321],\"custom_url_name\":\"立即使用\",\"custom_url\":\"http://weixin.qq.com\",\"custom_url_sub_title\":\"6个汉字tips\",\"promotion_url_name\":\"营销入口1\",\"promotion_url\":\"http://www.qq.com\",\"need_push_on_view\":true},\"advanced_info\":{\"use_condition\":{\"accept_category\":\"鞋类\",\"reject_category\":\"阿迪达斯\",\"can_use_with_other_discount\":true},\"abstract\":{\"abstract\":\"微信餐厅推出多种新季菜品，期待您的光临\",\"icon_url_list\":[\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj  piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\"]},\"text_image_list\":[{\"image_url\":\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\"text\":\"此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾\"},{\"image_url\":\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\"text\":\"此菜品迎合大众口味，老少皆宜，营养均衡\"}],\"time_limit\":[{\"type\":\"MONDAY\",\"begin_hour\":0,\"end_hour\":10,\"begin_minute\":10,\"end_minute\":59},{\"type\":\"HOLIDAY\"}],\"business_service\":[\"BIZ_SERVICE_FREE_WIFI\",\"BIZ_SERVICE_WITH_PET\",\"BIZ_SERVICE_FREE_PARK\",\"BIZ_SERVICE_DELIVER\"]},\"supply_bonus\":true,\"supply_balance\":false,\"prerogative\":\"test_prerogative\",\"custom_field1\":{\"name_type\":\"FIELD_NAME_TYPE_LEVEL\",\"url\":\"http://www.qq.com\"},\"custom_cell1\":{\"name\":\"使用入口2\",\"tips\":\"激活后显示\",\"url\":\"http://www.xxx.com\"},\"bonus_rule\":{\"cost_money_unit\":100,\"increase_bonus\":1,\"max_increase_bonus\":200,\"init_increase_bonus\":10,\"cost_bonus_unit\":5,\"reduce_money\":100,\"least_money_to_use_bonus\":1000,\"max_reduce_bonus\":50},\"discount\":10}}}";
		
		//跳转式一键激活
		//String reqStr = "{\"card\":{\"card_type\":\"MEMBER_CARD\",\"member_card\":{\"wx_activate\":true,\"wx_activate_after_submit\" : true,\"wx_activate_after_submit_url\" : \"http://kfweixin.etaoko.com/wechatpublic-adminweb/serverpage/wechatpublic/activatecard.jsp\",\"background_pic_url\":\"https://mmbiz.qlogo.cn/mmbiz/\",\"base_info\":{\"logo_url\":\"http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZ/0\",\"brand_name\":\"海底捞\",\"code_type\":\"CODE_TYPE_TEXT\",\"title\":\"海底捞会员卡\",\"color\":\"Color010\",\"notice\":\"使用时向服务员出示此券\",\"service_phone\":\"020-88888888\",\"description\":\"不可与其他优惠同享\",\"date_info\":{\"type\":\"DATE_TYPE_PERMANENT\"},\"sku\":{\"quantity\":50000000},\"get_limit\":1000,\"use_custom_code\":true,\"bind_openid\":false,\"can_give_friend\":true,\"location_id_list\":[123,12321],\"custom_url_name\":\"立即使用\",\"custom_url\":\"http://weixin.qq.com\",\"custom_url_sub_title\":\"6个汉字tips\",\"promotion_url_name\":\"营销入口1\",\"promotion_url\":\"http://www.qq.com\",\"need_push_on_view\":true},\"advanced_info\":{\"use_condition\":{\"accept_category\":\"鞋类\",\"reject_category\":\"阿迪达斯\",\"can_use_with_other_discount\":true},\"abstract\":{\"abstract\":\"微信餐厅推出多种新季菜品，期待您的光临\",\"icon_url_list\":[\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj  piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\"]},\"text_image_list\":[{\"image_url\":\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\"text\":\"此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾\"},{\"image_url\":\"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\"text\":\"此菜品迎合大众口味，老少皆宜，营养均衡\"}],\"time_limit\":[{\"type\":\"MONDAY\",\"begin_hour\":0,\"end_hour\":10,\"begin_minute\":10,\"end_minute\":59},{\"type\":\"HOLIDAY\"}],\"business_service\":[\"BIZ_SERVICE_FREE_WIFI\",\"BIZ_SERVICE_WITH_PET\",\"BIZ_SERVICE_FREE_PARK\",\"BIZ_SERVICE_DELIVER\"]},\"supply_bonus\":true,\"supply_balance\":false,\"prerogative\":\"test_prerogative\",\"custom_field1\":{\"name_type\":\"FIELD_NAME_TYPE_LEVEL\",\"url\":\"http://www.qq.com\"},\"custom_cell1\":{\"name\":\"使用入口2\",\"tips\":\"激活后显示\",\"url\":\"http://www.xxx.com\"},\"bonus_rule\":{\"cost_money_unit\":100,\"increase_bonus\":1,\"max_increase_bonus\":200,\"init_increase_bonus\":10,\"cost_bonus_unit\":5,\"reduce_money\":100,\"least_money_to_use_bonus\":1000,\"max_reduce_bonus\":50},\"discount\":10}}}";
		
		String res = new CardManagerService(createCardUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(reqStr);
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 导入code
	 * @param access_token
	 * @param cardId
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> deposit(String access_token, String cardId,List<String> code) throws EStockThirdException {
		String depositUrl = ConstantService.depositUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		req.put("code", code);
		String reqStr = JSONObject.fromObject(req).toString();
		String res = new CardManagerService(depositUrl, 3000,ConstantService.CHARSET).sendByPostWrite(reqStr);
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 核查code导入请概况
	 */
	public static Map<String, Object> checkCode(String access_token, String cardId,List<String> code) throws EStockThirdException {
		String checkCodeUrl = ConstantService.checkCodeUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		req.put("code", code);
		String reqStr = JSONObject.fromObject(req).toString();
		String res = new CardManagerService(checkCodeUrl, 3000,ConstantService.CHARSET).sendHttpsByPostWriter(reqStr);
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}

	/**
	 * 修改库存
	 * @param access_token
	 * @param cardId
	 * @param increaseStockValue
	 * @param reduceStockValue
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> modifyStock(String access_token, String cardId,Integer increaseStockValue,Integer reduceStockValue) throws EStockThirdException {
		String modifyStockUrl = ConstantService.modifyStockUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		req.put("increase_stock_value", increaseStockValue);
		req.put("reduce_stock_value", reduceStockValue);
		String reqStr = JSONObject.fromObject(req).toString();
		String res = new CardManagerService(modifyStockUrl, 3000,ConstantService.CHARSET).sendHttpsByPostWriter(reqStr);
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 设置开卡字段接口 POST
	 * 
	 * @param access_token
	 * @param cardId
	 *            卡券ID
	 * @param serviceStatement
	 *            服务声明，用于放置商户会员卡守则
	 * @param bindOldCard
	 *            绑定老会员链接
	 * @param requiredForm
	 *            会员卡激活时的必填选项。
	 * @param optionalForm
	 *            会员卡激活时的选填项。
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> setCardRegistry(String access_token,
			String cardId, RequiredForm requiredForm,
			OptionalForm optionalForm, ServiceStatement serviceStatement,
			BindOldCard bindOldCard) throws EStockThirdException {
		String setCardRegistryUrl = ConstantService.setCardRegistryUrl.replace(
				"ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		req.put("service_statement", serviceStatement);
		req.put("bind_old_card", bindOldCard);
		req.put("required_form", requiredForm);
		req.put("optional_form", optionalForm);
		String res = new CardManagerService(setCardRegistryUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject
				.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}

	/**
	 * 接口激活
	 * 
	 * @param access_token
	 * @param activateInfo
	 *            激活会员卡信息
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> memberCardActivate(String access_token,
			ActivateInfo activateInfo) throws EStockThirdException {
		String memberCardActivateUrl = ConstantService.memberCardActivateUrl
				.replace("ACCESS_TOKEN", access_token);
		String res = new CardManagerService(memberCardActivateUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject
				.fromObject(activateInfo).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}

	/**
	 * 根据CardID和Code查询会员信息
	 * 
	 * @param access_token
	 * @param cardId
	 * @param code
	 *            卡券Code码 UserCardCode
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> getVipUserInfo(String access_token,
			String cardId, String code) throws EStockThirdException {
		String getVipUserInfoUrl = ConstantService.getVipUserInfoUrl.replace(
				"ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		req.put("code", code);
		String res = new CardManagerService(getVipUserInfoUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject
				.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}

	/**
	 * 卡券 api_ticket
	 * 
	 * @param access_token
	 * @return
	 * @throws EStockThirdException
	 */
	public static String getApiTicket(String access_token)
			throws EStockThirdException {
		String api_ticket = null;
		String getApiTicketUrl = ConstantService.getApiTicketUrl;
		String dataStr = new String(new StringBuffer("access_token=").append(
				access_token).append("&type=wx_card"));
		String res = new CardManagerService(getApiTicketUrl, 3000,
				ConstantService.CHARSET).sendHttpsByGet(dataStr);
		Map<String, Object> resmap = (Map) JSONObject.fromObject(res);
		api_ticket = resmap.get("ticket").toString();// 获取失败返回null
		return api_ticket;
	}

	/**
	 * 通过api_ticket获取签名 
	 * 1.将 api_ticket、timestamp、card_id、code、opendId(指定用户领取)、nonce_str的   value值进行字符串的字典序排序。
	 * 2.将所有参数字符串拼接成一个字符串进行sha1加密，得到signature。
	 * 3.signature中的timestamp，nonce字段和card_ext中的timestamp，nonce_str字段必须保持一致。
	 * 4.code=1434008071，timestamp=1404896688，card_id=pjZ8Yt1XGILfi-FUsewpnnolGgZk，
	 * api_ticket=ojZ8YtyVyr30HheH3CM73y7h4jJE ，nonce_str=123
	 * 则signature=sha1(12314048966881434008071ojZ8YtyVyr30HheH3CM73y7h4jJEpjZ8Yt1XGILfi-FUsewpnnolGgZk)
	 * =f137ab68b7f8112d20ee528ab6074564e2796250。
	 * @param access_token
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, String> getApiTicketSign(String apiTicket, String cardId, String code) throws EStockThirdException {
		Map<String, String> signMap = new HashMap<String, String>();
		String signature = null;
		String nonce_str = StringUitls.create_nonce_str();
		String timestamp = StringUitls.create_timestamp();

		Map<String, String> map = new HashMap<String, String>();
		map.put("api_ticket", apiTicket);
		map.put("card_id", cardId);
		map.put("code", code);
		map.put("noncestr", nonce_str);
		map.put("timestamp", timestamp);
		
		String[] str = {"code", "timestamp", "card_id", "api_ticket", "noncestr"};
		String[] valStr = new String[str.length];
		//String[] valStr = (String[])map.values().toArray();
		for(int i = 0; i< str.length; i++){
			valStr[i] = map.get(str[i]);
		}
		String url = "";
		Arrays.sort(valStr);
		System.out.println("========================="+Arrays.toString(valStr));
		for (int j = 0; j < valStr.length; j++) {
			url += valStr[j];
		}
		signature = StringUitls.SHA1(url);
		signMap.put("nonce_str", nonce_str);
		signMap.put("timestamp", timestamp);
		signMap.put("signature", signature);
		signMap.put("card_id", cardId);
		signMap.put("code", code);
		signMap.put("api_ticket", apiTicket);
		return signMap;
	}

	/**
	 * 设置领卡白名单
	 * @param access_token
	 * @param openid
	 * @param username
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> setCardWhitelist(String access_token,
			List<String> openid, List<String> username)
			throws EStockThirdException {
		String setCardWhitelistUrl = ConstantService.setCardWhitelistUrl
				.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("openid", openid);
		req.put("username", username);
		String res = new CardManagerService(setCardWhitelistUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject
				.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 删除会员卡
	 * @param access_token
	 * @param cardId
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> deleteCard(String access_token, String cardId) throws EStockThirdException {
		String deleteCardUrl = ConstantService.deleteCardUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		String res = new CardManagerService(deleteCardUrl, 3000,ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}

	/**
	 * 批量查询卡劵列表
	 * @param access_token
	 * @param offset
	 * @param count
	 * @param status_list 非必填
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, Object> batchgetUrl(String access_token,Integer offset,Integer count,List<String> status_list) throws EStockThirdException {
		String queryCardDetailUrl = ConstantService.queryCardDetailUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("offset", offset);
		req.put("count", count);
//		req.put("status_list", JSONArray.fromObject(status_list));
		String res = new CardManagerService(queryCardDetailUrl, 3000,ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	public static Map<String, Object> queryCardDetail(String access_token,
			String cardId) throws EStockThirdException {
		String queryCardDetailUrl = ConstantService.queryCardDetailUrl.replace(
				"ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("card_id", cardId);
		String res = new CardManagerService(queryCardDetailUrl, 3000,
				ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject
				.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	
	public static Map<String, Object> decryptCode(String access_token,String encryptCode) throws EStockThirdException {
		String decryptCodeUrl = ConstantService.decryptCodeUrl.replace("ACCESS_TOKEN", access_token);
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("encrypt_code", encryptCode);
		String res = new CardManagerService(decryptCodeUrl, 3000,ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map) JSONObject.fromObject(res);
		return respMap;
	}
	

}
