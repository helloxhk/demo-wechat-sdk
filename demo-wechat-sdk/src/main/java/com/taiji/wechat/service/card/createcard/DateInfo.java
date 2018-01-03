package com.taiji.wechat.service.card.createcard;

public class DateInfo {

	/**
	 * 使用时间的类型
	 * 支持固定时长有效类型
	 * 固定日期有效类型
	 * 永久有效类型(DATE_TYPE_PERMANENT)
	 * 必填：是
	 */
	private String type;

	/**
	 * type为DATE_TYPE_FIX_TIME_RANGE时专用，
	 * 表示起用时间。从1970年1月1日00:00:00至起用时间的秒数
	 * （东八区时间,UTC+8，单位为秒） 
	 * 必填：否
	 */
	private Integer begin_timestamp;
	
	/**
	 * type为DATE_TYPE_FIX_TERM_RANGE时专用，表示结束时间（东八区时间,UTC+8，单位为秒）
	 * 必填：否
	 */
	private Integer end_timestamp;
	
	/**
	 * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，领取后当天有效填写0（单位为天）
	 * 必填：否
	 */
	private Integer fixed_term;
	
	/**
	 * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效。（单位为天）
	 * 必填：否
	 */
	private Integer fixed_begin_term;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setBegin_timestamp(Integer begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public Integer getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(Integer end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	public Integer getFixed_term() {
		return fixed_term;
	}

	public void setFixed_term(Integer fixed_term) {
		this.fixed_term = fixed_term;
	}

	public Integer getFixed_begin_term() {
		return fixed_begin_term;
	}

	public void setFixed_begin_term(Integer fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	
}
