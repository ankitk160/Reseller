package com.reseller.controller;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reseller.model.Territory;
import com.reseller.service.TerritoryService;

@Controller
public class TerritoryDataController {

	@Autowired
	private TerritoryService territoryService;

	@GetMapping("/insertTerritory")
	public String insertTerritory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Territory territory = new Territory();
		territory.setName(request.getParameter("name"));
		territory.setAddtime(LocalDateTime.now());
		territory.setEdittime(LocalDateTime.now());
		territory.setInitials(request.getParameter("initials").toUpperCase());
		territoryService.insertTerritory(territory);
		redirectAttributes.addFlashAttribute("alertMessage", "Record added successfully.");
		return "redirect:/viewTerritory";
	}

	@GetMapping("/updateTerritory")
	public String updateTerritory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Territory territory = new Territory();
		territory.setId(Integer.parseInt(request.getParameter("id")));
		territory.setName(request.getParameter("name"));
		territory.setAddtime(LocalDateTime.parse((request.getParameter("addtime"))));
		territory.setEdittime(LocalDateTime.now());
		territory.setInitials(request.getParameter("initials").toUpperCase());
		territoryService.updateTerritory(territory);
		redirectAttributes.addFlashAttribute("alertMessage", "Record updated successfully.");
		return "redirect:/viewTerritory";
	}
}
