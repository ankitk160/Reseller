package com.reseller.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.reseller.model.AppCampaignDetails;
import com.reseller.model.AppTrafficServiceInfo;
import com.reseller.model.ExcelData;
import com.reseller.model.Operator;
import com.reseller.model.Partner;
import com.reseller.model.Promoter;
import com.reseller.model.Territory;
import com.reseller.service.AppCampaignDetailsService;
import com.reseller.service.AppTrafficServiceInfoService;
import com.reseller.service.OperatorService;
import com.reseller.service.PartnerService;
import com.reseller.service.PromoterService;
import com.reseller.service.TerritoryService;

@Controller
public class AppTrafficServiceInfoDataController {

	@Autowired
	private AppTrafficServiceInfoService appTrafficServiceInfoService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private TerritoryService territoryService;

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private PromoterService promoterService;

	@Autowired
	private AppCampaignDetailsService appCampaignDetailsService;

	@PostMapping("/insertAppTrafficServiceInfo")
	public String insertAppTrafficServiceInfo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		AppTrafficServiceInfo appTrafficServiceInfo = new AppTrafficServiceInfo();
		appTrafficServiceInfo.setAddtime(LocalDateTime.now());
		appTrafficServiceInfo.setEdittime(LocalDateTime.now());
		appTrafficServiceInfo.setOptimizePerc(request.getParameter("optimizePerc"));
		appTrafficServiceInfo.setOptimizeFlag(request.getParameter("optimizeFlag"));
		appTrafficServiceInfo.setAssociationType(request.getParameter("associationType"));
		appTrafficServiceInfo.setPrice(Double.parseDouble(request.getParameter("price")));
		appTrafficServiceInfo.setBidrate(Double.parseDouble(request.getParameter("bidrate")));
		int appCDId = Integer.parseInt(request.getParameter("partnerid"));
		AppCampaignDetails appCampaignDetails = appCampaignDetailsService.getAppCampaignDetails(appCDId);
		int partnerId = appCampaignDetails.getPartnerid();
		Partner partner = partnerService.getPartner(partnerId);
		appTrafficServiceInfo.setPartnerid(partner.getId());
		int promoterId = Integer.parseInt(request.getParameter("PromoterName"));
		Promoter promoter = promoterService.getPromoter(promoterId);
		String promoterName = promoter.getName();
		appTrafficServiceInfo.setPromoterName(promoterName);
		int operatorId = Integer.parseInt(request.getParameter("operatorid"));
		appTrafficServiceInfo.setOperatorid(request.getParameter("operatorid"));
		Operator operator = operatorService.getOperator(operatorId);
		appTrafficServiceInfo.setService(appCampaignDetails.getInitials());
		int territoryId = Integer.parseInt(request.getParameter("territoryid"));
		Territory territory = territoryService.getTerritory(territoryId);
		String serviceName = String.join("_", appTrafficServiceInfo.getService(), territory.getInitials(),
				operator.getInitials(), partner.getInitials(), promoter.getInitials());
		boolean campaignExists = false;
		List<AppTrafficServiceInfo> appTrafficServiceInfoList = appTrafficServiceInfoService
				.listAllAppTrafficServiceInfo();
		Iterator<AppTrafficServiceInfo> iterator = appTrafficServiceInfoList.iterator();
		while (iterator.hasNext()) {
			AppTrafficServiceInfo atsi = iterator.next();
			if (atsi.getPartnerid() == partnerId && atsi.getPromoterName().equals(promoterName)) {
				campaignExists = true;
				break;
			}
		}
		if (campaignExists) {
			redirectAttributes.addFlashAttribute("alertMessage",
					"Campaign already exists. Please choose different Partner or Promoter.");
			return "redirect:/addAppTrafficServiceInfo";
		} else {
			appTrafficServiceInfo.setServicename(serviceName);
			appTrafficServiceInfoService.insertAppTrafficServiceInfo(appTrafficServiceInfo);
			redirectAttributes.addFlashAttribute("successMessage", "Record added successfully.");
			return "redirect:/viewAppTrafficServiceInfo";
		}
	}

	@PostMapping("/updateAppTrafficServiceInfo")
	public String updateAppTrafficServiceInfo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		AppTrafficServiceInfo appTrafficServiceInfo = new AppTrafficServiceInfo();
		appTrafficServiceInfo.setId(Integer.parseInt(request.getParameter("id")));
		appTrafficServiceInfo.setAddtime(LocalDateTime.parse(request.getParameter("addtime")));
		appTrafficServiceInfo.setEdittime(LocalDateTime.now());
		appTrafficServiceInfo.setOptimizePerc(request.getParameter("optimizePerc"));
		appTrafficServiceInfo.setPrice(Double.parseDouble(request.getParameter("price")));
		appTrafficServiceInfo.setBidrate(Double.parseDouble(request.getParameter("bidrate")));
		int appCDId = Integer.parseInt(request.getParameter("partnerid"));
		AppCampaignDetails appCampaignDetails = appCampaignDetailsService.getAppCampaignDetails(appCDId);
		int partnerId = appCampaignDetails.getPartnerid();
		Partner partner = partnerService.getPartner(partnerId);
		appTrafficServiceInfo.setPartnerid(partner.getId());
		int promoterId = Integer.parseInt(request.getParameter("PromoterName"));
		Promoter promoter = promoterService.getPromoter(promoterId);
		String promoterName = promoter.getName();
		appTrafficServiceInfo.setPromoterName(promoterName);
		int operatorId = Integer.parseInt(request.getParameter("operatorid"));
		appTrafficServiceInfo.setOperatorid(request.getParameter("operatorid"));
		Operator operator = operatorService.getOperator(operatorId);
		appTrafficServiceInfo.setService(appCampaignDetails.getInitials());
		int territoryId = Integer.parseInt(request.getParameter("territoryid"));
		Territory territory = territoryService.getTerritory(territoryId);
		String serviceName = String.join("_", appTrafficServiceInfo.getService(), territory.getInitials(),
				operator.getInitials(), partner.getInitials(), promoter.getInitials());
		boolean campaignExists = false;
		List<AppTrafficServiceInfo> appTrafficServiceInfoList = appTrafficServiceInfoService
				.listAllAppTrafficServiceInfo();
		Iterator<AppTrafficServiceInfo> iterator = appTrafficServiceInfoList.iterator();
		while (iterator.hasNext()) {
			AppTrafficServiceInfo atsi = iterator.next();
			if (atsi.getPartnerid() == partnerId && atsi.getPromoterName().equals(promoterName)) {
				campaignExists = true;
				break;
			}
		}
		if (campaignExists) {
			redirectAttributes.addFlashAttribute("alertMessage",
					"Campaign already exists. Please choose different Partner or Promoter.");
			return "redirect:/viewAppTrafficServiceInfo";
		} else {
			appTrafficServiceInfo.setServicename(serviceName);
			appTrafficServiceInfoService.updateAppTrafficServiceInfo(appTrafficServiceInfo);
			redirectAttributes.addFlashAttribute("successMessage", "Record updated successfully.");
			return "redirect:/viewAppTrafficServiceInfo";
		}
	}

	@PostMapping("/duplicateAppTrafficServiceInfo")
	public ModelAndView duplicateAppTrafficServiceInfo(HttpServletRequest request) {
		ModelAndView duplicateAppTrafficServiceInfo = new ModelAndView("duplicateAppTrafficServiceInfo");
		int duplicateId = Integer.parseInt(request.getParameter("appTSId"));
		AppTrafficServiceInfo appTrafficServiceInfo = appTrafficServiceInfoService
				.getAppTrafficServiceInfo(duplicateId);
		List<Territory> territoryList = territoryService.listAllTerritory();
		List<Promoter> promoterList = promoterService.listAllPromoter();
		duplicateAppTrafficServiceInfo.addObject("appTrafficServiceInfo", appTrafficServiceInfo);
		duplicateAppTrafficServiceInfo.addObject("territoryList", territoryList);
		duplicateAppTrafficServiceInfo.addObject("promoterList", promoterList);
		return duplicateAppTrafficServiceInfo;
	}

	@PostMapping("/duplicateATSInfo")
	public String duplicateATSInfo(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		AppTrafficServiceInfo appTrafficServiceInfo = new AppTrafficServiceInfo();
//		int appTSId = Integer.parseInt(request.getParameter("id"));
		appTrafficServiceInfo.setAddtime(LocalDateTime.now());
		appTrafficServiceInfo.setEdittime(LocalDateTime.now());
		appTrafficServiceInfo.setOptimizePerc(request.getParameter("optimizePerc"));
		appTrafficServiceInfo.setOptimizeFlag(request.getParameter("optimizeFlag"));
		appTrafficServiceInfo.setAssociationType(request.getParameter("associationType"));
		appTrafficServiceInfo.setPrice(Double.parseDouble(request.getParameter("price")));
		appTrafficServiceInfo.setBidrate(Double.parseDouble(request.getParameter("bidrate")));
		appTrafficServiceInfo.setPartnerid(Integer.parseInt(request.getParameter("partnerid")));
		int partnerId = Integer.parseInt(request.getParameter("partnerid"));
		String partnerInitials = partnerService.getPartnerById(partnerId);
		int promoterId = Integer.parseInt(request.getParameter("PromoterName"));
		Promoter promoter = promoterService.getPromoter(promoterId);
		String promoterName = promoter.getName();
		appTrafficServiceInfo.setPromoterName(promoterName);
		int operatorId = Integer.parseInt(request.getParameter("operatorid"));
		appTrafficServiceInfo.setOperatorid(request.getParameter("operatorid"));
		Operator operator = operatorService.getOperator(operatorId);
		int territoryId = Integer.parseInt(request.getParameter("territoryid"));
		AppCampaignDetails appCampaignDetails = appCampaignDetailsService.getCampaignDetails(operatorId, partnerId,
				territoryId);
		appTrafficServiceInfo.setService(appCampaignDetails.getInitials());
		Territory territory = territoryService.getTerritory(territoryId);
		String serviceName = String.join("_", appTrafficServiceInfo.getService(), territory.getInitials(),
				operator.getInitials(), partnerInitials, promoter.getInitials());
		boolean campaignExists = false;
		List<AppTrafficServiceInfo> appTrafficServiceInfoList = appTrafficServiceInfoService
				.listAllAppTrafficServiceInfo();
		Iterator<AppTrafficServiceInfo> iterator = appTrafficServiceInfoList.iterator();
		while (iterator.hasNext()) {
			AppTrafficServiceInfo atsi = iterator.next();
			if (atsi.getPartnerid() == partnerId && atsi.getPromoterName().equals(promoterName)) {
				campaignExists = true;
				break;
			}
		}
		if (campaignExists) {
			redirectAttributes.addFlashAttribute("alertMessage",
					"Campaign already exists. Please choose different Partner or Promoter.");
			return "redirect:/viewAppTrafficServiceInfo";
		} else {
			appTrafficServiceInfo.setServicename(serviceName);
			appTrafficServiceInfoService.insertAppTrafficServiceInfo(appTrafficServiceInfo);
			redirectAttributes.addFlashAttribute("successMessage", "Record added successfully.");
			return "redirect:/viewAppTrafficServiceInfo";
		}
	}

	@PostMapping("/excelReportDownload")
	public void excelReportDownload(HttpServletResponse response, HttpServletRequest request) throws IOException {
		int id = Integer.parseInt(request.getParameter("excelId"));
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

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("AppServiceInfoId");
		headerRow.createCell(1).setCellValue("PromoterName");
		headerRow.createCell(2).setCellValue("ServiceName");
		headerRow.createCell(3).setCellValue("Country");
		headerRow.createCell(4).setCellValue("Operator");
		headerRow.createCell(5).setCellValue("SUB SC");
		headerRow.createCell(6).setCellValue("UNSUB SC");
		headerRow.createCell(7).setCellValue("UNSUB KW");
		headerRow.createCell(8).setCellValue("PinLength");
		headerRow.createCell(9).setCellValue("Price");
		headerRow.createCell(10).setCellValue("Validity");

		Row row = sheet.createRow(1);
		row.createCell(0).setCellValue(excelData.getId());
		row.createCell(1).setCellValue(excelData.getPromoterName());
		row.createCell(2).setCellValue(excelData.getCampaign_name());
		row.createCell(3).setCellValue(excelData.getCountry_name());
		row.createCell(4).setCellValue(excelData.getOperator_name());
		row.createCell(5).setCellValue(excelData.getSub_sc());
		row.createCell(6).setCellValue(excelData.getUnsub_sc());
		row.createCell(7).setCellValue(excelData.getKeyword());
		row.createCell(8).setCellValue(excelData.getPinlength());
		row.createCell(9).setCellValue(excelData.getPrice());
		row.createCell(10).setCellValue(excelData.getValidity());

		String excelName = String.join("_", excelData.getCampaign_name(), String.valueOf(excelData.getId()),
				excelData.getCountry_name(), excelData.getOperator_name(), excelData.getPromoterName());

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=" + excelName + ".xlsx");

		try (OutputStream outputStream = response.getOutputStream()) {
			workbook.write(outputStream);
		}
		workbook.close();
	}

	@ResponseBody
	@PostMapping("/getATSInfoByIds")
	public String getATSInfoByIds(@RequestParam("operatorid") String operatorid,
			@RequestParam("PromoterName") String PromoterName) throws JsonProcessingException {
		int operatorId = Integer.parseInt(operatorid);
		List<AppTrafficServiceInfo> appTrafficServiceInfos = appTrafficServiceInfoService.getATSInfoByIds(operatorId,
				PromoterName);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String jsonString = objectMapper.writeValueAsString(appTrafficServiceInfos);
		return jsonString;
	}
}
