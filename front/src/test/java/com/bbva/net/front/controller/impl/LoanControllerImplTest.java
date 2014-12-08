package com.bbva.net.front.controller.impl;

import org.junit.Before;
import org.mockito.Mockito;

import com.bbva.net.back.facade.LoanFacade;

/**
 * @author Entelgy
 */
public class LoanControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private LoanControllerImpl loanController;

	private LoanFacade loanFacade;

	@Before
	public void init() {

		this.loanController = new LoanControllerImpl();

		loanFacade = Mockito.mock(LoanFacade.class);
		loanController.setLoanFacade(loanFacade);

	}

}
