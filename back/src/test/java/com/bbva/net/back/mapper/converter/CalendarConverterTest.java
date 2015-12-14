package com.bbva.net.back.mapper.converter;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import org.junit.Test;
import org.springframework.util.Assert;

public class CalendarConverterTest {

	private CalendarConverter calendar;

	@Test
	public void convertOk() {
		calendar = new CalendarConverter();
		Type<? extends Date> destinationType = TypeFactory.valueOf(Date.class);

		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			XMLGregorianCalendar source;
			source = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			Assert.notNull(calendar.convert(source, destinationType));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

	}
}
