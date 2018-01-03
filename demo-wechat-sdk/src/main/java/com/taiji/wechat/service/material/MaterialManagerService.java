package com.taiji.wechat.service.material;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.kalian.thirdchannel.commons.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;

public class MaterialManagerService extends BaseHttpClient{

	protected MaterialManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object sendData(Map paramMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 素材 新增临时素材
	 * @param access_token
	 * @param articles
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> upload(String access_token,String materialType, File media) throws Exception{
		String uploadUrl = ConstantService.uploadUrl.replace("ACCESS_TOKEN", access_token).replace("TYPE", materialType);
		Map<String,String> req = new HashMap<String,String>();
		String res = new MaterialManagerService(uploadUrl, 3000, ConstantService.CHARSET).sendHttpsWithMultipartByPost(req, media, "media");
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 素材 获取临时素材（原“下载多媒体文件”接口）
	 * @param access_token
	 * @param articles
	 * @return
	 * @throws Exception
	 */
	public static byte[] getTempMaterial(String access_token,String media_id) throws Exception{
		String getTempMaterialUrl = ConstantService.getTempMaterialUrl.replace("ACCESS_TOKEN", access_token).replace("MEDIA_ID", media_id);
		Map<String,String> req = new HashMap<String,String>();
		req.put("access_token", access_token);
		req.put("media_id", media_id);
		String dataStr = new String(new StringBuffer("access_token=").append(access_token).append("&media_id=").append(media_id));
		byte[] res = new MaterialManagerService(getTempMaterialUrl, 3000, ConstantService.CHARSET).sendHttpsByGetResponsBytes(dataStr);
		return res;
	}
	
	/**
	 * 素材 新增其他类型(MaterialTypeConstant)永久素材
	 * @param access_token
	 * @param materialType 素材类型
	 * @param media 多媒体文件
	 * @param title 上传视频素材时需要
	 * @param introduction 上传视频素材时需要
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> addMaterial(String access_token,String materialType, File media,String title,String introduction) throws Exception{
		String addMaterialUrl = ConstantService.addMaterialUrl.replace("ACCESS_TOKEN", access_token).replace("TYPE", materialType);
		Map<String,String> req = new HashMap<String,String>();
		if(materialType.equals(MaterialTypeConstant.MATERIALTYPE_VIDEO)){
			Map description = new HashMap<String,String>();
			description.put("title", title);
			description.put("introduction", introduction);
			req.put("description", JSONObject.fromObject(description).toString());
		}
		String res = new MaterialManagerService(addMaterialUrl, 3000, ConstantService.CHARSET).sendHttpsWithMultipartByPost(req, media, "media");
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 素材 新增永久   图文  素材（不好用）
	 * @param access_token
	 * @param articles(图文消息的封面图片素材id（必须是永久mediaID）调用addMaterial获取)
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> addNews(String access_token,List<Article> articles) throws Exception{
		String addNewsUrl = ConstantService.addNewsUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("articles", articles);
		String res = new MaterialManagerService(addNewsUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 获取永久素材
	 * @param access_token
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getMaterial(String access_token,String media_id) throws Exception{
		String getMaterialUrl = ConstantService.getMaterialUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("media_id", media_id);
		String res = new MaterialManagerService(getMaterialUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 修改永久素材
	 * @param access_token
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> updateNews(String access_token,String media_id,String index, Map articles) throws Exception{
		String updateNewsUrl = ConstantService.updateNewsUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("media_id", media_id);
		req.put("index", index);
		req.put("articles", articles);
		String res = new MaterialManagerService(updateNewsUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
	/**
	 * 删除永久素材
	 * @param access_token
	 * @param media_id
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> delMaterial(String access_token,String media_id) throws Exception{
		String delMaterialUrl = ConstantService.delMaterialUrl.replace("ACCESS_TOKEN", access_token);
		Map<String,Object> req = new HashMap<String,Object>();
		req.put("media_id", media_id);
		String res = new MaterialManagerService(delMaterialUrl, 3000, ConstantService.CHARSET).sendHttpsByPostWriter(JSONObject.fromObject(req).toString());
		Map<String, Object> respMap = (Map)JSONObject.fromObject(res);
		return respMap;
	}
	
//	public static void main(String[] args) throws Exception {
//		String token = AccessTokenManagerService.getAccessTokenService("wxc751f09fc7fd39f3","57bee3ec04edb056ca3f8ab88b536ce9");
//		String materialType = GroupMessageTypeConstant.MSGTYPE_IMAGE;
//		File file = new File("C:\\Users\\yjh\\Desktop\\pic\\111.png");
//		//1 素材 新增临时 图片 素材
//		Map<String, Object> uploadMap = upload(token,materialType,file);
//		System.out.println(uploadMap);
//		System.out.println(uploadMap.get("media_id"));
//		
//		//获取临时素材
//		getTempMaterial(token,(String)uploadMap.get("media_id"));
//		
//		
		//2 新增永久 图片素材
//		Map<String, Object> addMaterialMap = addMaterial(token,materialType,file,null,null);
//		System.out.println(addMaterialMap);
		
		//客服回复图片
//		Map<String, Object> res = KfMessageManagerService.sendKfMessageImageService(token, "olgEOwUH7xhkTT33pNghOav3tAAg", materialType, (String)addMaterialMap.get("media_id"));
//		System.out.println(res);
//		
//		//获取永久素材
//		Map<String, Object> respMap = getMaterial(token,(String)addMaterialMap.get("media_id"));
//		System.out.println(respMap);
//		
		//3 素材 新增永久图文素材
//		List articles = new ArrayList();
//		Article article1 = new Article();
//		article1.setTitle("Happy Day");
//		article1.setThumb_media_id((String)addMaterialMap.get("media_id"));
//		article1.setAuthor("tushikun");
//		article1.setDigest("");
//		article1.setShow_cover_pic("1");
//		article1.setContent("13521523560");
//		article1.setContent_source_url("http://www.baidu.com");
//		
//		Article article2 = new Article();
//		article2.setTitle("你好");
//		article2.setThumb_media_id((String)addMaterialMap.get("media_id"));
//		article2.setAuthor("tushikun");
//		article2.setDigest("");
//		article2.setShow_cover_pic("0");//是否显示封面，1为显示，0为不显示
//		article2.setContent("我的电话号码");//图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
//		article2.setContent_source_url("http://www.baidu.com");
//
//		articles.add(article1);
//		articles.add(article2);
//		Map resmap = addNews(token,articles);
//		//Map resmap = GroupMessageManagerService.uploadNews(token,articles);
//		System.out.println(resmap);
//		//客服
//		Map<String, Object> res = KfMessageManagerService.sendKfMessageImageService(token, "olgEOwUH7xhkTT33pNghOav3tAAg", materialType, (String)addMaterialMap.get("media_id"));
//		System.out.println(res);
//		
//	}
}
