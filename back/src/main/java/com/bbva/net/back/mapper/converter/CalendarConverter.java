package com.bbva.net.back.mapper.converter;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * @author Entelgy
 */
public class CalendarConverter extends CustomConverter<XMLGregorianCalendar, Date> {

	/**
	 * 
	 */
	@Override
	public Date convert(XMLGregorianCalendar source, Type<? extends Date> destinationType) {
		@SuppressWarnings("deprecation")
		Date fech = new Date(source.getYear(), source.getMonth(), source.getDay(), source.getHour(), source.getMinute());
		return fech;
	}

}
