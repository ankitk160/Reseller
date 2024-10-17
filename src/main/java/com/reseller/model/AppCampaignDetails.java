package com.reseller.model;

public class AppCampaignDetails {
	private Integer id;
	private String campaign_name;
	private String operatorid;
	private String shortcode;
	private Integer pinlength;
	private Double price;
	private Integer validity;
	private Integer partnerid;
	private Integer status;
	private Integer territoryid;
	private String keyword;
	private String initials;
	private String operator;
	private String partner;
	private String territory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampaign_name() {
		return campaign_name;
	}

	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
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

	public Integer getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTerritoryid() {
		return territoryid;
	}

	public void setTerritoryid(Integer territoryid) {
		this.territoryid = territoryid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Override
	public String toString() {
		return "AppCampaignDetails [id=" + id + ", campaign_name=" + campaign_name + ", operatorid=" + operatorid
				+ ", shortcode=" + shortcode + ", pinlength=" + pinlength + ", price=" + price + ", validity="
				+ validity + ", partnerid=" + partnerid + ", status=" + status + ", territoryid=" + territoryid
				+ ", keyword=" + keyword + ", initials=" + initials + ", operator=" + operator + ", partner=" + partner
				+ ", territory=" + territory + "]";
	}
}
