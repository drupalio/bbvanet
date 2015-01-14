package com.bbva.net.back.service;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;

/**
 * @author Entelgy
 */
public interface DateFilterService {

	/**
	 * @param period
	 * @return
	 */
	DateRangeDto getPeriodFilter(EnumPeriodType comboFilter);

}
