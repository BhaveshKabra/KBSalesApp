package org.bhavesh.kbsales.repository;

import java.util.List;

import org.bhavesh.kbsales.bean.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>
{
	@Query(value="select a.name from Account a")
	public List<String> getAllAccountsName();
}
