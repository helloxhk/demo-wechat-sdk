package com.taiji.wechat.service.card.setcardregistry;

import java.util.List;
/**
 * @Description: 注册新会员-富文本选项
 * @Company: 卡联科技
 * @date 2017年10月10日 下午3:21:29
 */
public class RichField {

	/**
	 * FORM_FIELD_RADIO 自定义单选
	 * FORM_FIELD_SELECT 自定义选择项
	 * FORM_FIELD_CHECK_BOX 自定义多选 
	 */
	private String type;//富文本类型
	
	private String name;//字段名
	
	private List<String> values;//选择项

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
}
