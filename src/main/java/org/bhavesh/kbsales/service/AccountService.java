package org.bhavesh.kbsales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.bhavesh.kbsales.repository.AccountRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	int pagesize = 20;
	int maxsize=0;
	public AccountPOJO getAccount(String accountname)
	{
		Optional<Account> optAccount=accountrepo.findByName(accountname);
		if(optAccount.isPresent())
			return mapper.accounttoAccountPojo(optAccount.get());
		else
			return null;
	}
	public AccountPOJO getAccount(long id)
	{
		Optional<Account> optAccount=accountrepo.findById(id);
		if(optAccount.isPresent())
			return mapper.accounttoAccountPojo(optAccount.get());
		else
			return null;
	}
	public List<AccountPOJO> getAllAccount(int pageno,Sort sort)
	{
		ArrayList<AccountPOJO> listAccountpojo= new ArrayList<AccountPOJO>();
		PageRequest page=PageRequest.of(pageno,pagesize,sort);
		for(Account account: accountrepo.findAll(page))
		{
			listAccountpojo.add(mapper.accounttoAccountPojo(account));
		}
		return listAccountpojo;
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
	public long getSize()
	{
		return Math.round(Math.ceil((accountrepo.count()/(double)pagesize)));
	}
	public AccountPOJO getAccountbyNameandCity(String account, String city) {
		Optional<Account> optAccount=accountrepo.findByNameAndCity(account,city);
		if(optAccount.isPresent())
		{
			return mapper.accounttoAccountPojo(optAccount.get());
		}
		else
		{
			return null;
		}
		
	}
}
