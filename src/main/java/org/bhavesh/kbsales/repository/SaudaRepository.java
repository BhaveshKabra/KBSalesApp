package org.bhavesh.kbsales.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.bhavesh.kbsales.bean.Account;
import org.bhavesh.kbsales.bean.Sauda;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaudaRepository extends PagingAndSortingRepository<Sauda, Long> {
	
	List<Sauda> findByCreatedDate(LocalDate createdDate);

	List<Sauda> findByBuyerAccount(Account buyerAccount);
	
	List<Sauda> findBySellerAccount(Account sellerAccount);
	
	List<Sauda> findBySaudaEndDate(Date saudaEndDate);
	
	List<Sauda> findBySaudaStartDate(Date saudaStartDate);
	
	List<Sauda> findBySaudaStartDateAfterAndSaudaEndDateBefore(@Param("saudaStartDate") Date saudaStartDate,@Param("saudaEndDate")Date saudaEndDate);
	
	List<Sauda> findBycreatedDateLike(@Param("saudaCreateDate") LocalDate saudaCreateDate);
	
	List<Sauda> findBySaudaStartDateBetween(@Param("from") Date from,@Param("to")Date to);

}
