package com.reseller.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reseller.model.Partner;
import com.reseller.service.PartnerService;

@Controller
public class PartnerDataController {

	@Autowired
	PartnerService partnerService;

	@GetMapping("/insertPartner")
	public String insertPartner(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Partner partner = new Partner();
		partner.setName(request.getParameter("name"));
		partner.setAddtime(LocalDateTime.now());
		partner.setEdittime(LocalDateTime.now());
		partner.setInitials(request.getParameter("initials").toUpperCase());
		partnerService.insertPartner(partner);
		redirectAttributes.addFlashAttribute("alertMessage", "Record added successfully.");
		return "redirect:/viewPartner";
	}

	@GetMapping("/updatePartner")
	public String updatePartner(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Partner partner = new Partner();
		partner.setId(Integer.parseInt(request.getParameter("id")));
		partner.setName(request.getParameter("name"));
		partner.setAddtime(LocalDateTime.parse(request.getParameter("addtime")));
		partner.setEdittime(LocalDateTime.now());
		partner.setInitials(request.getParameter("initials").toUpperCase());
		partnerService.updatePartner(partner);
		redirectAttributes.addFlashAttribute("alertMessage", "Record updated successfully.");
		return "redirect:/viewPartner";
	}
}
