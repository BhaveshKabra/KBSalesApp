package org.bhavesh.kbsales.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.repository.SaudaRepository;
import org.springframework.stereotype.Service;

@Service
public class SaudaService {

	SaudaRepository saudarepo;
	
	public SaudaService(SaudaRepository saudarepo)
	{
		this.saudarepo=saudarepo;
	}
	
	public Sauda getSaudabyid(Integer id)
	{
		Optional<Sauda> optSauda=saudarepo.findById(id);
		if(optSauda.isPresent())
			return optSauda.get();
		else
			return null;
	}
	public List<Sauda> getSaudabyDate(Date saudaDate)
	{
		return saudarepo.getSaudaByDate(saudaDate);
	}
	public List<Sauda> get(Date saudaDate)
	{
		return saudarepo.getSaudaByDate(saudaDate);
	}
	
}
