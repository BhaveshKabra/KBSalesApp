package org.bhavesh.kbsales.controller;

import javax.validation.Valid;

import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.service.AccountService;
import org.springframework.data.domain.Sort;
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
	
	private static final String ACCOUNTLIST = "accountlist";
	AccountService accountService;
	public static final String ACCOUNT="account";
	public AccountController(AccountService accountService) {
		this.accountService=accountService;
	}
	
	@RequestMapping("/accounts/search/")
	public String getAllAccounts(Model model)
	{
		return "redirect:/accounts/search/1";
	}
	
	@RequestMapping("/accounts/search/{pageno}")
	public String getAllAccounts(@PathVariable Integer pageno,Model model)
	{
		if(pageno>0)
		{
			model.addAttribute(ACCOUNTLIST,accountService.getAllAccount(pageno-1,Sort.by("name")));
			model.addAttribute("pageno",pageno);
		}
		else
		{
			model.addAttribute(ACCOUNTLIST,accountService.getAllAccount(0,Sort.by("name")));
			model.addAttribute("pageno",0);
		}
			model.addAttribute("lastpage",accountService.getSize());
			return "account/getallaccounts";
	}
	
	@GetMapping("/accounts/insert")
	public String getinsertPage(Model model)
	{
		model.addAttribute(ACCOUNT, new AccountPOJO());
		return "account/insertnewaccounts";
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
	@GetMapping("/accounts/{accountid}/update")
	public String showupdatepage(@PathVariable("accountid")String accountid,Model model)
	{
		model.addAttribute("pageTitle","Update "+accountid+" Details");
		model.addAttribute(ACCOUNT,accountService.getAccount(accountid));
		return "account/updateaccount";
	}
	@PostMapping("/accounts/{accountid}/update")
	public String updateAccounts(@PathVariable("accountid")String accountid,@Valid @ModelAttribute("account") AccountPOJO accountpojo,BindingResult result,Model model)
	{	
		if(result.hasErrors())
		{
			model.addAttribute("error",result.getAllErrors());
			model.addAttribute(ACCOUNT,accountService.getAccount(accountid));
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
	@PostMapping("/accounts/{accountid}/delete")
	public String deleteAccount(@PathVariable("accountid")String accountid,Model model)
	{
		AccountPOJO account=accountService.getAccount(accountid);
		accountService.deleteAccount(account);
		return "redirect:/accounts";
	}
	
}
