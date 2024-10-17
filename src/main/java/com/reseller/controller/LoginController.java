package com.reseller.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reseller.model.User;
import com.reseller.service.AppCampaignDetailsService;
import com.reseller.service.AppTrafficServiceInfoService;
import com.reseller.service.OperatorService;
import com.reseller.service.PartnerService;
import com.reseller.service.PromoterService;
import com.reseller.service.SwitchingCampaignService;
import com.reseller.service.TerritoryService;
import com.reseller.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "/registerUser")
	public ModelAndView registerUser(HttpServletRequest request, Model model) {
		User user = new User();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		userService.insertUser(user);
		userService.insertAuthority(username);
		model.addAttribute("registerMessage", "User registered successfully. Kindly log in.");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login-success")
	public ModelAndView loginSuccess(Model model) {
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
		model.addAttribute("alertMessage", "Logged in successfully.");
		return index;
	}

	@RequestMapping(value = "/login-failure")
	public String loginFailure(Model model) {
		model.addAttribute("alertMessage", "Invalid user credentials.");
		return "login";
	}
}
