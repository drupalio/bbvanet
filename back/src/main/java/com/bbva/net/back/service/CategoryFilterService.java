package com.bbva.net.back.service;

import com.bbva.net.back.model.comboFilter.ComboFilterGraphicsDto;

public interface CategoryFilterService {

	/**
	 * @param period
	 * @return
	 */
	ComboFilterGraphicsDto getPeriodFilter(ComboFilterGraphicsDto comboFilter);

}
