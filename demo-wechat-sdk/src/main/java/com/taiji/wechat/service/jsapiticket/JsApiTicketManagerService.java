package com.taiji.wechat.service.jsapiticket;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.taiji.common.exception.EStockThirdException;
import com.taiji.common.network.http.BaseHttpClient;
import com.taiji.wechat.constant.ConstantService;
import com.taiji.wechat.service.card.CardManagerService;
import com.taiji.wechat.service.utils.StringUitls;

public class JsApiTicketManagerService extends BaseHttpClient {

	protected JsApiTicketManagerService(String url, int timeout, String charset) {
		super(url, timeout, charset);
	}

	@Override
	public Object sendData(Map paramMap) {
		return null;
	}

	/**
	 * jsapi_ticket
	 * 
	 * @param access_token
	 * @return
	 * @throws EStockThirdException
	 */
	public static String getJsApiTicket(String access_token) throws EStockThirdException {
		String jsapi_ticket = null;
		String getJsApiTicketUrl = ConstantService.getJsApiTicketUrl;
		String dataStr = new String(new StringBuffer("access_token=").append(access_token).append("&type=jsapi"));
		String res = new JsApiTicketManagerService(getJsApiTicketUrl, 3000,ConstantService.CHARSET).sendHttpsByGet(dataStr);
		Map<String, Object> resmap = (Map) JSONObject.fromObject(res);
		jsapi_ticket = resmap.get("ticket").toString();//获取失败返回null
		return jsapi_ticket;
	}

	/**
	 * 通过jspai_ticket得到签名
	 * 签名生成规则如下：
	 * 1参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。
	 * 2 对所有待签名参数   按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。这里需要注意的是所有参数名均为小写字符。
	 * 3对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。即signature=sha1(string1)。
	 * @param jspai_ticket
	 * @param url 当前网页的URL，不包含#及其后面部分
	 * @return
	 * @throws EStockThirdException
	 */
	public static Map<String, String> getJsApiTicketSign(String jsapi_ticket, String url) throws EStockThirdException {
		Map<String, String> resmap = new HashMap<String, String>();
		String nonce_str = StringUitls.create_nonce_str();
		String timestamp = StringUitls.create_timestamp();
		String signature = "";
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("jsapi_ticket", jsapi_ticket);
		maps.put("noncestr", nonce_str);
		maps.put("timestamp", timestamp);
		maps.put("url", url);
		String String1 = StringUitls.getOrderByLexicographic(maps);
		signature = StringUitls.SHA1(String1);
		resmap.put("url", url);
		resmap.put("jsapi_ticket", jsapi_ticket);
		resmap.put("nonceStr", nonce_str);
		resmap.put("timestamp", timestamp);
		resmap.put("signature", signature);
		return resmap;
	}

}
