package com.bbva.net.back.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.bbva.net.back.model.comboFilter.ComboFilterGraphicsDto;
import com.bbva.net.back.service.CategoryFilterService;

/**
 * Clase que implementa el método para calcular periodo en filtros
 * 
 * @author Entelgy
 */
public class CategoryFilterServiceImpl implements CategoryFilterService {

	/**
	 * Método encargado de calcular el periodo de consulta en un filtro
	 */
	@Override
	public ComboFilterGraphicsDto getPeriodFilter(final ComboFilterGraphicsDto comboFilter) {

		// Este formato está pendiente definir
		final SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
		final Calendar currentDate = Calendar.getInstance();
		final Calendar endDate = Calendar.getInstance();
		// se extrae el tiempo en meses del filtro
		final StringBuilder strPeriod = new StringBuilder(comboFilter.getPeriod().replaceAll("[^0-9]", ""));
		final String strMonth = strPeriod.length() == 0 ? "1" : "";
		strPeriod.append(strMonth);
		final int period = Integer.parseInt(strPeriod.toString());

		endDate.add(Calendar.MONTH, -period);

		comboFilter.setStartDate(formatDate.format(currentDate.getTime()));
		comboFilter.setEndDate(formatDate.format(endDate.getTime()));

		return comboFilter;
	}

}
