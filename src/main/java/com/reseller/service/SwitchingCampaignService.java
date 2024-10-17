package com.reseller.service;

import java.util.List;

import com.reseller.model.SwitchingCampaign;

public interface SwitchingCampaignService {

	public List<SwitchingCampaign> listAllSwitchingCampaign();

	public SwitchingCampaign getSwitchingCampaign(int id);

	public int insertSwitchingCampaign(SwitchingCampaign switchingCampaign);

	public int updateSwitchingCampaign(SwitchingCampaign switchingCampaign);
}
