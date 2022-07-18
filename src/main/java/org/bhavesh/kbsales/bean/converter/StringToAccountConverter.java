package org.bhavesh.kbsales.bean.converter;

import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.bhavesh.kbsales.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAccountConverter implements Converter<String, AccountPOJO> {
	@Autowired
	AccountService accountService;
	@Autowired
	AccountMapper accountMapper;
	Logger logger=LoggerFactory.getLogger(StringToAccountConverter.class);
	
	public StringToAccountConverter(AccountService accountService,AccountMapper accountMapper) {
		this.accountService=accountService;
		this.accountMapper=accountMapper;
	}

	@Override
	public AccountPOJO convert(String source) {
		logger.info("Convert called with id: {}",source);
		String account=source.substring(0, source.indexOf('-'));
		String city=source.substring(source.indexOf('-')+1); 
		return accountService.getAccountbyNameandCity(account,city);
	}
}
