package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.Partner;

@Service("partnerService")
@CacheConfig(cacheNames = "partnerCache")
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allPartners'")
	@Override
	public List<Partner> listAllPartner() {
		return resellerMapper.listAllPartner();
	}

	@CacheEvict(key = "'allPartners'")
	@Override
	public int insertPartner(Partner partner) {
		return resellerMapper.insertPartner(partner);
	}

	@Override
	public Partner getPartner(int id) {
		return resellerMapper.getPartner(id);
	}

	@CacheEvict(key = "'allPartners'")
	@Override
	public int updatePartner(Partner partner) {
		return resellerMapper.updatePartner(partner);
	}

	@Override
	public String getPartnerById(int id) {
		return resellerMapper.getPartnerById(id);
	}

}
