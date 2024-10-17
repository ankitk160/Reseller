package com.reseller.service;

import java.util.List;

import com.reseller.model.Partner;

public interface PartnerService {

	public List<Partner> listAllPartner();

	public int insertPartner(Partner partner);

	public Partner getPartner(int id);

	public int updatePartner(Partner partner);

	public String getPartnerById(int id);

}
