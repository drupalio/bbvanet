package com.bbva.net.back.service;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;

public interface FiqlService {

	String getFiqlEqual(String parameter, String value);

	String getCustomerFiql(String user);

	String getFiqlQueryByDateRange(DateRangeDto dateRange, String startProperty, String endProperty);

	String getFiqlQueryByStatus(String status, String statusProperty);

	/**
	 * Filtro utilizado en la invocación al Servicio SrvCustomersV01 / SrvAccountsV01 -> listAccountsMovementsResume
	 * 
	 * @param dateRange
	 * @param monthProperty
	 * @return
	 */
	String formatMonthByAccMovementResume(DateRangeDto dateRange, String monthProperty);

	/**
	 * Filtro utilizado en la invocación al Servicio SrvAccountsV01 -> getAccountMonthlyBalance
	 * 
	 * @param dateRange
	 * @param startProperty
	 * @param endProperty
	 * @return
	 */
	String getFiqlQueryMonthlyByDateRange(final DateRangeDto dateRange, String startProperty, String endProperty);

	String getFiqlQueryByBalanceRange(BalanceRangeDto balanceRange, String startProperty, String endProperty);

	String getFiqlQueryByCustomerIdAndProductType(String customerId, String productType, String startProperty,
			String endProperty);

}
