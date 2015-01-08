package com.bbva.net.back.service;

import com.bbva.net.back.model.comboFilter.PeriodFilterDto;

public interface CategoryFilterService {

	/**
	 * @param period
	 * @return
	 */
	PeriodFilterDto getPeriodFilter(PeriodFilterDto comboFilter);

}
