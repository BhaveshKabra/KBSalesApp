package org.bhavesh.kbsales.repository;

import java.util.Date;
import java.util.List;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.Sauda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaudaRepository extends CrudRepository<Sauda, Long> {
	
	List<Sauda> findByCreatedDate(Date createdDate);

	List<Sauda> findByBuyerAccount(Account buyerAccount);
	
	List<Sauda> findBySellerAccount(Account sellerAccount);
	
	List<Sauda> findBySaudaEndDate(Date saudaEndDate);
	
	List<Sauda> findBySaudaStartDate(Date saudaStartDate);
	
	@Query(value="select s from sauda s where s.saudaStartDate>=:saudaStartDate and s.saudaEndDate<=:saudaEndDate",nativeQuery = true)
	List<Sauda> findBySaudaRange(@Param("saudaStartDate") Date saudaStartDate,@Param("saudaEndDate")Date saudaEndDate);
	
}
