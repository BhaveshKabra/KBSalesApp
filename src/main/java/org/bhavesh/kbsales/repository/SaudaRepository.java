package org.bhavesh.kbsales.repository;

import java.util.Date;
import java.util.List;

import org.bhavesh.kbsales.bean.Sauda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaudaRepository extends CrudRepository<Sauda, Integer> {
	
	
	@Query(value="select s from Sauda s where sauda_date=date")
	public List<Sauda> getSaudaByDate(@Param("date")Date date);

}
