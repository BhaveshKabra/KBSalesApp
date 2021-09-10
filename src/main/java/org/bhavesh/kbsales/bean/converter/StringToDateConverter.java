package org.bhavesh.kbsales.bean.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		Date date;
		
			try {
				date = new SimpleDateFormat("yyyy-mm-dd").parse(source);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		
	}

}
