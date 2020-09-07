package org.bhavesh.kbsales.mapper;

import java.util.List;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SaudaMapper {
	@Mapping(source = "saudaStartDate", target = "saudaStartDate", dateFormat = "MM/dd/yyyy")
	@Mapping(source = "saudaEndDate", target = "saudaEndDate", dateFormat = "MM/dd/yyyy")
	public Sauda saudaPOJOtoSauda(SaudaPOJO saudaPojo);
	@Mapping(source = "saudaStartDate", target = "saudaStartDate", dateFormat = "MM/dd/yyyy")
	@Mapping(source = "saudaEndDate", target = "saudaEndDate", dateFormat = "MM/dd/yyyy")
	public SaudaPOJO saudatoSaudaPOJO(Sauda sauda);
	public List<Sauda> saudaPOJOlisttoSaudalist(List<SaudaPOJO> saudaPojo);
	public List<SaudaPOJO> saudalisttoSaudaPOJOlist(List<Sauda> sauda);
}
