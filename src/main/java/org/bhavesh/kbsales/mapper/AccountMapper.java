package org.bhavesh.kbsales.mapper;

import java.util.List;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
	
	public AccountPOJO accounttoAccountPojo(Account account);
	public Account accountPOJOtoAccount(AccountPOJO accountPOJO);
	public List<AccountPOJO> accountlisttoAccountPojolist(List<Account> account);
	public List<Account> accountPojolisttoAccountlist(List<AccountPOJO> account);
}
