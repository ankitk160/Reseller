package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.SwitchingCampaign;

@Service("switchingCampaignService")
@CacheConfig(cacheNames = "switchingCampaignCache")
public class SwitchingCampaignServiceImpl implements SwitchingCampaignService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allSwitchingCampaign'")
	@Override
	public List<SwitchingCampaign> listAllSwitchingCampaign() {
		return resellerMapper.listAllSwitchingCampaign();
	}

	@Override
	public SwitchingCampaign getSwitchingCampaign(int id) {
		return resellerMapper.getSwitchingCampaign(id);
	}

	@CacheEvict(key = "'allSwitchingCampaign'")
	@Override
	public int insertSwitchingCampaign(SwitchingCampaign switchingCampaign) {
		return resellerMapper.insertSwitchingCampaign(switchingCampaign);
	}

	@CacheEvict(key = "'allSwitchingCampaign'")
	@Override
	public int updateSwitchingCampaign(SwitchingCampaign switchingCampaign) {
		return resellerMapper.updateSwitchingCampaign(switchingCampaign);
	}

}
