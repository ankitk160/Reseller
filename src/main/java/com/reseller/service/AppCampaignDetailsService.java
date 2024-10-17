package com.reseller.service;

import java.util.List;

import com.reseller.model.AppCampaignDetails;

public interface AppCampaignDetailsService {

	public List<AppCampaignDetails> listAllAppCampaignDetails();

	public int insertAppCampaignDetails(AppCampaignDetails appCampaignDetails);

	public int updateAppCampaignDetails(AppCampaignDetails appCampaignDetails);

	public AppCampaignDetails getAppCampaignDetails(int id);

	public List<AppCampaignDetails> getAppCampaignByOperatorId(int operatorid);

	public AppCampaignDetails getCampaignDetails(int operatorid, int partnerid, int territoryid);

}
