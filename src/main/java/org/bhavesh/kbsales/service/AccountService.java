package org.bhavesh.kbsales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	AccountRepository accountrepo;
	
	public AccountService(AccountRepository accountrepo)
	{
		this.accountrepo=accountrepo;
	}
	
	public Account getAccount(String accountname)
	{
		Optional<Account> optAccount=accountrepo.findById(accountname);
		if(optAccount.isPresent())
			return optAccount.get();
		else
			return null;
	}
	
	public List<Account> getAllAccount()
	{
		ArrayList<Account> listAccount= new ArrayList<Account>();
		for(Account account: accountrepo.findAll())
		{
			listAccount.add(account);
		}
		return listAccount;
	}
	public List<Account> getAccountbyCity(String city)
	{
		ArrayList<Account> listAccount= new ArrayList<Account>();
		for(Account account: accountrepo.findAll())
		{
			if(city.equals(account.getCity()))
			{
				listAccount.add(account);
			}
		}
		return listAccount;
	}
}
