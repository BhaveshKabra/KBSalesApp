package org.bhavesh.kbsales.controller;

import org.bhavesh.kbsales.service.AccountService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "getallaccounts";
	}
	
	@RequestMapping("/accounts/{accountid}")
	public String getAllAccounts(@Param("accountid")String accountid,Model model)
	{
		model.addAttribute("account",accountService.getAccount(accountid));
		return "getaccount";
	}
}
