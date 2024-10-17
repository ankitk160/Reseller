package com.reseller.service;

import java.util.List;

import com.reseller.model.Promoter;

public interface PromoterService {

	public List<Promoter> listAllPromoter();

	public int insertPromoter(Promoter promoter);

	public Promoter getPromoter(int id);

	public int updatePromoter(Promoter promoter);
}
