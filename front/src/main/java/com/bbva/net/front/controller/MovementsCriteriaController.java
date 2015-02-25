package com.bbva.net.front.controller;

public interface MovementsCriteriaController {

	void onDateCriteriaQuery();

	void onBalanceCriteriaQuery();

	void onIncomeExpenseCriteriaQuery();

	void onMovementCriteriaQuery();

	void cleanFilters();

	void displayResults();

}
