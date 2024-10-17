package com.reseller.model;

import java.time.LocalDateTime;

public class SwitchingCampaign {
	private Integer id;
	private String switchingName;
	private Integer status;
	private LocalDateTime addtime;
	private LocalDateTime edittime;
	private String switchingCampId;
	private Integer switchingCampCap;
	private String switchingCampId_1;
	private Integer switchingCampCap_1;
	private String switchingCampId_2;
	private String createdBy;
	private String operatorid;
	private Integer switchBaseCampaignFlag;
	private Integer switchCampaignFlag_1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSwitchingName() {
		return switchingName;
	}

	public void setSwitchingName(String switchingName) {
		this.switchingName = switchingName;
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

	public String getSwitchingCampId() {
		return switchingCampId;
	}

	public void setSwitchingCampId(String switchingCampId) {
		this.switchingCampId = switchingCampId;
	}

	public Integer getSwitchingCampCap() {
		return switchingCampCap;
	}

	public void setSwitchingCampCap(Integer switchingCampCap) {
		this.switchingCampCap = switchingCampCap;
	}

	public String getSwitchingCampId_1() {
		return switchingCampId_1;
	}

	public void setSwitchingCampId_1(String switchingCampId_1) {
		this.switchingCampId_1 = switchingCampId_1;
	}

	public Integer getSwitchingCampCap_1() {
		return switchingCampCap_1;
	}

	public void setSwitchingCampCap_1(Integer switchingCampCap_1) {
		this.switchingCampCap_1 = switchingCampCap_1;
	}

	public String getSwitchingCampId_2() {
		return switchingCampId_2;
	}

	public void setSwitchingCampId_2(String switchingCampId_2) {
		this.switchingCampId_2 = switchingCampId_2;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public Integer getSwitchBaseCampaignFlag() {
		return switchBaseCampaignFlag;
	}

	public void setSwitchBaseCampaignFlag(Integer switchBaseCampaignFlag) {
		this.switchBaseCampaignFlag = switchBaseCampaignFlag;
	}

	public Integer getSwitchCampaignFlag_1() {
		return switchCampaignFlag_1;
	}

	public void setSwitchCampaignFlag_1(Integer switchCampaignFlag_1) {
		this.switchCampaignFlag_1 = switchCampaignFlag_1;
	}

	@Override
	public String toString() {
		return "SwitchingCampaign [id=" + id + ", switchingName=" + switchingName + ", status=" + status + ", addtime="
				+ addtime + ", edittime=" + edittime + ", switchingCampId=" + switchingCampId + ", switchingCampCap="
				+ switchingCampCap + ", switchingCampId_1=" + switchingCampId_1 + ", switchingCampCap_1="
				+ switchingCampCap_1 + ", switchingCampId_2=" + switchingCampId_2 + ", createdBy=" + createdBy
				+ ", operatorid=" + operatorid + ", switchBaseCampaignFlag=" + switchBaseCampaignFlag
				+ ", switchCampaignFlag_1=" + switchCampaignFlag_1 + "]";
	}
}
