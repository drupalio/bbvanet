package com.bbva.net.back.service;

import com.bbva.net.back.model.commons.DateRangeDto;

public interface FiqlService {

	String getFiqlQueryByDateRange(DateRangeDto dateRange);
}
