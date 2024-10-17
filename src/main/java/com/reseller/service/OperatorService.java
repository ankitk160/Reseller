package com.reseller.service;

import java.util.List;

import com.reseller.model.Operator;

public interface OperatorService {
	public List<Operator> listAllOperator();

	public Operator getOperator(int id);

	public int insertOperator(Operator operator);

	public int updateOperator(Operator operator);

	public List<Operator> getOperatorByTerritoryId(int territoryid);
}
