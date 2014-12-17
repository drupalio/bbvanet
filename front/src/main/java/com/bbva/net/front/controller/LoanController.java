package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

/**
 * @author Entelgy
 */
public interface LoanController {

	/**
	 * @return
	 */
	public List<RotatingAccountDTO> getCustomerRotatingAccount();

	/**
	 * @return
	 */
	public List<LeasingDTO> getCustomerLeasing();

}
