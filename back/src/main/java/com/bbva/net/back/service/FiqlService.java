package com.bbva.net.back.service;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.extract.ExtractDto;

public interface FiqlService {

	String getFiqlEqual(String parameter, String value);

	String getExecutiveFiql();

	String getFiqlQueryByDateRange(DateRangeDto dateRange, String startProperty, String endProperty);

	String getFiqlQueryByStatus(String status, String statusProperty);

	String getFiqlQueryByExtract(ExtractDto extract);

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

	/***
	 * Method to create a filter by balance
	 * 
	 * @param balanceRange
	 * @param startProperty
	 * @param endProperty
	 * @return
	 */
	String getFiqlQueryByBalanceRange(BalanceRangeDto balanceRange, String startProperty, String endProperty);

	/***
	 * @param productType
	 * @param startProperty
	 * @return
	 */
	String getFiqlQueryByCustomerIdAndProductType(String productType, String startProperty);

	/**
	 * @param userName
	 * @param docTypeUser
	 * @param docIdUser
	 * @return
	 */
	String getFiqlQueryCustomer(String userName, String docTypeUser, String docIdUser);
	
	/**
	 * 
	 * @param usr
	 * @return
	 */
	String getFiqlQuerybyCustomer(String usr);

}
