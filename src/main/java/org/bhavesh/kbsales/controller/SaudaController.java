package org.bhavesh.kbsales.controller;

import java.util.List;

import javax.validation.Valid;
import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.bhavesh.kbsales.service.AccountService;
import org.bhavesh.kbsales.service.SaudaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaudaController {
	
	SaudaService saudaService;
	AccountService accountService;
	
	public SaudaController(SaudaService saudaService,AccountService accountService) {
		this.saudaService = saudaService;
		this.accountService=accountService;
	}
	public static final String SAUDA="sauda";
	public static final String INSERTSAUDAURL="sauda/insertsauda";
	
	@GetMapping("/sauda/insert")
	public String insertSauda(Model model)
	{
		model.addAttribute(SAUDA,new SaudaPOJO());
		List<String> listAccountNames= accountService.getAllAccountsName();
		model.addAttribute("AccountsNames",listAccountNames);
		return INSERTSAUDAURL;
	}
	
	@GetMapping("/sauda/{saudaid}/")
	public String getSauda(@PathVariable("saudaid") Long saudaid, Model model)
	{
		model.addAttribute(SAUDA,saudaService.getSaudabyid(saudaid));
		return "sauda/getsauda";
	}
	
	@GetMapping("/sauda/{saudaid}/update")
	public String updateSauda(@PathVariable("saudaid") long saudaid, Model model)
	{
		model.addAttribute(SAUDA,saudaService.getSaudabyid(saudaid));
		return "sauda/updatesauda";
	}
	
	@PostMapping("/sauda/insert")
	public String postSauda(@Valid @ModelAttribute(SAUDA) SaudaPOJO saudaPOJO,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error",result.getAllErrors());
			return INSERTSAUDAURL;
		}
		else
		{
			saudaService.insertSauda(saudaPOJO);
			return "redirect:";
		}
	}
}
