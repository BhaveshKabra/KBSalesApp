package org.bhavesh.kbsales.config;

import java.util.Date;

import org.bhavesh.kbsales.bean.converter.StringToAccountConverter;
import org.bhavesh.kbsales.bean.converter.StringToDateConverter;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.bhavesh.kbsales.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	AccountService accountService;
	AccountMapper accountMapper;
	Logger logger;
	
	public WebConfig(AccountService accountService,AccountMapper accountMapper)
	{
		this.accountService=accountService;
		this.accountMapper=accountMapper;
		logger=LoggerFactory.getLogger(WebConfig.class);
	}
	
	@Override
    public void addFormatters(FormatterRegistry registry) {
		logger.info("Included Converter of String to AccountPOJO");
        registry.addConverter(String.class, AccountPOJO.class, new StringToAccountConverter(accountService,accountMapper));
        registry.addConverter(String.class, Date.class, new StringToDateConverter());
    }
	
	
	
}
