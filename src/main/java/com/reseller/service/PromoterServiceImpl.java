package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.Promoter;

@Service("promoterService")
@CacheConfig(cacheNames = "promoterCache")
public class PromoterServiceImpl implements PromoterService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allPromoters'")
	@Override
	public List<Promoter> listAllPromoter() {
		return resellerMapper.listAllPromoter();
	}

	@CacheEvict(key = "'allPromoters'")
	@Override
	public int insertPromoter(Promoter promoter) {
		return resellerMapper.insertPromoter(promoter);
	}

	@Override
	public Promoter getPromoter(int id) {
		return resellerMapper.getPromoter(id);
	}

	@CacheEvict(key = "'allPromoters'")
	@Override
	public int updatePromoter(Promoter promoter) {
		return resellerMapper.updatePromoter(promoter);
	}
}
