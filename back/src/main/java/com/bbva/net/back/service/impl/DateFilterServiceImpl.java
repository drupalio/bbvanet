package com.bbva.net.back.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.DateFilterService;

/**
 * Clase que implementa el método para calcular periodo en filtros
 * 
 * @author Entelgy
 */
public class DateFilterServiceImpl implements DateFilterService {

	/**
	 * Método encargado de calcular el periodo de consulta en un filtro
	 */
	@Override
	public DateRangeDto getPeriodFilter(final EnumPeriodType comboFilter) {

		DateRangeDto dateRange = new DateRangeDto();
		final Date currentDate = new Date();

		switch (comboFilter) {
		case YESTERDAY:
			dateRange.setDateTo(DateUtils.addDays(currentDate, EnumPeriodType.YESTERDAY.getOptionfilterDate()));
			break;
		case TODAY:
			dateRange.setDateTo(currentDate);
			break;
		case LAST_WEEK:
			dateRange.setDateTo(DateUtils.addWeeks(currentDate, EnumPeriodType.LAST_WEEK.getOptionfilterDate()));
			break;
		case LAST_TWO_WEEK:
			dateRange.setDateTo(DateUtils.addWeeks(currentDate, EnumPeriodType.LAST_TWO_WEEK.getOptionfilterDate()));
			break;
		case LAST_MONTH:
			dateRange.setDateTo(DateUtils.addMonths(currentDate, EnumPeriodType.LAST_MONTH.getOptionfilterDate()));
			break;
		case LAST_TWO_MONTH:
			dateRange.setDateTo(DateUtils.addMonths(currentDate, EnumPeriodType.LAST_TWO_MONTH.getOptionfilterDate()));
			break;
		case LAST_THREE_MONTH:
			dateRange
					.setDateTo(DateUtils.addMonths(currentDate, EnumPeriodType.LAST_THREE_MONTH.getOptionfilterDate()));
			break;
		case LAST_SIX_MONTH:
			dateRange.setDateTo(DateUtils.addMonths(currentDate, EnumPeriodType.LAST_SIX_MONTH.getOptionfilterDate()));
			break;
		case LAST_TWELVE_MONTH:
			dateRange
					.setDateTo(DateUtils.addMonths(currentDate, EnumPeriodType.LAST_TWELVE_MONTH.getOptionfilterDate()));
			break;

		default:
			break;
		}

		return dateRange;
	}

}
