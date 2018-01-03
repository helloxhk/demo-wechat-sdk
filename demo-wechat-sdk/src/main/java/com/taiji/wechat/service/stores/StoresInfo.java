package com.taiji.wechat.service.stores;

import java.util.ArrayList;
import java.util.List;

public class StoresInfo {

	private String sid = "33788392";
	private String business_name = "15个汉字或30个英文字符内";
	private String branch_name = "不超过10个字，不能含有括号和特殊字符";
	private String province = "不超过10个字";
	private String city = "不超过30个字";
	private String district = "不超过10个字";
	private String address = "门店所在的详细街道地址（不要填写省市信息）：不超过80个字";
	private String telephone = "不超53个字符（不可以出现文字）";
	private List<Category> categories = new ArrayList<Category>();//门店的类型 ["美食,江浙菜,上海菜","美食,江浙菜,淮扬菜","美食,江浙菜,浙江菜","美食,江浙菜,南京菜 ","美食,江浙菜,苏帮菜…"]
	private String offset_type = "1";
	private String longitude = "115.32375";
	private String latitude = "25.097486";
	private List<Photo> photo_list = new ArrayList<Photo>();//"[{"photo_url : "https:// 不超过20张.com"}，{"photo_url = "https://XXX.com"}],
	private String recommend = "不超过200字。麦辣鸡腿堡套餐，麦乐鸡，全家桶";
	private String special = "不超过200字。免费wifi，外卖服务";
	private String introduction = "不超过300字。麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上大约拥有3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、 水果等快餐食品";
	private String open_time = "8:00-20:00";
	private String avg_price = "35";
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getOffset_type() {
		return offset_type;
	}
	public void setOffset_type(String offset_type) {
		this.offset_type = offset_type;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public List<Photo> getPhoto_list() {
		return photo_list;
	}
	public void setPhoto_list(List<Photo> photo_list) {
		this.photo_list = photo_list;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(String avg_price) {
		this.avg_price = avg_price;
	}
	
}
