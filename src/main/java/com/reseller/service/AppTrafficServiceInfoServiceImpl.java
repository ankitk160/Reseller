package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.AppTrafficServiceInfo;

@Service("appTrafficServiceInfoService")
@CacheConfig(cacheNames = "appTSInfoCache")
public class AppTrafficServiceInfoServiceImpl implements AppTrafficServiceInfoService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allAppTSInfo'")
	@Override
	public List<AppTrafficServiceInfo> listAllAppTrafficServiceInfo() {
		return resellerMapper.listAllAppTrafficServiceInfo();
	}

	@Override
	public AppTrafficServiceInfo getAppTrafficServiceInfo(int id) {
		return resellerMapper.getAppTrafficServiceInfo(id);
	}

	@CacheEvict(key = "'allAppTSInfo'")
	@Override
	public int insertAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo) {
		return resellerMapper.insertAppTrafficServiceInfo(appTrafficServiceInfo);
	}

	@CacheEvict(key = "'allAppTSInfo'")
	@Override
	public int updateAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo) {
		return resellerMapper.updateAppTrafficServiceInfo(appTrafficServiceInfo);
	}

	@Override
	public List<AppTrafficServiceInfo> getATSInfoByIds(int operatorid, String PromoterName) {
		return resellerMapper.getATSInfoByIds(operatorid, PromoterName);
	}
}
