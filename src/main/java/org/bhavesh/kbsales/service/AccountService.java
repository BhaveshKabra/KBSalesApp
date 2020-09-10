package org.bhavesh.kbsales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.bhavesh.kbsales.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService{

	private AccountRepository accountrepo;
	private AccountMapper mapper;
	public AccountService(AccountRepository accountrepo,AccountMapper mapper)
	{
		this.accountrepo=accountrepo;
		this.mapper=mapper;
	}
	
	public AccountPOJO getAccount(String accountname)
	{
		Optional<Account> optAccount=accountrepo.findById(accountname);
		if(optAccount.isPresent())
			return mapper.accounttoAccountPojo(optAccount.get());
		else
			return null;
	}
	
	public List<AccountPOJO> getAllAccount()
	{
		ArrayList<AccountPOJO> listAccountpojo= new ArrayList<AccountPOJO>();
		for(Account account: accountrepo.findAll())
		{
			listAccountpojo.add(mapper.accounttoAccountPojo(account));
		}
		return listAccountpojo;
	}
	
	public List<String> getAllAccountsName()
	{
		ArrayList<String> listAccountNames= new ArrayList<String>();
		for(String str: accountrepo.getAllAccountsName())
		{
			listAccountNames.add(str);
		}
		return listAccountNames;
	}
	public List<AccountPOJO> getAccountbyCity(String city)
	{
		ArrayList<AccountPOJO> listAccountpojo= new ArrayList<AccountPOJO>();
		for(Account account: accountrepo.findAll())
		{
			if(city.equals(account.getCity()))
			{
				listAccountpojo.add(mapper.accounttoAccountPojo(account));
			}
		}
		return listAccountpojo;
	}
	public void insertAccount(AccountPOJO accountpojo)
	{
		accountrepo.save(mapper.accountPOJOtoAccount(accountpojo));
	}
	public void deleteAccount(AccountPOJO accountpojo)
	{
		accountrepo.delete(mapper.accountPOJOtoAccount(accountpojo));
	}
}
