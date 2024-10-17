package com.reseller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reseller.model.AppCampaignDetails;
import com.reseller.service.AppCampaignDetailsService;

@Controller
public class AppCampaignDetailsController {

	@Autowired
	private AppCampaignDetailsService appCampaignDetailsService;

	@PostMapping("/insertAppCampaignDetails")
	public String insertAppCampaignDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		AppCampaignDetails appCampaignDetails = new AppCampaignDetails();
		appCampaignDetails.setCampaign_name(request.getParameter("campaign_name"));
		String operatorId = request.getParameter("operatorid");
		appCampaignDetails.setOperatorid(operatorId);
		appCampaignDetails.setKeyword(request.getParameter("keyword"));
		appCampaignDetails.setShortcode(request.getParameter("shortcode").toUpperCase());
		appCampaignDetails.setPinlength(Integer.parseInt(request.getParameter("pinlength")));
		appCampaignDetails.setPrice(Double.parseDouble(request.getParameter("price")));
		appCampaignDetails.setValidity(Integer.parseInt(request.getParameter("validity")));
		int partnerId = Integer.parseInt(request.getParameter("partnerid"));
		appCampaignDetails.setPartnerid(partnerId);
		int territoryId = Integer.parseInt(request.getParameter("territoryid"));
		appCampaignDetails.setTerritoryid(territoryId);
		appCampaignDetails.setInitials(request.getParameter("initials").toUpperCase());
		AppCampaignDetails existingCampaign = appCampaignDetailsService.getCampaignDetails(Integer.parseInt(operatorId),
				partnerId, territoryId);
		if (existingCampaign != null) {
			redirectAttributes.addFlashAttribute("alertMessage",
					"Campaign already exists. Choose different Operator or Partner");
			return "redirect:/addAppCampaignDetails";
		} else {
			appCampaignDetailsService.insertAppCampaignDetails(appCampaignDetails);
			redirectAttributes.addFlashAttribute("successMessage", "Record added successfully.");
			return "redirect:/viewAppCampaignDetails";
		}
	}

	@PostMapping("/updateAppCampaignDetails")
	public String updateAppCampaignDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		AppCampaignDetails appCampaignDetails = new AppCampaignDetails();
		appCampaignDetails.setId(Integer.parseInt(request.getParameter("id")));
		appCampaignDetails.setCampaign_name(request.getParameter("campaign_name"));
		String operatorId = request.getParameter("operatorid");
		appCampaignDetails.setOperatorid(operatorId);
		appCampaignDetails.setKeyword(request.getParameter("keyword"));
		appCampaignDetails.setShortcode(request.getParameter("shortcode").toUpperCase());
		appCampaignDetails.setPinlength(Integer.parseInt(request.getParameter("pinlength")));
		appCampaignDetails.setPrice(Double.parseDouble(request.getParameter("price")));
		appCampaignDetails.setValidity(Integer.parseInt(request.getParameter("validity")));
		int partnerId = Integer.parseInt(request.getParameter("partnerid"));
		appCampaignDetails.setPartnerid(partnerId);
		int territoryId = Integer.parseInt(request.getParameter("territoryid"));
		appCampaignDetails.setTerritoryid(territoryId);
		appCampaignDetails.setInitials(request.getParameter("initials").toUpperCase());
		AppCampaignDetails existingCampaign = appCampaignDetailsService.getCampaignDetails(Integer.parseInt(operatorId),
				partnerId, territoryId);
		if (existingCampaign != null) {
			redirectAttributes.addFlashAttribute("alertMessage",
					"Campaign already exists. Choose different Operator or Partner");
			return "redirect:/viewAppCampaignDetails";
		} else {
			appCampaignDetailsService.updateAppCampaignDetails(appCampaignDetails);
			redirectAttributes.addFlashAttribute("successMessage", "Record updated successfully.");
			return "redirect:/viewAppCampaignDetails";
		}
	}

	@ResponseBody
	@PostMapping("/getAppCampaignByOperatorId")
	public String getAppCampaignByOperatorId(@RequestParam("operatorid") String selectedOperatorId)
			throws JsonProcessingException {
		int id = Integer.parseInt(selectedOperatorId);
		List<AppCampaignDetails> appCampaignList = appCampaignDetailsService.getAppCampaignByOperatorId(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(appCampaignList);
		return jsonString;
	}
}
