package com.bbva.net.back.service;

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

}
