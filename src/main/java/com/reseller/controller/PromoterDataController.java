package com.reseller.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reseller.model.Promoter;
import com.reseller.service.PromoterService;

@Controller
public class PromoterDataController {
	
	@Autowired
	private PromoterService promoterService;
	
	@GetMapping("/insertPromoter")
	public String insertPromoter(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Promoter promoter = new Promoter();
		promoter.setName(request.getParameter("name"));
		promoter.setAddtime(LocalDateTime.now());
		promoter.setEdittime(LocalDateTime.now());
		promoter.setInitials(request.getParameter("initials").toUpperCase());
		promoterService.insertPromoter(promoter);
		redirectAttributes.addFlashAttribute("alertMessage", "Record added successfully.");
		return "redirect:/viewPromoter";
	}
	
	@GetMapping("/updatePromoter")
	public String updatePromoter(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Promoter promoter = new Promoter();
		promoter.setId(Integer.parseInt(request.getParameter("id")));
		promoter.setName(request.getParameter("name"));
		promoter.setAddtime(LocalDateTime.parse(request.getParameter("addtime")));
		promoter.setEdittime(LocalDateTime.now());
		promoter.setInitials(request.getParameter("initials").toUpperCase());
		promoterService.updatePromoter(promoter);
		redirectAttributes.addFlashAttribute("alertMessage", "Record updated successfully.");
		return "redirect:/viewPromoter";
	}
}
