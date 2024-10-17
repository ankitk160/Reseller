package com.reseller.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.reseller.model.Operator;
import com.reseller.service.OperatorService;

@Controller
public class OperatorDataController {

	@Autowired
	private OperatorService operatorService;

	@GetMapping("/insertOperator")
	public String insertOperator(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Operator operator = new Operator();
		operator.setName(request.getParameter("name"));
		operator.setAddtime(LocalDateTime.now());
		operator.setEdittime(LocalDateTime.now());
		operator.setTerritoryid(Integer.parseInt(request.getParameter("territoryid")));
		operator.setInitials(request.getParameter("initials").toUpperCase());
		operatorService.insertOperator(operator);
		redirectAttributes.addFlashAttribute("alertMessage", "Record added successfully.");
		return "redirect:/viewOperator";
	}

	@GetMapping("/updateOperator")
	public String updateOperator(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Operator operator = new Operator();
		operator.setId(Integer.parseInt(request.getParameter("id")));
		operator.setName(request.getParameter("name"));
		operator.setAddtime(LocalDateTime.parse((request.getParameter("addtime"))));
		operator.setEdittime(LocalDateTime.now());
		operator.setTerritoryid(Integer.parseInt(request.getParameter("territoryid")));
		operator.setInitials(request.getParameter("initials").toUpperCase());
		operatorService.updateOperator(operator);
		redirectAttributes.addFlashAttribute("alertMessage", "Record updated successfully.");
		return "redirect:/viewOperator";
	}

	@ResponseBody
	@PostMapping("/getOperatorByTerritoryId")
	public String getOperatorByTerritoryId(@RequestBody String selectedTerritoryId) throws JsonProcessingException {
		int id = Integer.parseInt(selectedTerritoryId);
		List<Operator> operatorList = operatorService.getOperatorByTerritoryId(id);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String jsonString = objectMapper.writeValueAsString(operatorList);
		return jsonString;
	}
}
