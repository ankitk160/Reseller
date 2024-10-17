package com.reseller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reseller.model.AppCampaignDetails;
import com.reseller.model.AppTrafficServiceInfo;
import com.reseller.model.ExcelData;
import com.reseller.model.Operator;
import com.reseller.model.Partner;
import com.reseller.model.Promoter;
import com.reseller.model.SwitchingCampaign;
import com.reseller.model.Territory;
import com.reseller.service.AppCampaignDetailsService;
import com.reseller.service.AppTrafficServiceInfoService;
import com.reseller.service.OperatorService;
import com.reseller.service.PartnerService;
import com.reseller.service.PromoterService;
import com.reseller.service.SwitchingCampaignService;
import com.reseller.service.TerritoryService;

@Controller
public class PageServingController {

	@Autowired
	private AppTrafficServiceInfoService appTrafficServiceInfoService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private TerritoryService territoryService;

	@Autowired
	private PromoterService promoterService;

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private AppCampaignDetailsService appCampaignDetailsService;

	@Autowired
	private SwitchingCampaignService switchingCampaignService;

	@RequestMapping(value = "/")
	public ModelAndView test() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/index")
	public ModelAndView index(Model model) {
		ModelAndView index = new ModelAndView("index");
		int countAppTSInfo = appTrafficServiceInfoService.listAllAppTrafficServiceInfo().size();
		int countCampaignDetails = appCampaignDetailsService.listAllAppCampaignDetails().size();
		int countSwitchingCampaign = switchingCampaignService.listAllSwitchingCampaign().size();
		int countOperator = operatorService.listAllOperator().size();
		int countTerritory = territoryService.listAllTerritory().size();
		int countPromoter = promoterService.listAllPromoter().size();
		int countPartner = partnerService.listAllPartner().size();
		model.addAttribute("countAppTSInfo", countAppTSInfo);
		model.addAttribute("countCampaignDetails", countCampaignDetails);
		model.addAttribute("countSwitchingCampaign", countSwitchingCampaign);
		model.addAttribute("countOperator", countOperator);
		model.addAttribute("countTerritory", countTerritory);
		model.addAttribute("countPromoter", countPromoter);
		model.addAttribute("countPartner", countPartner);
		return index;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/viewAppTrafficServiceInfo")
	public ModelAndView viewAppTrafficServiceInfo() {
		ModelAndView viewAppTrafficServiceInfo = new ModelAndView("viewAppTrafficServiceInfo");
		List<AppTrafficServiceInfo> appTrafficServiceInfoList = appTrafficServiceInfoService
				.listAllAppTrafficServiceInfo();
		for (AppTrafficServiceInfo appTrafficServiceInfo : appTrafficServiceInfoList) {
			Operator operator = operatorService.getOperator(Integer.parseInt(appTrafficServiceInfo.getOperatorid()));
			Territory territory = territoryService.getTerritory(operator.getTerritoryid());
			appTrafficServiceInfo.setTerritory(territory.getName());
			appTrafficServiceInfo.setOperator(operator.getName());
		}
		viewAppTrafficServiceInfo.addObject("appTrafficServiceInfoList", appTrafficServiceInfoList);
		return viewAppTrafficServiceInfo;
	}

	@RequestMapping(value = "/editAppTrafficServiceInfo")
	public ModelAndView editAppTrafficServiceInfo(HttpServletRequest request) {
		ModelAndView editAppTrafficServiceInfo = new ModelAndView("editAppTrafficServiceInfo");
		AppTrafficServiceInfo appTrafficServiceInfo = appTrafficServiceInfoService
				.getAppTrafficServiceInfo(Integer.parseInt(request.getParameter("appId")));
		String territoryName = request.getParameter("territoryName");
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Promoter> promoterList = promoterService.listAllPromoter();
		editAppTrafficServiceInfo.addObject("territoryList", territoryList);
		editAppTrafficServiceInfo.addObject("promoterList", promoterList);
		editAppTrafficServiceInfo.addObject("appTrafficServiceInfo", appTrafficServiceInfo);
		editAppTrafficServiceInfo.addObject("territoryName",territoryName);
		return editAppTrafficServiceInfo;
	}

	@RequestMapping(value = "/addAppTrafficServiceInfo")
	public ModelAndView addAppTrafficServiceInfo() {
		ModelAndView addAppTrafficServiceInfo = new ModelAndView("addAppTrafficServiceInfo");
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Promoter> promoterList = promoterService.listAllPromoter();
		addAppTrafficServiceInfo.addObject("territoryList", territoryList);
		addAppTrafficServiceInfo.addObject("promoterList", promoterList);
		return addAppTrafficServiceInfo;
	}

	@RequestMapping(value = "/viewOperator")
	public ModelAndView viewOperator() {
		ModelAndView viewOperator = new ModelAndView("viewOperator");
		List<Operator> operatorList = operatorService.listAllOperator();
		for (Operator operator : operatorList) {
			Territory territory = territoryService.getTerritory(operator.getTerritoryid());
			operator.setTerritory(territory.getName());
		}
		viewOperator.addObject("operatorList", operatorList);
		return viewOperator;
	}

	@RequestMapping(value = "/editOperator")
	public ModelAndView editOperator(HttpServletRequest request) {
		ModelAndView editOperator = new ModelAndView("editOperator");
		Operator operator = operatorService.getOperator(Integer.parseInt(request.getParameter("operatorId")));
		List<Territory> territoryList = territoryService.listAllTerritory();
		editOperator.addObject("operator", operator);
		editOperator.addObject("territoryList", territoryList);
		return editOperator;
	}

	@RequestMapping(value = "/addOperator")
	public ModelAndView addOperator() {
		ModelAndView addOperator = new ModelAndView("addOperator");
		List<Territory> territoryList = territoryService.listAllTerritory();
		addOperator.addObject("territoryList", territoryList);
		return addOperator;
	}

	@RequestMapping(value = "/viewTerritory")
	public ModelAndView viewTerritory() {
		ModelAndView viewTerritory = new ModelAndView("viewTerritory");
		List<Territory> territoryList = territoryService.listAllTerritory();
		viewTerritory.addObject("territoryList", territoryList);
		return viewTerritory;
	}

	@RequestMapping(value = "/editTerritory")
	public ModelAndView editTerritory(HttpServletRequest request) {
		ModelAndView editTerritory = new ModelAndView("editTerritory");
		Territory territory = territoryService.getTerritory(Integer.parseInt(request.getParameter("territoryId")));
		editTerritory.addObject("territory", territory);
		return editTerritory;
	}

	@RequestMapping(value = "/addTerritory")
	public ModelAndView addTerritory() {
		return new ModelAndView("addTerritory");
	}

	@RequestMapping(value = "/viewPromoter")
	public ModelAndView viewPromoter() {
		ModelAndView viewPromoter = new ModelAndView("viewPromoter");
		List<Promoter> promoterList = promoterService.listAllPromoter();
		viewPromoter.addObject("promoterList", promoterList);
		return viewPromoter;
	}

	@RequestMapping(value = "/editPromoter")
	public ModelAndView editPromoter(HttpServletRequest request) {
		ModelAndView editPromoter = new ModelAndView("editPromoter");
		Promoter promoter = promoterService.getPromoter(Integer.parseInt(request.getParameter("promoterId")));
		editPromoter.addObject("promoter", promoter);
		return editPromoter;
	}

	@RequestMapping(value = "/addPromoter")
	public ModelAndView addPromoter() {
		return new ModelAndView("addPromoter");
	}

	@RequestMapping(value = "/viewPartner")
	public ModelAndView viewPartner() {
		ModelAndView viewPartner = new ModelAndView("viewPartner");
		List<Partner> partnerList = partnerService.listAllPartner();
		viewPartner.addObject("partnerList", partnerList);
		return viewPartner;
	}

	@RequestMapping(value = "/editPartner")
	public ModelAndView editPartner(HttpServletRequest request) {
		ModelAndView editPartner = new ModelAndView("editPartner");
		Partner partner = partnerService.getPartner(Integer.parseInt(request.getParameter("partnerId")));
		editPartner.addObject("partner", partner);
		return editPartner;
	}

	@RequestMapping(value = "/addPartner")
	public ModelAndView addPartner() {
		return new ModelAndView("addPartner");
	}

	@RequestMapping(value = "/viewAppCampaignDetails")
	public ModelAndView viewAppCampaignDetails() {
		ModelAndView viewAppCampaignDetails = new ModelAndView("viewAppCampaignDetails");
		List<AppCampaignDetails> appCampaignDetailsList = appCampaignDetailsService.listAllAppCampaignDetails();
		for (AppCampaignDetails appCampaignDetails : appCampaignDetailsList) {
			Territory territory = territoryService.getTerritory(appCampaignDetails.getTerritoryid());
			Operator operator = operatorService.getOperator(Integer.parseInt(appCampaignDetails.getOperatorid()));
			Partner partner = partnerService.getPartner(appCampaignDetails.getPartnerid());
			appCampaignDetails.setPartner(partner.getName());
			appCampaignDetails.setOperator(operator.getName());
			appCampaignDetails.setTerritory(territory.getName());
		}
		viewAppCampaignDetails.addObject("appCampaignDetailsList", appCampaignDetailsList);
		return viewAppCampaignDetails;
	}

	@RequestMapping(value = "/editAppCampaignDetails")
	public ModelAndView editAppCampaignDetails(HttpServletRequest request) {
		ModelAndView editAppCampaignDetails = new ModelAndView("editAppCampaignDetails");
		AppCampaignDetails appCampaignDetails = appCampaignDetailsService
				.getAppCampaignDetails(Integer.parseInt(request.getParameter("appCampaignId")));
		List<Partner> partnerList = partnerService.listAllPartner();
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Operator> operatorList = operatorService.listAllOperator();
		editAppCampaignDetails.addObject("operatorList", operatorList);
		editAppCampaignDetails.addObject("partnerList", partnerList);
		editAppCampaignDetails.addObject("territoryList", territoryList);
		editAppCampaignDetails.addObject("appCampaignDetails", appCampaignDetails);
		return editAppCampaignDetails;
	}

	@RequestMapping(value = "/addAppCampaignDetails")
	public ModelAndView addAppCampaignDetails() {
		ModelAndView addAppCampaignDetails = new ModelAndView("addAppCampaignDetails");
		List<Partner> partnerList = partnerService.listAllPartner();
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Operator> operatorList = operatorService.listAllOperator();
		addAppCampaignDetails.addObject("operatorList", operatorList);
		addAppCampaignDetails.addObject("partnerList", partnerList);
		addAppCampaignDetails.addObject("territoryList", territoryList);
		return addAppCampaignDetails;
	}

	@RequestMapping(value = "/viewDetails")
	public ModelAndView viewExcelReport(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("viewATSInfo");
		int id = Integer.parseInt(request.getParameter("viewId"));
		AppTrafficServiceInfo appTrafficServiceInfo = appTrafficServiceInfoService.getAppTrafficServiceInfo(id);
		Operator operator = operatorService.getOperator(Integer.parseInt(appTrafficServiceInfo.getOperatorid()));
		Territory territory = territoryService.getTerritory(operator.getTerritoryid());
		AppCampaignDetails appCampaignDetails = appCampaignDetailsService.getCampaignDetails(
				Integer.parseInt(appTrafficServiceInfo.getOperatorid()), appTrafficServiceInfo.getPartnerid(),
				operator.getTerritoryid());
		ExcelData excelData = new ExcelData();
		excelData.setId(appTrafficServiceInfo.getId());
		excelData.setPromoterName(appTrafficServiceInfo.getPromoterName());
		excelData.setCampaign_name(appCampaignDetails.getCampaign_name());
		excelData.setCountry_name(territory.getName());
		excelData.setOperator_name(operator.getName());
		excelData.setSub_sc(appCampaignDetails.getShortcode());
		excelData.setUnsub_sc(appCampaignDetails.getShortcode());
		excelData.setKeyword(appCampaignDetails.getKeyword());
		excelData.setPinlength(appCampaignDetails.getPinlength());
		excelData.setPrice(appCampaignDetails.getPrice());
		excelData.setValidity(appCampaignDetails.getValidity());
		modelAndView.addObject("dataList", excelData);
		return modelAndView;
	}

	@RequestMapping(value = "/viewSwitchingCampaign")
	public ModelAndView viewSwitchingCampaign() {
		ModelAndView viewSwitchingCampaign = new ModelAndView("viewSwitchingCampaign");
		List<SwitchingCampaign> switchingCampaignList = switchingCampaignService.listAllSwitchingCampaign();
		viewSwitchingCampaign.addObject("switchingCampaignList", switchingCampaignList);
		return viewSwitchingCampaign;
	}

	@RequestMapping(value = "/addSwitchingCampaign")
	public ModelAndView addSwitchingCampaign() {
		ModelAndView addSwitchingCampaign = new ModelAndView("addSwitchingCampaign");
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Promoter> promoterList = promoterService.listAllPromoter();
		addSwitchingCampaign.addObject("territoryList", territoryList);
		addSwitchingCampaign.addObject("promoterList", promoterList);
		return addSwitchingCampaign;
	}

	@RequestMapping(value = "/editSwitchingCampaign")
	public ModelAndView editSwitchingCampaign(HttpServletRequest request) {
		ModelAndView editSwitchingCampaign = new ModelAndView("editSwitchingCampaign");
		SwitchingCampaign switchingCampaign = switchingCampaignService
				.getSwitchingCampaign(Integer.parseInt(request.getParameter("switchingCampaignId")));
		int operatorId = Integer.parseInt(switchingCampaign.getOperatorid());
		Operator operator = operatorService.getOperator(operatorId);
		int appTSId1 = Integer.parseInt(switchingCampaign.getSwitchingCampId());
		AppTrafficServiceInfo appTrafficServiceInfo = appTrafficServiceInfoService.getAppTrafficServiceInfo(appTSId1);
		String promoterName = appTrafficServiceInfo.getPromoterName();
		List<Promoter> promoterList = promoterService.listAllPromoter();
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Operator> operatorList = operatorService.listAllOperator();
		editSwitchingCampaign.addObject("operatorList", operatorList);
		editSwitchingCampaign.addObject("promoterList", promoterList);
		editSwitchingCampaign.addObject("territoryList", territoryList);
		editSwitchingCampaign.addObject("switchingCampaign", switchingCampaign);
		editSwitchingCampaign.addObject("operator", operator);
		editSwitchingCampaign.addObject("promoterName", promoterName);
		return editSwitchingCampaign;
	}
}