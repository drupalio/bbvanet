package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

public interface ComboCriteriaController {

	List<MultiValueGroup> getListMultiValuePeriod();

	List<MultiValueGroup> getListMultiValueChecks();

	List<MultiValueGroup> getListQuieroAccounts();

	List<MultiValueGroup> getListQuieroCards();

	List<MultiValueGroup> getListQuieroQuota();

	List<MultiValueGroup> getQuieroLoan();

	List<MultiValueGroup> getQuieroDeposit();

	List<MultiValueGroup> getQuieroFund();

	List<MultiValueGroup> getQuieroLeasing();

}
