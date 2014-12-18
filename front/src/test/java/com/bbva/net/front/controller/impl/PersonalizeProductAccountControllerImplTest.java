package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.PersonalizeProductAccountFacade;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;

public class PersonalizeProductAccountControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private static final String DEFAULT_PRODUCT = "234hola";

	private PersonalizeProductAccountControllerImpl personalizeProductAccountControllerImpl;

	private PersonalizeProductAccountFacade personalizeProductAccountFacade;

	@Before
	public void init() {
		this.personalizeProductAccountControllerImpl = new PersonalizeProductAccountControllerImpl();

		this.personalizeProductAccountControllerImpl.operKey(null);

		this.personalizeProductAccountControllerImpl.offMessage(null);

		this.personalizeProductAccountControllerImpl.successful(null);

		this.personalizeProductAccountFacade = Mockito.mock(PersonalizeProductAccountFacade.class);

		this.personalizeProductAccountControllerImpl
				.setPersonalizeProductAccountFacade(personalizeProductAccountFacade);

	}

	@Test
	public void checkGetPersonalizeAccountDTO() {

		// Prepare test
		Mockito.when(personalizeProductAccountFacade.getPersonalizeAccountDto(DEFAULT_USER, DEFAULT_PRODUCT))
				.thenReturn(new PersonalizeAccountDTO());

		this.personalizeProductAccountControllerImpl.init();

		this.personalizeProductAccountControllerImpl.isMenOperationKey();

		this.personalizeProductAccountControllerImpl.isMenSuccessful();

		// Invoke method
		PersonalizeAccountDTO result = personalizeProductAccountControllerImpl.getPersonalizeProductAccountDto();
		// Check results
		Assert.assertNotNull(result);
	}

}
