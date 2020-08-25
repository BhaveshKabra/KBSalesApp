package org.bhavesh.kbsales.controller;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.service.SaudaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SaudaController {
	
	SaudaService saudaService;

	public SaudaController(SaudaService saudaService) {
		this.saudaService = saudaService;
	}
	public static final String SAUDA="sauda";
	
	
	@GetMapping("/sauda/insert")
	public String insertSauda(Model model)
	{
		model.addAttribute(SAUDA,new Sauda());
		return "sauda/insertsauda";
	}
	
	@GetMapping("/sauda/{saudaid}/")
	public String getSauda(@PathVariable("saudaid") Long saudaid, Model model)
	{
		model.addAttribute(SAUDA,saudaService.getSaudabyid(saudaid));
		return "sauda/insertsauda";
	}
	
	@GetMapping("/sauda/{saudaid}/update")
	public String updateSauda(@PathVariable("saudaid") long saudaid, Model model)
	{
		model.addAttribute(SAUDA,saudaService.getSaudabyid(saudaid));
		return "sauda/updatesauda";
	}

}
