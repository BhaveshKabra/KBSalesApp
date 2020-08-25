package org.bhavesh.kbsales.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.mapper.SaudaMapper;
import org.bhavesh.kbsales.repository.SaudaRepository;
import org.springframework.stereotype.Service;

@Service
public class SaudaService {

	SaudaRepository saudarepo;
	SaudaMapper mapper;
	public SaudaService(SaudaRepository saudarepo,SaudaMapper mapper)
	{
		this.saudarepo=saudarepo;
		this.mapper=mapper;
	}
	
	public Sauda getSaudabyid(Long saudaid)
	{
		Optional<Sauda> optSauda=saudarepo.findById(saudaid);
		if(optSauda.isPresent())
			return optSauda.get();
		else
			return null;
	}
	public List<Sauda> getSaudabyDate(Date saudaDate)
	{
		return saudarepo.findBySaudaDate(saudaDate);
	}
	/*
	public List<Sauda> getSaudabyRange(Date saudastart, Date saudaend)
	{
		return saudarepo.findBySaudaRange(saudastart, saudaend);
	}
	*/
	public List<Sauda> getSaudabyClosingDate()
	{
		return saudarepo.findBySaudaEndDate(Calendar.getInstance().getTime());
	}
	
}
