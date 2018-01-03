package com.taiji.wechat.constant;

public class ConstantService {

	public static final String CHARSET = "UTF-8";
	
	//开发测试
//	public static final String appid = "wxee4e2d5043904ca2";
//	public static final String appsecret = "df3081ec27dced5f99d51fde2410051e";
	
	//生产
	public static final String appid = "wxc751f09fc7fd39f3";
	public static final String appsecret = "57bee3ec04edb056ca3f8ab88b536ce9";
	public static final String token = "12345678";
	
	/**
	 * 获取令牌
	 */
	public static final String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
	
	/**************************************** 自定义菜单管理开始***************************************************************************************/
	/**
	 * 自定义菜单创建接口
	 */
	public static final String addMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/**
	 * 自定义菜单查询接口
	 */
	public static final String getMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/get";
	/**************************************** 自定义菜单管理结束***************************************************************************************/
	
	/**************************************** 客服消息管理结束***************************************************************************************/
	/**
	 * 客服接口-发消息
	 */
	public static final String sendKfMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	/**************************************** 客服消息管理结束***************************************************************************************/
	
	/**************************************** 模板消息管理开始***************************************************************************************/
	/**
	 * 设置所属行业
	 */
	public static final String setIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	/**
	 * 获取设置的行业信息
	 */
	public static final String getIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/get_industry";
	/**
	 * 获得模板ID
	 */
	public static final String getTemplateIdUrl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	/**
	 * 获取模板列表
	 */
	public static final String getAllPrivateTemplateUrl = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template";
	/**
	 * 发送模板消息
	 */
	public static final String sendTemplateMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	/**************************************** 模板消息管理结束***************************************************************************************/
	
	/**************************************** 群发消息管理开始***************************************************************************************/
	/**
	 * 群发 上传图文消息内的图片获取URL
	 */
	public static final String uploadImgUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	
	/**
	 * 群发 上传图文消息素材
	 */
	public static final String uploadNewsUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	
	/**
	 * 群发 上传video
	 */
	public static final String uploadVideoUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN POST";
	
	/**
	 * 群发 预览
	 */
	public static final String previewUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	
	/**
	 * 群发  根据openId群发
	 */
	public static final String sendGroupMessageByOpendIdsUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
	/**************************************** 群发消息管理结束***************************************************************************************/
	
	
	/****************************************素材管理开始***************************************************************************************/
	/**
	 * 新增临时素材
	 */
	public static final String uploadUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * 素材 获取临时素材  get 原“下载多媒体文件”接口
	 */
	public static final String getTempMaterialUrl = "https://api.weixin.qq.com/cgi-bin/media/get";
	
	/**
	 * 素材 新增永久图文素材
	 */
	public static final String addNewsUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	
	/**
	 * 素材 新增其他类型永久素材
	 */
	public static final String addMaterialUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * 素材 获取永久素材
	 */
	public static final String getMaterialUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	
	/**
	 * 修改永久图文素材
	 */
	public static final String updateNewsUrl = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	
	/**
	 * 删除永久素材
	 */
	public static final String delMaterialUrl ="https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	/****************************************素材管理结束***************************************************************************************/
	
	
	/****************************************用户管理开始***************************************************************************************/
	/**
	 * 获取用户基本信息（包括UnionID机制）
	 */
	public static final String getWxUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
	
	/**
	 * 获取用户列表
	 */
	public static final String getOpenIdListUrl = "https://api.weixin.qq.com/cgi-bin/user/get";
	/****************************************用户管理结束***************************************************************************************/
	
	
	/****************************************门店管理开始***************************************************************************************/
	/**
	 * 创建门店
	 */
	public static final String addPoiUrl = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=ACCESS_TOKEN";
	/****************************************门店管理结束***************************************************************************************/
	
	
	/****************************************卡券管理开始***************************************************************************************/
	/**
	 * 创建会员卡
	 */
	public static final String createCardUrl = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 设置开卡字段接口 POST
	 * 开发者在创建时填入wx_activate字段后，需要调用该接口设置用户激活时需要填写的选项，否则一键开卡设置不生效。
	 */
	public static final String setCardRegistryUrl = "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=ACCESS_TOKEN";
	
	/**
	 * 投放1-创建二维码接口(生成带参ticket和二维码url)
	 * action_name：
	 * expire_seconds： ticket有效期
	 * action_info： 卡劵详情(outer_str字段可设置网点标识)
	 */
	public static final String createQrCodeUrl = "https://api.weixin.qq.com/card/qrcode/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 投放2.1-html5网页发券-(jsapi_ticket) 
	 * get
	 * 公众号用于调用微信JS接口的临时票据
	 */
	public static final String getJsApiTicketUrl= "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	
	/**
	 * 投放2.2-html5网页发券-(api_ticket) get
	 * 卡券 api_ticket
	 * 卡券 api_ticket 是用于调用卡券相关接口的临时票据，有效期为 7200 秒，通过 access_token 来获取。
	 * 这里要注意与 jsapi_ticket 区分开来。
	 * 由于获取卡券 api_ticket 的 api 调用次数非常有限，频繁刷新卡券 api_ticket 会导致 api 调用受限，影响自身业务，
	 * 开发者必须在自己的服务全局缓存卡券 api_ticket 。
	 */
	public static final String getApiTicketUrl= "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	
	/**
	 * 导入code:将自定义code导入微信卡券后台，由微信侧代理存储并下发code
	 * 1）单次调用接口传入code的数量上限为100个。
	 * 2）每一个 code 均不能为空串。
	 * 3）导入结束后系统会自动判断提供方设置库存与实际导入code的量是否一致。
	 * 4）导入失败支持重复导入，提示成功为止。
	 * 
	 *  errcode	错误码，0为正常；40109：code数量超过100个
	 * 	errmsg	错误信息。
	 * 	succ_code	成功个数
	 * 	duplicate_code	重复导入的code会自动被过滤。
	 * 	fail_code	失败个数。
	 */
	public static final String depositUrl = "http://api.weixin.qq.com/card/code/deposit?access_token=ACCESS_TOKEN";
	
	/**
	 * 核查code
	 * exist_code 已经成功存入的code
	 * not_exist_code 没有存入的code
	 */
	public static final String checkCodeUrl = "http://api.weixin.qq.com/card/code/checkcode?access_token=ACCESS_TOKEN";
	
	/**
	 * 修改库存
	 * increase_stock_value 增加多少库存，支持不填或填0
	 * reduce_stock_value 减少多少库存，可以不填或填0
	 */
	public static final String modifyStockUrl = "https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN";
	
	/**
	 * 接口激活 POST
	 * 接口激活通常需要开发者开发用户填写资料的网页。通常有两种激活流程：
	 * 1. 用户必须在填写资料后才能领卡，领卡后开发者调用激活接口为用户激活会员卡；
	 * 2. 是用户可以先领取会员卡，点击激活会员卡跳转至开发者设置的资料填写页面，填写完成后开发者调用激活接口为用户激活会员卡。
	 */
	public static final String memberCardActivateUrl = "https://api.weixin.qq.com/card/membercard/activate?access_token=ACCESS_TOKEN";
		
	/**
	 * 拉取会员信息接口 POST
	 * 根据CardID和Code查询会员信息
	 */
	public static final String getVipUserInfoUrl = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 领取-设置测试白名单(开发测试使用)
	 * 由于卡券有审核要求，为方便公众号调试，可以设置一些测试帐号，这些帐号可领取未通过审核的卡券，体验整个流程。
	 * 1.同时支持“openid”、“username”两种字段设置白名单，总数上限为10个。
	 * 2.设置测试白名单接口为全量设置，即测试名单发生变化时需调用该接口重新传入所有测试人员的ID.
	 * 3.白名单用户领取该卡券时将无视卡券失效状态，请开发者注意。
	 */
	public static final String setCardWhitelistUrl ="https://api.weixin.qq.com/card/testwhitelist/set?access_token=ACCESS_TOKEN";
	
	/**
	 * 查看卡券详情
	 */
	public static final String queryCardDetailUrl = "https://api.weixin.qq.com/card/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 卡号解码
	 * post 
	 */
	public static final String decryptCodeUrl = "https://api.weixin.qq.com/card/code/decrypt?access_token=ACCESS_TOKEN";
	/****************************************卡券管理结束***************************************************************************************/
	
	/**
	 * 通过code换取网页授权access_token
	 * openid
	 */
	public static final String getOpenIdByCodeUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	/**
	 * 删除会员卡
	 */
	public static final String deleteCardUrl = "https://api.weixin.qq.com/card/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * 批量查询卡劵列表 post
	 */
	public static final String batchgetUrl = "https://api.weixin.qq.com/card/batchget?access_token=ACCESS_TOKEN";
}
