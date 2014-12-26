package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

/**
 * @author Entelgy
 */
public interface LoanController {

	/**
	 * @return
	 */
	List<RotatingAccountDTO> getCustomerRotatingAccount();

	/**
	 * @return
	 */
	List<LeasingDTO> getCustomerLeasing();

	/**
	 * @return
	 */
	List<RotatingAccountDTO> getCustomerRotatingAccountHidden();

	/**
	 * @return
	 */
	List<LeasingDTO> getCustomerLeasingHidden();

	/**
	 * @return
	 */
	List<LoanDTO> getCustomerLoan();

	/**
	 * @return
	 */
	List<LoanDTO> getCustomerLoanHidden();

}
