package com.reseller.service;

import java.util.List;

import com.reseller.model.Territory;

public interface TerritoryService {

	public List<Territory> listAllTerritory();

	public Territory getTerritory(int id);

	public int insertTerritory(Territory territory);

	public int updateTerritory(Territory territory);
}
