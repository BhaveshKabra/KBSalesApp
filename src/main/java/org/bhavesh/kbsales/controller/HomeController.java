package org.bhavesh.kbsales.controller;

import org.bhavesh.kbsales.service.SaudaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	SaudaService saudaService;
	
	public HomeController(SaudaService saudaService) {
		this.saudaService = saudaService;
	}

	@RequestMapping("")
	public String showHomePage()
	{
		return "Home";
	}
}
