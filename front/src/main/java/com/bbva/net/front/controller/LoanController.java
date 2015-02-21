package com.bbva.net.front.controller;

import java.util.List;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

/**
 * @author Entelgy
 */
public interface LoanController {

	/**
	 * @return
	 */
	List<RotatingAccountDto> getCustomerRotatingAccount();

	/**
	 * @return
	 */
	List<LeasingDto> getCustomerLeasing();

	/**
	 * @return
	 */
	List<RotatingAccountDto> getCustomerRotatingAccountHidden();

	/**
	 * @return
	 */
	List<LeasingDto> getCustomerLeasingHidden();

	/**
	 * @return
	 */
	List<LoanDto> getCustomerLoan();

	/**
	 * @return
	 */
	List<LoanDto> getCustomerLoanHidden();

	void onProductLoanSelected(SelectEvent selectEvent);

}
