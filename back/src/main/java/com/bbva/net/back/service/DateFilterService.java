package com.bbva.net.back.service;

import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;

public interface DateFilterService {

	/**
	 * @param period
	 * @return
	 */
	DateRangeDto getPeriodFilter(EnumPeriodType comboFilter);

}
