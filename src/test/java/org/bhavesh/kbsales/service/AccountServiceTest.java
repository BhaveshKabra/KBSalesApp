package org.bhavesh.kbsales.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {
	/*
	@Mock
	AccountService accountservice;
	
	static List<Account> listaccount;
	
	public AccountServiceTest() {
		listaccount = new ArrayList<>();
		listaccount.add(Account.builder().name("Testing1").city("DummyCity").build());
		listaccount.add(Account.builder().name("Testing2").city("DummyCity2").build());
	}
	
	@Test
	void saveAccountTest()
	{
		AccountPOJO accountPOJO2= AccountPOJO.builder().name("DummyCity3").city("DummyCity5").build();
		when(accountservice.insertAccount(AccountPOJO accountpojo)).thenReturn(listaccount.add(accountpojo));
		accountservice.insertAccount(accountPOJO2);
		accountservice.getAccount(accountPOJO2.getName());
		assertEquals(accountservice.getAllAccount(),accountmapper.accountlisttoAccountPojolist(listaccount));
	}
	
	@Test
	void getAllResultTest()
	{
		when(accountservice.getAllAccount()).thenReturn(accountmapper.accountlisttoAccountPojolist(listaccount));
		assertEquals(accountservice.getAllAccount(),accountmapper.accountlisttoAccountPojolist(listaccount));
	}
	
	
	void getOneAccountTest() 
	{
		when(accountservice.getAccount("Testing1")).thenReturn(listaccount.stream().filter(account -> account.getName().equals("Testing1")).findFirst().get());
		assertEquals(accountservice.getAllAccount("Testing1"),
	}
	*/
}
