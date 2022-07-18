package org.bhavesh.kbsales.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.bhavesh.kbsales.service.AccountService;
import org.bhavesh.kbsales.service.SaudaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaudaController {
	
	private static final String INSERTSAUDAURL="sauda/insert";
	private static final String SAUDABYSTARTANDENDDATE="sauda/getbystartandenddates";
	private static final String SAUDABYCREATEDDATE="sauda/getbycreateddate";
	private static final String SAUDABYPARTANDDATE="sauda/bypartydate";
	
	private static final String SAUDAATTRIBUTE="sauda";
	private static final String SAUDALISTATTRIBUTE="saudaList";
	private static final String ACCOUNTLISTATTRIBUTE="AccountsNames";
	private static final String ERRORATTRIBUTE="error";
	
	@Autowired
	private SaudaService saudaService;
	@Autowired
	private AccountService accountService;
	Logger logger;
	
	public SaudaController(final SaudaService saudaService,final AccountService accountService) {
		this.saudaService=saudaService;
		this.accountService=accountService;
		this.logger=LoggerFactory.getLogger(SaudaController.class);
	}
	
	/*
	 * find Sauda by ID 
	 */
	@GetMapping("/sauda/id/{saudaid}")
	public String getSauda(@PathVariable("saudaid") long saudaid, Model model)
	{
		logger.debug("saudaid is {}",saudaid);
		model.addAttribute(SAUDAATTRIBUTE,saudaService.getSaudabyid(saudaid));
		return "sauda/getsauda";
	}
	
	/*
	 * Add Sauda to DB 
	 */
	@GetMapping(INSERTSAUDAURL)
	public String insertSauda(Model model)
	{
		model.addAttribute(SAUDAATTRIBUTE,new SaudaPOJO());
		List<AccountPOJO> listAccountNames= accountService.getAllAccount();
		model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
		return INSERTSAUDAURL;
	}
	@PostMapping(INSERTSAUDAURL)
	public String postSauda(@Valid @ModelAttribute(SAUDAATTRIBUTE) SaudaPOJO saudaPOJO,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute(ERRORATTRIBUTE,result.getAllErrors());
			List<AccountPOJO> listAccountNames= accountService.getAllAccount();
			model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
			return INSERTSAUDAURL;
		}
		else
		{
			saudaService.insertSauda(saudaPOJO);
			return "redirect:";
		}
	}
	
	
	/*
	 * Gets the Sauda based on Start Date and End Date 
	 */
	@GetMapping("/sauda/dates")
	public String getSaudasby2Dates(Model model)
	{
		model.addAttribute(SAUDALISTATTRIBUTE,new ArrayList<SaudaPOJO>());
		return SAUDABYSTARTANDENDDATE;
	}
	@PostMapping("/sauda/dates")
	public String postSaudasby2Dates(Model model,@RequestParam("saudaStartDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate
												,@RequestParam("saudaEndDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate)
	{
		if(startDate!=null && endDate!=null)
		{
			model.addAttribute(SAUDALISTATTRIBUTE,saudaService.getSaudabyStartDateandEndDateRange(startDate.minusDays(1), endDate.plusDays(1)));
			return SAUDABYSTARTANDENDDATE;
		}
		return "redirect:/sauda/dates";
	}
	
	/*
	 * Gets the Sauda based on Created Date 
	 */
	@GetMapping("/sauda/date")
	public String getSaudasbyDate(Model model)
	{
		model.addAttribute(SAUDALISTATTRIBUTE,new ArrayList<SaudaPOJO>());
		return SAUDABYCREATEDDATE;
	}
	@PostMapping("/sauda/date")
	public String postSaudasbyDate(Model model,@RequestParam("saudaCreatedDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saudaCreatedDate)
	{
		if(saudaCreatedDate!=null)
		{
			logger.info("Date is {}",saudaCreatedDate);
			model.addAttribute(SAUDALISTATTRIBUTE,saudaService.getSaudabyCreationDate(saudaCreatedDate));
			return SAUDABYCREATEDDATE;
		}
		return "redirect:/sauda/date";
		
	}
	/*
	 * Gets the Sauda based on Todays Date 
	 */
	@GetMapping("/sauda/todaydate")
	public String getSaudasbyTodayDate(Model model)
	{
		LocalDate  now = LocalDate.now();
		logger.info("Date is {}",now);
		model.addAttribute(SAUDALISTATTRIBUTE,saudaService.getSaudabyCreationDate(now));
		return "sauda/getbytodaydate";
	}
	
	/*
	 * Updates Sauda
	 */
	@GetMapping("/sauda/id/{saudaid}/update")
	public String getupdateSaudaPage(@PathVariable("saudaid") long saudaid, Model model)
	{
		model.addAttribute(SAUDAATTRIBUTE,saudaService.getSaudabyid(saudaid));
		return "sauda/update";
	}
	@PostMapping("/sauda/id/{saudaid}/update")
	public String postupdateSauda(@PathVariable("saudaid") long saudaid, @Valid @ModelAttribute(SAUDAATTRIBUTE) SaudaPOJO sauda,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute(ERRORATTRIBUTE,result.getAllErrors());
			List<String> listAccountNames= accountService.getAllAccountsName();
			model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
			return "/sauda/update";
		}
		else
		{
			saudaService.updateSauda(saudaid,sauda);
			return "redirect:sauda/id/"+saudaid;
		}
	}
	
	/*
	 * findSaudaByParty 
	 */
	@GetMapping("/sauda/partyanddate")
	public String getSaudasbyPartyandDate(Model model)
	{
		model.addAttribute(SAUDALISTATTRIBUTE,new ArrayList<SaudaPOJO>());
		List<String> listAccountNames= accountService.getAllAccountsName();
		model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
		return SAUDABYPARTANDDATE;
	}
	@PostMapping("/sauda/partyanddate")
	public String postSaudasbyPartyandDate(@Valid @ModelAttribute("account")AccountPOJO account,BindingResult result
											,@RequestParam("saudaStartDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate
											,@RequestParam("saudaEndDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate
											,Model model)
	{
		if(startDate!=null && endDate!=null && !result.hasErrors())
		{
			model.addAttribute(SAUDALISTATTRIBUTE,saudaService.getSaudabyAccountwithRange(startDate, endDate,account));
			List<String> listAccountNames= accountService.getAllAccountsName();
			model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
			return SAUDABYPARTANDDATE;
		}
		model.addAttribute(ERRORATTRIBUTE,result.getAllErrors());
		List<String> listAccountNames= accountService.getAllAccountsName();
		model.addAttribute(ACCOUNTLISTATTRIBUTE,listAccountNames);
		return "redirect:/sauda/partyanddate";
		
	}
	@PostMapping("/sauda/id/{saudaid}/delete")
	public String deleteAccount(@PathVariable("saudaid") long saudaid,Model model)
	{
		SaudaPOJO sauda=saudaService.getSaudabyid(saudaid);
		saudaService.deleteSauda(sauda);
		return "redirect:/accounts";
	}
}
