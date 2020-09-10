package org.bhavesh.kbsales.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.bean.pojo.AccountPOJO;
import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.bhavesh.kbsales.mapper.SaudaMapper;
import org.bhavesh.kbsales.repository.SaudaRepository;
import org.springframework.stereotype.Service;

@Service
public class SaudaService{

	SaudaRepository saudarepo;
	SaudaMapper mapper;
	public SaudaService(SaudaRepository saudarepo,SaudaMapper mapper)
	{
		this.saudarepo=saudarepo;
		this.mapper=mapper;
	}
	
	public SaudaPOJO getSaudabyid(Long saudaid)
	{
		Optional<Sauda> optSauda=saudarepo.findById(saudaid);
		if(optSauda.isPresent())
			return mapper.saudatoSaudaPOJO(optSauda.get());
		else
			return null;
	}
	public List<SaudaPOJO> getSaudabyCreationDate(LocalDate now)
	{
		return mapper.saudalisttoSaudaPOJOlist(saudarepo.findByCreatedDate(now));
	}
	public List<SaudaPOJO> getSaudabyStartDateandEndDateRange(LocalDate saudastart, LocalDate saudaend)
	{
		return mapper.saudalisttoSaudaPOJOlist(saudarepo.findBySaudaStartDateAfterAndSaudaEndDateBefore(saudastart, saudaend));
	}
	
	public List<SaudaPOJO> getSaudabyClosingDate()
	{
		return mapper.saudalisttoSaudaPOJOlist(saudarepo.findBySaudaEndDate(Calendar.getInstance().getTime()));
	}
	
	public void insertSauda(SaudaPOJO saudaPOJO)
	{
		saudarepo.save(mapper.saudaPOJOtoSauda(saudaPOJO));
	}
	
	public List<SaudaPOJO> getSaudaByCreatedDatebetween(LocalDate start,LocalDate end)
	{
		return mapper.saudalisttoSaudaPOJOlist(saudarepo.findBySaudaStartDateBetween(start,end));
	}

	public List<SaudaPOJO>  getSaudabyAccountwithRange(LocalDate startDate, LocalDate endDate, AccountPOJO account) {
		return getSaudaByCreatedDatebetween(startDate,endDate).stream()
					.filter(sauda -> sauda.getBuyerAccount().equals(account) || sauda.getSellerAccount().equals(account)).collect(Collectors.toList());
	}
	public void updateSauda(Long id,SaudaPOJO saudaPOJO)
	{
		Sauda sauda=mapper.saudaPOJOtoSauda(saudaPOJO);
		sauda.setSaudaId(id);
		saudarepo.save(sauda);
	}

	public void deleteSauda(SaudaPOJO sauda) {
		saudarepo.delete(mapper.saudaPOJOtoSauda(sauda));
	}
	
}
