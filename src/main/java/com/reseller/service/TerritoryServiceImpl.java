package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.Territory;

@Service("territoryService")
@CacheConfig(cacheNames = "territoryCache")
public class TerritoryServiceImpl implements TerritoryService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allTerritories'")
	@Override
	public List<Territory> listAllTerritory() {
		return resellerMapper.listAllTerritory();
	}

	@Override
	public Territory getTerritory(int id) {
		return resellerMapper.getTerritory(id);
	}

	@CacheEvict(key = "'allTerritories'")
	@Override
	public int insertTerritory(Territory territory) {
		return resellerMapper.insertTerritory(territory);
	}

	@CacheEvict(key = "'allTerritories'")
	@Override
	public int updateTerritory(Territory territory) {
		return resellerMapper.updateTerritory(territory);
	}
}
