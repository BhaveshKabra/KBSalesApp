package org.bhavesh.kbsales.controller;

import javax.validation.Valid;

import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	
	AccountService accountService;
	public static final String ACCOUNT="account";
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
	}
	
	@RequestMapping("/accounts")
	public String getAllAccounts(Model model)
	{
		model.addAttribute("accountlist",accountService.getAllAccount());
		return "account/getallaccounts";
	}
	
	@GetMapping("/accounts/insert")
	public String getinsertPage(Model model)
	{
		model.addAttribute(ACCOUNT, new AccountPOJO());
		return "account/insertnewaccounts";
	}
	
	@GetMapping("/accounts/{accountid}/update")
	public String showupdatepage(@PathVariable("accountid")String accountid,Model model)
	{
		model.addAttribute("pageTitle","Update "+accountid+" Details");
		model.addAttribute(ACCOUNT,accountService.getAccount(accountid));
		return "account/updateaccount";
	}
	
	@PostMapping("/accounts/insert")
	public String insertAccounts(@Valid @ModelAttribute(ACCOUNT) AccountPOJO accountpojo,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error",result.getAllErrors());
			return "account/insertnewaccounts";
		}
		else
		{
			accountService.insertAccount(accountpojo);
			return "redirect:";
		}
	}
	
	@PostMapping("/accounts/{accountid}/update/")
	public String updateAccounts(@Valid @ModelAttribute("account") AccountPOJO accountpojo,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error",result.getAllErrors());
			return "account/updateaccount";
		}
		else
		{
			accountService.insertAccount(accountpojo);
			return "redirect:/accounts/"+accountpojo.getName()+"/";
		}
	}
	
	@RequestMapping("/accounts/{accountid}")
	public String getAllAccounts(@PathVariable("accountid")String accountid,Model model)
	{
		model.addAttribute("pageTitle",accountid+" Details");
		model.addAttribute(ACCOUNT,accountService.getAccount(accountid));
		return "account/getaccount";
	}
}
