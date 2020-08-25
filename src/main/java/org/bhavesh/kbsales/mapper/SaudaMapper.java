package org.bhavesh.kbsales.mapper;

import java.util.List;

import org.bhavesh.kbsales.bean.Sauda;
import org.bhavesh.kbsales.bean.pojo.SaudaPOJO;
import org.mapstruct.Mapper;

@Mapper
public interface SaudaMapper {
	public Sauda saudaPOJOtoSauda(SaudaPOJO saudaPojo);
	public SaudaPOJO saudatoSaudaPOJO(Sauda sauda);
	public List<Sauda> saudaPOJOlisttoSaudalist(List<SaudaPOJO> saudaPojo);
	public List<SaudaPOJO> saudalisttoSaudaPOJOlist(List<Sauda> sauda);
}
