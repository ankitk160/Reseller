package com.reseller.model;

import java.time.LocalDateTime;

public class AppTrafficServiceInfo {
	private Integer id;
	private String servicename;
	private Integer status;
	private LocalDateTime addtime;
	private LocalDateTime edittime;
	private String optimizePerc;
	private String optimizeFlag;
	private String associationType;
	private Double price;
	private Double bidrate;
	private Integer partnerid;
	private String promoterName;
	private String operatorid;
	private String service;
	private String territory;
	private String operator;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getAddtime() {
		return addtime;
	}

	public void setAddtime(LocalDateTime addtime) {
		this.addtime = addtime;
	}

	public LocalDateTime getEdittime() {
		return edittime;
	}

	public void setEdittime(LocalDateTime edittime) {
		this.edittime = edittime;
	}

	public String getOptimizePerc() {
		return optimizePerc;
	}

	public void setOptimizePerc(String optimizePerc) {
		this.optimizePerc = optimizePerc;
	}

	public String getOptimizeFlag() {
		return optimizeFlag;
	}

	public void setOptimizeFlag(String optimizeFlag) {
		this.optimizeFlag = optimizeFlag;
	}

	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getBidrate() {
		return bidrate;
	}

	public void setBidrate(Double bidrate) {
		this.bidrate = bidrate;
	}

	public Integer getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "AppTrafficServiceInfo [id=" + id + ", servicename=" + servicename + ", status=" + status + ", addtime="
				+ addtime + ", edittime=" + edittime + ", optimizePerc=" + optimizePerc + ", optimizeFlag="
				+ optimizeFlag + ", associationType=" + associationType + ", price=" + price + ", bidrate=" + bidrate
				+ ", partnerid=" + partnerid + ", promoterName=" + promoterName + ", operatorid=" + operatorid
				+ ", service=" + service + ", territory=" + territory + ", operator=" + operator + "]";
	}
}
