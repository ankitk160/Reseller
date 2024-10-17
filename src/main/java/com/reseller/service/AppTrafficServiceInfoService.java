package com.reseller.service;

import java.util.List;

import com.reseller.model.AppTrafficServiceInfo;

public interface AppTrafficServiceInfoService {
	public List<AppTrafficServiceInfo> listAllAppTrafficServiceInfo();

	public AppTrafficServiceInfo getAppTrafficServiceInfo(int id);

	public int insertAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo);

	public int updateAppTrafficServiceInfo(AppTrafficServiceInfo appTrafficServiceInfo);

	public List<AppTrafficServiceInfo> getATSInfoByIds(int operatorid, String PromoterName);
}
