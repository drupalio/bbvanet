package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.model.globalposition.ProductDto;

public interface ComboCriteriaController {

	List<MultiValueGroup> getListMultiValuePeriod();

	/*
	 * GP12834 Cheques y chequeras - Entelgy - inicio
	 */

	List<MultiValueGroup> getListMultiValueChecks();

	/*
	 * GP12834 Cheques y chequeras - Entelgy - fin
	 */

	List<MultiValueGroup> getListQuieroAccounts(ProductDto product);

	List<MultiValueGroup> getListQuieroCards();

	List<MultiValueGroup> getListQuieroQuota(ProductDto product);

	List<MultiValueGroup> getQuieroLoan();

	List<MultiValueGroup> getQuieroDeposit();

	List<MultiValueGroup> getQuieroFund();

	List<MultiValueGroup> getQuieroLeasing();

}
