package com.reseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.Operator;

@Service("operatorService")
@CacheConfig(cacheNames = "operatorCache")
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Cacheable(key = "'allOperators'")
	@Override
	public List<Operator> listAllOperator() {
		return resellerMapper.listAllOperator();
	}

	@Override
	public Operator getOperator(int id) {
		return resellerMapper.getOperator(id);
	}

	@CacheEvict(key = "'allOperators'")
	@Override
	public int insertOperator(Operator operator) {
		return resellerMapper.insertOperator(operator);
	}

	@CacheEvict(key = "'allOperators'")
	@Override
	public int updateOperator(Operator operator) {
		return resellerMapper.updateOperator(operator);
	}

	@Override
	public List<Operator> getOperatorByTerritoryId(int territoryid) {
		return resellerMapper.getOperatorByTerritoryId(territoryid);
	}
}
