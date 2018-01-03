package com.taiji.wechat.service.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.accesstoken.AccessTokenManagerService;
import com.taiji.wechat.service.card.createcard.Abstract;
import com.taiji.wechat.service.card.createcard.AdvancedInfo;
import com.taiji.wechat.service.card.createcard.BaseInfo;
import com.taiji.wechat.service.card.createcard.BonusRule;
import com.taiji.wechat.service.card.createcard.Card;
import com.taiji.wechat.service.card.createcard.CustomCell;
import com.taiji.wechat.service.card.createcard.CustomField;
import com.taiji.wechat.service.card.createcard.DateInfo;
import com.taiji.wechat.service.card.createcard.MemberCard;
import com.taiji.wechat.service.card.createcard.SKU;
import com.taiji.wechat.service.card.createcard.TextImage;
import com.taiji.wechat.service.card.createcard.TimeLimit;
import com.taiji.wechat.service.card.createcard.UseCondition;
import com.taiji.wechat.service.card.membercardactivate.ActivateInfo;
import com.taiji.wechat.service.card.setcardregistry.BindOldCard;
import com.taiji.wechat.service.card.setcardregistry.OptionalForm;
import com.taiji.wechat.service.card.setcardregistry.RequiredForm;
import com.taiji.wechat.service.card.setcardregistry.ServiceStatement;
import com.taiji.wechat.service.card.setcardregistry.SetCardRegistryConstant;
import com.taiji.wechat.service.stores.StoresInfo;

public class TestCardManagerService {

	/**
	 * 创建会员卡
	 */
	@Test
	public void TestCreateCard() throws EStockThirdException{
		CardManagerService service = new CardManagerService(ConstantService.createCardUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		Card card = new Card();
		card.setCard_type("MEMBER_CARD");//GROUPON MEMBER_CARD
		MemberCard memberCard = new MemberCard();
		memberCard.setAuto_activate(false);
		memberCard.setWx_activate(true);
		memberCard.setBackground_pic_url("https://mmbiz.qlogo.cn/mmbiz/");
		memberCard.setSupply_bonus(false);
		memberCard.setSupply_balance(false);
		memberCard.setPrerogative("");
		memberCard.setDiscount(10L);
		
		BaseInfo base_info = new BaseInfo();
		base_info.setLogo_url("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZ/0");
		base_info.setBrand_name("海底捞");
		base_info.setCode_type("CODE_TYPE_BARCODE");
		base_info.setTitle("海底捞会员卡");
		base_info.setColor("Color010");
		base_info.setNotice("使用时向服务员出示此券");
		base_info.setService_phone("020-88888888");
		base_info.setDescription("不可与其他优惠同享");
		base_info.setGet_limit(1);
		base_info.setUse_custom_code(true);
		//base_info.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
		base_info.setBind_openid(false);
		base_info.setCan_give_friend(true);
		base_info.setCustom_url_name("立即使用");
		base_info.setCustom_url("http://www.qq.com");
		base_info.setCustom_url_sub_title("6个汉字tips");
		base_info.setPromotion_url_name("营销入口1");
		base_info.setPromotion_url("http://www.qq.com");
		base_info.setNeed_push_on_view(true);
		DateInfo date_info = new DateInfo();
		date_info.setType("DATE_TYPE_PERMANENT");
		
		SKU sku = new SKU();
		sku.setQuantity(100000000);
		List<Integer> location_id_list = new ArrayList<Integer>();
		location_id_list.add(123);
		location_id_list.add(12321);
		base_info.setDate_info(date_info);
		base_info.setSku(sku);
		base_info.setLocation_id_list(location_id_list);
		
		AdvancedInfo advanced_info = new AdvancedInfo();
		UseCondition use_condition = new UseCondition();
		use_condition.setAccept_category("鞋类");
		use_condition.setReject_category("阿迪达斯");
		use_condition.setCan_use_with_other_discount(true);
		Abstract abstractObj = new Abstract();
		abstractObj.set_abstract("微信餐厅推出多种新季菜品，期待您的光临");
		List<String> icon_url_list = new ArrayList<String>();
		icon_url_list.add("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		abstractObj.setIcon_url_list(icon_url_list);
		List<TextImage> text_image_list = new ArrayList<TextImage>();
		TextImage textImage1 = new TextImage();
		textImage1.setImage_url("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		textImage1.setText("此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾");
		TextImage textImage2 = new TextImage();
		textImage2.setImage_url("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		textImage2.setText("此菜品迎合大众口味，老少皆宜，营养均衡");
		text_image_list.add(textImage1);
		text_image_list.add(textImage2);
		
		List<TimeLimit> time_limit = new ArrayList<TimeLimit>();
		TimeLimit mondayTimeLimit = new TimeLimit();
		mondayTimeLimit.setType("MONDAY");
		mondayTimeLimit.setBegin_hour(0);
		mondayTimeLimit.setEnd_hour(10);
		mondayTimeLimit.setBegin_minute(10);
		mondayTimeLimit.setEnd_minute(59);
		TimeLimit holidayTimeLimit = new TimeLimit();
		holidayTimeLimit.setType("HOLIDAY");
		time_limit.add(mondayTimeLimit);
		time_limit.add(holidayTimeLimit);
		List<String> business_service = new ArrayList<String>();
		business_service.add("BIZ_SERVICE_FREE_WIFI");
		business_service.add("BIZ_SERVICE_WITH_PET");
		business_service.add("BIZ_SERVICE_FREE_PARK");
		business_service.add("BIZ_SERVICE_DELIVER");
		advanced_info.setUse_condition(use_condition);
		advanced_info.set_abstract(abstractObj);
		advanced_info.setText_image_list(text_image_list);
		advanced_info.setTime_limit(time_limit);
		advanced_info.setBusiness_service(business_service);
		
		CustomField custom_field1 = new CustomField();
		custom_field1.setName_type("FIELD_NAME_TYPE_LEVEL");
		custom_field1.setUrl("http://www.qq.com");
		
		CustomCell custom_cell1 = new CustomCell();
		custom_cell1.setName("个人信息");
		custom_cell1.setTips("激活后显示");
		custom_cell1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ConstantService.appid+"&redirect_uri=https://h5.ceshiopms.etaoko.com/card/personal&response_type=code&scope=snsapi_base#wechat_redirect");
		
		BonusRule bonus_rule = new BonusRule();
		bonus_rule.setCost_money_unit(100);
		bonus_rule.setIncrease_bonus(1);
		bonus_rule.setMax_increase_bonus(200);
		bonus_rule.setInit_increase_bonus(10);
		bonus_rule.setCost_bonus_unit(5);
		bonus_rule.setReduce_money(100);
		bonus_rule.setLeast_money_to_use_bonus(1000);
		bonus_rule.setMax_reduce_bonus(50);
		
		memberCard.setBase_info(base_info);
		memberCard.setAdvanced_info(advanced_info);
		memberCard.setCustom_field1(custom_field1);
		memberCard.setCustom_cell1(custom_cell1);
		memberCard.setBonus_rule(bonus_rule);
		card.setMember_card(memberCard);
		Map<String, Object> res = service.createCard(token,card);
		System.out.println(res);
	}
	
	/**
	 * 设置开卡字段
	 * @throws com.kalian.thirdchannel.commons.exception.EStockThirdException 
	 */
	@Test
	public void TestSetCardRegistry() throws EStockThirdException{
		
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		
		/**
		 * 1创建会员卡
		 */
		String cardId = "plgEOwa1CFXE_1R4wIZ3Ei9WgjGo";
		
		/**
		 * 2设置开卡字段
		 */
		CardManagerService service2 = new CardManagerService(ConstantService.setCardRegistryUrl,3000, ConstantService.CHARSET);
		/**
		 * 注册新会员-必填项
		 */
		RequiredForm requiredForm = new RequiredForm();
		List<String> commonFieldIdList = new ArrayList<String>();
		commonFieldIdList.add(SetCardRegistryConstant.USER_FORM_INFO_FLAG_NAME);//姓名
		commonFieldIdList.add(SetCardRegistryConstant.USER_FORM_INFO_FLAG_MOBILE);//手机号
		commonFieldIdList.add(SetCardRegistryConstant.USER_FORM_INFO_FLAG_SEX);//性别
		commonFieldIdList.add(SetCardRegistryConstant.USER_FORM_INFO_FLAG_BIRTHDAY);//生日
		requiredForm.setCommon_field_id_list(commonFieldIdList);
		/**
		 * 注册新会员-选填项
		 */
		OptionalForm optionalForm = new OptionalForm();
		/**
		 * 注册新会员-服务声明
		 */
		ServiceStatement serviceStatement = new ServiceStatement();
//		serviceStatement.setName("会员卡信息使用声明");
//		serviceStatement.setUrl("http://www.kaliankeji.com/");
		/**
		 * 老会员链接
		 */
		BindOldCard bindOldCard = new BindOldCard();
		bindOldCard.setName("老会员绑定");
		bindOldCard.setUrl("http://h5.testopms.etaoko.com/card/zhuce");
		Map<String, Object> res2 = service2.setCardRegistry(token, cardId, requiredForm, optionalForm, serviceStatement, bindOldCard);
		System.out.println(res2);
	}
	
	/**
	 * 导入code
	 * @throws EStockThirdException
	 */
	@Test
	public void TestDeposit() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.depositUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		List<String> list = new ArrayList<>();
		list.add("555555555555");
		list.add("666666666666");
		Map<String, Object> res = service1.deposit(token, "plgEOwWq-bBaHdhsAacC9LDvrwGo", list);
		System.out.println(res);
	}
	
	/**
	 * 核查code导入请概况
	 */
	@Test
	public void TestCheckCode() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.checkCodeUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		List<String> list = new ArrayList<String>();
		list.add("333333333333");
		list.add("444444444444");
		Map<String, Object> res = service1.checkCode(token, "plgEOwWq-bBaHdhsAacC9LDvrwGo", list);
		System.out.println(res);
	}
	
	/**
	 * 修改库存
	 */
	@Test
	public void TestModifyStock() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.modifyStockUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		Map<String, Object> res = service1.modifyStock(token, "plgEOwWq-bBaHdhsAacC9LDvrwGo", 2,0);
		System.out.println(res);
	}
	
	/**
	 * api_ticket
	 * html5网页添加卡
	 * @throws EStockThirdException 
	 */
	@Test
	public void TestGetApiTicket() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.getApiTicketUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		String api_ticket = service1.getApiTicket(token);
		System.out.println(api_ticket);
		//IpK_1T69hDhZkLQTlwsAX8ecf9mXnmmPBO0Ng-fkQVx15ua_4q01n6U4lEP2xIIT7oQLz2mzK2pBUFlylyCMEg
	}
	
	
	/**
	 * 激活会员卡
	 */
	@Test
	public void TestMemberCardActivate() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.memberCardActivateUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		ActivateInfo activateInfo = new ActivateInfo();
		activateInfo.setMembership_number("6222021817000790994");
		activateInfo.setCode("151030304638304616");//领取
		Map<String, Object> res1 = service1.memberCardActivate(token, activateInfo);
		System.out.println(res1);
	}
	
	@Test
	public void TestSetCardWhitelist() throws EStockThirdException{
		/**
		 * 设置卡券白名单
		 */
		CardManagerService service = new CardManagerService(ConstantService.setCardWhitelistUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		List<String> openid = new ArrayList<String>();
//		openid.add("oPA9EvwhCzrURoOHZC-XJRcBT54I");//王忠顺
//		openid.add("oPA9Ev6_BlwGBvoSjvVvCIx0Se2s");//涂世坤
//		openid.add("oPA9Ev49aPgJHRvsxMBVdud-HGrQ");//许海宽
		
//		openid.add("olgEOwWqZzLth3SxhtwnIpa2Leug");
//		openid.add("olgEOwUH7xhkTT33pNghOav3tAAg");
		List<String> username = new ArrayList<String>();
		//username.add("helloxhk");
		//username.add("tushikun_0813");
		Map<String, Object> res = service.setCardWhitelist(token,openid,username);
		System.out.println("设置卡券白名单"+res);
	}
	
	@Test
	public void TestQueryCardDetail() throws EStockThirdException{
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		
		/**
		 * 1创建会员卡
		 */
//		String cardId = "pPA9EvwY5ngRri-JTDb1GO49QHj8";
		String cardId = "plgEOwYCMBBai7fZEF0qoFC5A9FE";
		
		/**
		 * 查询会员卡详情
		 */
		CardManagerService service2 = new CardManagerService(ConstantService.setCardWhitelistUrl,3000, ConstantService.CHARSET);
		Map<String, Object> res2 = service2.queryCardDetail(token,cardId);
		System.out.println("卡券详情"+res2);
	}
	
	@Test
	public void TestDeleteCard() throws EStockThirdException{
		/**
		 * 删除会员卡
		 */
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		String cardId = "plgEOwSc8Va3JmuQr24AaPZg-i8k";
		CardManagerService service2 = new CardManagerService(ConstantService.setCardWhitelistUrl,3000, ConstantService.CHARSET);
		Map<String, Object> res2 = service2.deleteCard(token,cardId);
		System.out.println(res2);
	}
	
	@Test
	public void TestBatchgetUrl() throws EStockThirdException{
		/**
		 * 批量查询会员卡
		 */
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		List<String> status_list = new ArrayList<>();
		CardManagerService service2 = new CardManagerService(ConstantService.setCardWhitelistUrl,3000, ConstantService.CHARSET);
		Map<String, Object> res2 = service2.batchgetUrl(token,0,30,null);
		System.out.println(res2);
	}
	
	@Test
	public void TestGetVipUserInfo() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.getVipUserInfoUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		StoresInfo storesInfo = new StoresInfo();
		Map<String, Object> res1 = service1.getVipUserInfo(token, "pPA9EvwY5ngRri-JTDb1GO49QHj8", "150995361646785152");
		System.out.println(res1);
	}
	
	@Test
	public void TestDecryptCode() throws EStockThirdException{
		CardManagerService service1 = new CardManagerService(ConstantService.decryptCodeUrl,3000, ConstantService.CHARSET);
		String token = AccessTokenManagerService.getAccessTokenService(ConstantService.appid,ConstantService.appsecret);
		Map<String, Object> res1 = service1.decryptCode(token, "Vr%2BYsJ7D4XEVOSRkS%2FEaq6mvgEvQB0y%2BypiYVgXlaDthkKH%2FysZmiDfH5aeNwgVw");
		System.out.println(res1);
	}
	
	
}
