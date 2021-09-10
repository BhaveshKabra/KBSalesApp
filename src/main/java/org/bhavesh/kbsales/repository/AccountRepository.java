package org.bhavesh.kbsales.repository;

import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>
{
	@Query(value="select a.name from Account a")
	public List<String> getAllAccountsName();
	
	public Optional<Account> findByName(String name);

	public Optional<Account> findByNameAndCity(String name, String city);
}
