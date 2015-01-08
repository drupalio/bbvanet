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

		final SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
		final Calendar currentDate = Calendar.getInstance();
		final Calendar endDate = Calendar.getInstance();
		// se extrae el tiempo en meses del filtro y se parsea a int
		final int period = Integer.parseInt(comboFilter.getPeriod().replaceAll("[^0-9]", ""));

		endDate.add(Calendar.MONTH, -period);

		comboFilter.setStartDate(format1.format(currentDate.getTime()));
		comboFilter.setEndDate(format1.format(endDate.getTime()));

		return comboFilter;
	}

	public static void main(String[] args) {

		ComboFilterGraphicsDto comboFilter = new ComboFilterGraphicsDto();
		comboFilter.setPeriod("Último mes");

	}

}
