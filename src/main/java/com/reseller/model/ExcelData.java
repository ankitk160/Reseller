package com.reseller.model;

public class ExcelData {
	private Integer id;
	private String promoterName;
	private String campaign_name;
	private String country_name;
	private String operator_name;
	private String sub_sc;
	private String unsub_sc;
	private String keyword;
	private Integer pinlength;
	private Double price;
	private Integer validity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getCampaign_name() {
		return campaign_name;
	}

	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getOperator_name() {
		return operator_name;
	}

	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}

	public String getSub_sc() {
		return sub_sc;
	}

	public void setSub_sc(String sub_sc) {
		this.sub_sc = sub_sc;
	}

	public String getUnsub_sc() {
		return unsub_sc;
	}

	public void setUnsub_sc(String unsub_sc) {
		this.unsub_sc = unsub_sc;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPinlength() {
		return pinlength;
	}

	public void setPinlength(Integer pinlength) {
		this.pinlength = pinlength;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "ExcelData [id=" + id + ", PromoterName=" + promoterName + ", campaign_name=" + campaign_name
				+ ", country_name=" + country_name + ", operator_name=" + operator_name + ", sub_sc=" + sub_sc
				+ ", unsub_sc=" + unsub_sc + ", keyword=" + keyword + ", pinlength=" + pinlength + ", price=" + price
				+ ", validity=" + validity + "]";
	}
}
