package org.bhavesh.kbsales.bean.converter;

import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.bhavesh.kbsales.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class StringToAccountConverter implements Converter<String, AccountPOJO> {

	AccountService accountService;
	AccountMapper accountMapper;
	Logger logger;
	public StringToAccountConverter(AccountService accountService,AccountMapper accountMapper) {
		this.accountService=accountService;
		this.accountMapper=accountMapper;
		this.logger=LoggerFactory.getLogger(StringToAccountConverter.class);
	}
	
	@Override
	public AccountPOJO convert(String source) {
		logger.info("Convert called with soruce: {}",source);
		return accountService.getAccount(source);
	}

}
