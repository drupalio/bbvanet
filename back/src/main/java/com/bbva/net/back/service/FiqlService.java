package com.bbva.net.back.service;

import com.bbva.net.back.model.commons.DateRangeDto;

public interface FiqlService {

	String getFiqlEqual(String parameter, String value);

	String getCustomerFiql(String user);

	String getFiqlQueryByDateRange(DateRangeDto dateRange, String startProperty, String endProperty);

	String getFiqlQueryByStatus(String status, String statusProperty);

}
