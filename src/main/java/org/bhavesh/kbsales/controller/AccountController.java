package org.bhavesh.kbsales.controller;

import org.bhavesh.kbsales.bean.Account;
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
	public String getinsertPage()
	{
		return "account/insertnewaccounts";
	}
	
	@PostMapping("/accounts/insert")
	public String insertAccounts(@ModelAttribute("account") Account account,Model model,BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error",result.getAllErrors());
			return "/accounts/insert";
		}
		else
		{
			accountService.insertAccount(account);
			return "redirect:";
		}
	}
	
	@RequestMapping("/accounts/view/{accountid}")
	public String getAllAccounts(@PathVariable("accountid")String accountid,Model model)
	{
		model.addAttribute("account",accountService.getAccount(accountid));
		return "account/getaccount";
	}
}
