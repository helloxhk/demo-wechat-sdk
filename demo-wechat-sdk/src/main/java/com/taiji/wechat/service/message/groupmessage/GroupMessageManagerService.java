package com.taiji.wechat.service.message.groupmessage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class GroupMessageManagerService extends BaseHttpClient<String> {

	protected GroupMessageManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}

	@Override
	public String sendData(Map paramMap) {
		return null;
	}

	//群发接口每分钟限制请求60次，超过限制的请求会被拒绝。
	//开发者可以主动设置 clientmsgid 来避免重复推送。
	
	/**
	 * 上传图文消息内的图片获取URL
	 * 不占用公众号的素材库中图片数量的5000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下
	 * @param access_token
	 * @param media
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> uploadImg(String access_token,File media) throws Exception{
		String uploadImgUrl = ConstantService.uploadImgUrl.replace("ACCESS_TOKEN",access_token);
		Map<String,String> req = new HashMap<String,String>();
		String res = new GroupMessageManagerService(uploadImgUrl, 3000, ConstantService.CHARSET).sendHttpsWithMultipartByPost(req, media, "media");
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 上传视频 得到群发视频时所需的media_id
	 * @param access_token
	 * @param media_id 需通过基础支持中的上传下载多媒体文件来得到：MaterialManagerService
	 * @param title
	 * @param description
	 * @return
	 * @throws Exception
	 */
	public static String uploadVideo(String access_token,String media_id,String title,String description) throws Exception{
		String uploadVideoUrl = ConstantService.uploadVideoUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("media_id", media_id);
		req.put("title", title);
		req.put("description", description);
		String res = new GroupMessageManagerService(uploadVideoUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		if(StringUtils.isNotBlank((String)respMap.get("media_id"))){
			return (String)respMap.get("media_id");
		}else{
			return "";
		}
	}
	
	/**
	 * 群发 上传图文消息素材（好用）
	 * @param access_token
	 * @param articles
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> uploadNews(String access_token,List articles) throws Exception{
		String uploadNewsUrl = ConstantService.uploadNewsUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("articles", articles);
		String res = new GroupMessageManagerService(uploadNewsUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 群发  根据openId群发
	 * @param access_token
	 * @param touser 
	 * @param msgtype
	 * @param media_id 需通过基础支持中的上传下载多媒体文件来得到：MaterialManagerService
	 * @param send_ignore_reprint
	 * @param content
	 * @param title
	 * @param description
	 * @param card_id
	 * @return
	 * @throws Exception
	 * 
	 * 请注意：在返回成功时，意味着群发任务提交成功，并不意味着此时群发已经结束，
	 * 所以，仍有可能在后续的发送过程中出现异常情况导致用户未收到消息，如消息有时会进行审核、服务器不稳定等。
	 * 此外，群发任务一般需要较长的时间才能全部发送完毕，请耐心等待。
	 */
	public static Map<String, Object> sendGroupMessageByOpendIds(String access_token,List touser,String msgtype,String media_id,String send_ignore_reprint,String content,String title,String description,String card_id) throws Exception{
		
		String sendGroupMessageByOpendIdsUrl = ConstantService.sendGroupMessageByOpendIdsUrl.replace("ACCESS_TOKEN", access_token);
		
		//群发请求
		Map<String,Object> req = new HashMap<String,Object>();
		
		//填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
		req.put("touser", touser);
		
		req.put("msgtype", msgtype);
		
		if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_MPNEWS)){
			Map<String,String> mpnews = new HashMap<String,String>();
			mpnews.put("media_id", media_id);
			req.put("mpnews", mpnews);
			req.put("send_ignore_reprint", send_ignore_reprint);//1为继续群发（转载），0为停止群发。该参数默认为0。
		}else if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_TEXT)){
			Map<String,String> text = new HashMap<String,String>();
			text.put("content", content);
			req.put("text", text);
		}else if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_VOICE)){
			Map<String,String> voice = new HashMap<String,String>();
			voice.put("media_id", media_id);
			req.put("voice", voice);
		}else if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_IMAGE)){
			Map<String,String> image = new HashMap<String,String>();
			image.put("media_id", media_id);
			req.put("image", image);
		}else if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_MPVIDEO)){
			Map<String,String> mpvideo = new HashMap<String,String>();
			mpvideo.put("media_id", uploadVideo(access_token,media_id,title,description));
			mpvideo.put("title", title);
			mpvideo.put("description", description);
			req.put("mpvideo", mpvideo);
		}else if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_WXCARD)){
			Map<String,String> wxcard = new HashMap<String,String>();
			wxcard.put("card_id", card_id);
			req.put("wxcard", wxcard);
		}
		String res = new GroupMessageManagerService(sendGroupMessageByOpendIdsUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 群发 图文消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param media_id
	 * @param send_ignore_reprint
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendMpNewsByOpendIds(String access_token,List touser,String msgtype,String media_id,String send_ignore_reprint) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,media_id,send_ignore_reprint,null,null,null,null);
	}
	
	/**
	 * 群发文本消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendTextByOpendIds(String access_token,List touser,String msgtype,String content) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,null,null,content,null,null,null);
	}
	
	/**
	 * 群发 语音消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendVoiceByOpendIds(String access_token,List touser,String msgtype,String media_id) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,media_id,null,null,null,null,null);
	}
	
	/**
	 * 群发 图片消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendImageByOpendIds(String access_token,List touser,String msgtype,String media_id) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,media_id,null,null,null,null,null);
	}
	
	/**
	 * 群发 视频消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param media_id
	 * @param title
	 * @param description
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendMpVideoByOpendIds(String access_token,List touser,String msgtype,String media_id,String title,String description) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,media_id,null,null,title,description,null);
	}
	
	/**
	 * 群发 卡券 消息
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param card_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> sendWxCardByOpendIds(String access_token,List touser,String msgtype,String card_id) throws Exception{
		return sendGroupMessageByOpendIds(access_token,touser,msgtype,null,null,null,null,null,card_id);
	}
	
	/**
	 * 群发预览
	 * @param access_token
	 * @param touser
	 * @param msgtype
	 * @param paraMap
	 * @return
	 * @throws Exception 
	 */
	public static Map<String, Object> preview(String access_token,String touser,String msgtype,Map paraMap) throws Exception{
		String previewUrl = ConstantService.previewUrl.replace("ACCESS_TOKEN",access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("touser", touser);
		req.put("msgtype", msgtype);
		req.put(msgtype, paraMap);
		String res = new GroupMessageManagerService(previewUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		String token = AccessTokenManagerService.getAccessTokenService("wxee4e2d5043904ca2","df3081ec27dced5f99d51fde2410051e");
//		
////		File file = new File("C:\\Users\\yjh\\Desktop\\pic\\111.png");
////		Map<String, Object> map = uploadImg(token,file);
////		System.out.println(map);
//		
//		String materialType = GroupMessageTypeConstant.MSGTYPE_IMAGE;
//		File file = new File("C:\\Users\\yjh\\Desktop\\pic\\111.png");
////		
////		Map<String, Object> uploadMap = MaterialManagerService.upload(token,materialType,file);
////		System.out.println(uploadMap);
////		System.out.println(uploadMap.get("media_id"));
////		
//		Map<String, Object> addMaterialMap = MaterialManagerService.addMaterial(token,materialType,file,null,null);
//		System.out.println(addMaterialMap);
//	
//		List articles = new ArrayList();
//		Map<String,Object> map1 = new HashMap<String,Object>();
//		map1.put("thumb_media_id",addMaterialMap.get("media_id"));
//		map1.put("author","tushikun");
//		map1.put("title","水电费水电费水电费水电费");
//		
//		//图文消息的原文地址，即点击“阅读原文”后的URL
//		map1.put("content_source_url","http://www.baidu.com");
//		//content 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源"上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。
//		//map1.put("content","<div style=\"text-align:left;\">升水水电费<table style=\"width:100%;\" cellpadding=\"2\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000000\"><tbody><tr><td>1</td><td>1</td></tr><tr><td>1</td><td>1</td></tr><tr><td>1</td><td>1</td></tr></tbody></table><img src=\"http://mmbiz.qpic.cn/mmbiz_jpg/DvUsoaqXicHCyXqLgAKsDamLtdvFV6BIqXWf9WpLJeibGbJhM6tegPejyURkadXTlNfFFkQYLn2UMljf8Ciasl4Sg/0\" width=\"200\" height=\"200\" title=\"1\" alt=\"1\" /><br /></div>");
//		map1.put("content", "<p id=\"123\"><b>123&456</b></p>");
//		map1.put("digest","digest");//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。
//		map1.put("show_cover_pic",0);//为1时，图文的开始部分会显示封面图片
//		
////		Map<String,Object> map2= new HashMap<String,Object>();
////		map2.put("thumb_media_id",uploadMap.get("media_id"));
////		map2.put("author","tushikun");
////		map2.put("title","how are you ni le ssss dsfsdfsdf ");
////		map2.put("content_source_url","http://www.baidu.com");
////		map2.put("content","我的电话号码");//图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
////		map2.put("digest","digest");
////		map2.put("show_cover_pic",0);//是否显示封面，1为显示，0为不显示
//		articles.add(JSONObject.fromObject(map1));
////		articles.add(JSONObject.fromObject(map2));
//		Map resmap  = MaterialManagerService.addNews(token,articles);
////		Map resmap = uploadNews(token,articles);
//		System.out.println(resmap);
//		
//		
////		String msgtype = GroupMessageTypeConstant.MSGTYPE_MPNEWS;
////		String content = "群发消息1";
//////		//String token = "_39G44q8Uya4CN86Dxm6QK6SD9nGTINpraKN5zYiRLmWC_D1j3qwdLYLqNv0N6Jv70TI6Geax5zaUCf0L5j3No7GfmerjSiyWHqgqXgRji9b8BL7WjsP9knOn2TqBEi4WJMiAJAIVY";
////		
////		//预览
////		Map paramMap = new HashMap();
////		if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_TEXT)){
////			paramMap.put("content", content);
////		}else{
////			paramMap.put("media_id", resmap.get("media_id"));
////		}
////		
////		Map<String, Object> previewMap = preview(token,"oPA9Ev6_BlwGBvoSjvVvCIx0Se2s",msgtype,paramMap);
////		System.out.println(previewMap);
//				
//		//修改
////		Map articles1 = new HashMap<String,Object>();
////		map1.put("thumb_media_id",uploadMap.get("media_id"));
////		map1.put("author","tushikun");
////		map1.put("title","AAAAAAAAAAAAAAAAAA");
////		map1.put("content_source_url","http://www.baidu.com");
////		map1.put("content","13521523560");
////		map1.put("digest","digest");
////		map1.put("show_cover_pic",1);
////		Map resmap1 = MaterialManagerService.updateNewsUrl(token,(String) resmap.get("media_id"),"0",articles1);
////		System.out.println(resmap1);
//		
//		//预览
////		Map paramMap1 = new HashMap();
////		if(msgtype.equals(GroupMessageTypeConstant.MSGTYPE_TEXT)){
////			paramMap.put("content", content);
////		}else{
////			paramMap.put("media_id", resmap1.get("media_id"));
////		}
////		
////		Map<String, Object> previewMap1 = preview(token,"oPA9Ev6_BlwGBvoSjvVvCIx0Se2s",msgtype,paramMap);
////		System.out.println(previewMap1);
//		
//		//群发
////		List touser = WxUserManagerService.getOpenIds(token,"");
////		String media_id = "P1n4ddXHXXz05ze45SB0HLkhitE49rd1km-O1Gt6Wr-w4iXJirJ9fC7-NpPgSjwA";
////		Map<String,Object>  res = sendMpNewsByOpendIds(token,touser,msgtype,media_id,"0");
////		System.out.println(res);
//	
//		
//	}
}
