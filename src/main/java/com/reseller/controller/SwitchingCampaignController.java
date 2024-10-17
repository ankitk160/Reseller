package com.reseller.controller;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reseller.model.SwitchingCampaign;
import com.reseller.service.SwitchingCampaignService;

@Controller
public class SwitchingCampaignController {

	@Autowired
	private SwitchingCampaignService switchingCampaignService;

	@PostMapping("/insertSwitchingCampaign")
	public String insertSwitchingCampaign(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String switchBaseCampaignFlag = request.getParameter("switchBaseCampaignFlag");
		String switchCampaignFlag_1 = request.getParameter("switchCampaignFlag_1");
		if (switchBaseCampaignFlag != null) {
			SwitchingCampaign switchingCampaign = new SwitchingCampaign();
			switchingCampaign.setSwitchingName(request.getParameter("switchingName"));
			switchingCampaign.setStatus(0);
			switchingCampaign.setAddtime(LocalDateTime.now());
			switchingCampaign.setEdittime(LocalDateTime.now());
			String switchingCampId = request.getParameter("switchingCampId");
			switchingCampaign.setSwitchingCampId(switchingCampId);
			switchingCampaign.setSwitchingCampCap(Integer.parseInt(request.getParameter("switchingCampCap")));
			String switchingCampId_1 = request.getParameter("switchingCampId_1");
			switchingCampaign.setSwitchingCampId_1(switchingCampId_1);
			switchingCampaign.setSwitchingCampCap_1(Integer.parseInt(request.getParameter("switchingCampCap_1")));
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			switchingCampaign.setCreatedBy(authentication.getName());
			switchingCampaign.setOperatorid(request.getParameter("operatorid"));
			switchingCampaign.setSwitchBaseCampaignFlag(1);
			String switchingCampId_2 = "";
			if (switchCampaignFlag_1 != null) {
				switchingCampId_2 = request.getParameter("switchingCampId_2");
				switchingCampaign.setSwitchingCampId_2(switchingCampId_2);
				switchingCampaign.setSwitchCampaignFlag_1(1);
			} else {
				switchingCampaign.setSwitchingCampId_2("");
				switchingCampaign.setSwitchCampaignFlag_1(0);
			}
			boolean switchingExists = false;
			List<SwitchingCampaign> switchingCampaigns = switchingCampaignService.listAllSwitchingCampaign();
			Iterator<SwitchingCampaign> iterator = switchingCampaigns.iterator();
			while (iterator.hasNext()) {
				SwitchingCampaign campaign = iterator.next();
				if (campaign.getSwitchingCampId().equals(switchingCampId)
						|| campaign.getSwitchingCampId().equals(switchingCampId_1)
						|| campaign.getSwitchingCampId().equals(switchingCampId_2)) {
					switchingExists = true;
					break;
				}
				if (campaign.getSwitchingCampId_1().equals(switchingCampId)
						|| campaign.getSwitchingCampId_1().equals(switchingCampId_1)
						|| campaign.getSwitchingCampId_1().equals(switchingCampId_2)) {
					switchingExists = true;
					break;
				}
				if (campaign.getSwitchingCampId_2().equals(switchingCampId)
						|| campaign.getSwitchingCampId_2().equals(switchingCampId_1)
						|| campaign.getSwitchingCampId_2().equals(switchingCampId_2)) {
					switchingExists = true;
					break;
				}
			}
			if (switchingExists) {
				redirectAttributes.addFlashAttribute("alertMessage",
						"Switching already exists for one of the selected campaign.");
				return "redirect:/addSwitchingCampaign";
			} else {
				switchingCampaignService.insertSwitchingCampaign(switchingCampaign);
				redirectAttributes.addFlashAttribute("successMessage", "Record added successfully.");
				return "redirect:/viewSwitchingCampaign";
			}
		} else {
			redirectAttributes.addFlashAttribute("alertMessage", "Please atleast provide First Level Switching.");
			return "redirect:/viewSwitchingCampaign";
		}
	}

	@PostMapping("/updateSwitchingCampaign")
	public String updateSwitchingCampaign(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String switchBaseCampaignFlag = request.getParameter("switchBaseCampaignFlag");
		String switchCampaignFlag_1 = request.getParameter("switchCampaignFlag_1");
		if (switchBaseCampaignFlag != null) {
			SwitchingCampaign switchingCampaign = new SwitchingCampaign();
			switchingCampaign.setId(Integer.parseInt(request.getParameter("id")));
			switchingCampaign.setSwitchingName(request.getParameter("switchingName"));
			switchingCampaign.setEdittime(LocalDateTime.now());
			switchingCampaign.setSwitchingCampId(request.getParameter("switchingCampId"));
			switchingCampaign.setSwitchingCampCap(Integer.parseInt(request.getParameter("switchingCampCap")));
			switchingCampaign.setSwitchingCampId_1(request.getParameter("switchingCampId_1"));
			switchingCampaign.setSwitchingCampCap_1(Integer.parseInt(request.getParameter("switchingCampCap_1")));
			switchingCampaign.setOperatorid(request.getParameter("operatorid"));
			switchingCampaign.setSwitchBaseCampaignFlag(1);
			if (switchCampaignFlag_1 != null) {
				switchingCampaign.setSwitchingCampId_2(request.getParameter("switchingCampId_2"));
				switchingCampaign.setSwitchCampaignFlag_1(1);
			} else {
				switchingCampaign.setSwitchingCampId_2("");
				switchingCampaign.setSwitchCampaignFlag_1(0);
			}
			switchingCampaignService.updateSwitchingCampaign(switchingCampaign);
			redirectAttributes.addFlashAttribute("successMessage", "Record updated successfully.");
			return "redirect:/viewSwitchingCampaign";
		} else {
			redirectAttributes.addFlashAttribute("alertMessage", "Please atleast provide First Level Switching.");
			return "redirect:/viewSwitchingCampaign";
		}
	}
}
