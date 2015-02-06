package com.bbva.net.back.service;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;

public interface FiqlService {

	String getFiqlEqual(String parameter, String value);

	String getCustomerFiql(String user);

	String getFiqlQueryByDateRange(DateRangeDto dateRange, String startProperty, String endProperty);

	String getFiqlQueryByStatus(String status, String statusProperty);

	String formatMonthByAccMovementResume(DateRangeDto dateRange, String monthProperty);

	String getFiqlQueryByBalanceRange(BalanceRangeDto balanceRange, String startProperty, String endProperty);

	String getFiqlQueryByCustomerIdAndProductType(String customerId, String productType, String startProperty,
			String endProperty);

}
