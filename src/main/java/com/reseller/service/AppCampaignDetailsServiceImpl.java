package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.AppCampaignDetails;

@Service("appCampaignDetailsService")
@CacheConfig(cacheNames = "appCDetailsCache")
public class AppCampaignDetailsServiceImpl implements AppCampaignDetailsService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allAppCDetails'")
	@Override
	public List<AppCampaignDetails> listAllAppCampaignDetails() {
		return resellerMapper.listAllAppCampaignDetails();
	}

	@CacheEvict(key = "'allAppCDetails'")
	@Override
	public int insertAppCampaignDetails(AppCampaignDetails appCampaignDetails) {
		return resellerMapper.insertAppCampaignDetails(appCampaignDetails);
	}

	@CacheEvict(key = "'allAppCDetails'")
	@Override
	public int updateAppCampaignDetails(AppCampaignDetails appCampaignDetails) {
		return resellerMapper.updateAppCampaignDetails(appCampaignDetails);
	}

	@Override
	public AppCampaignDetails getAppCampaignDetails(int id) {
		return resellerMapper.getAppCampaignDetails(id);
	}

	@Override
	public List<AppCampaignDetails> getAppCampaignByOperatorId(int operatorid) {
		return resellerMapper.getAppCampaignByOperatorId(operatorid);
	}

	@Override
	public AppCampaignDetails getCampaignDetails(int operatorid, int partnerid, int territoryid) {
		return resellerMapper.getCampaignDetails(operatorid, partnerid, territoryid);
	}

}
