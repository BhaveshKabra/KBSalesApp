package org.bhavesh.kbsales.repository;

import org.bhavesh.kbsales.bean.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>
{
	
}
