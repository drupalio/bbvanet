package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;

public class PersonalizeProductAccountControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private static final String DEFAULT_PRODUCT = "234hola";

	private PersonalizeProductAccountControllerImpl personalizeProductAccountControllerImpl;

	private PersonalizeProductFacade personalizeProductAccountFacade;

	@Before
	public void init() {
		this.personalizeProductAccountControllerImpl = new PersonalizeProductAccountControllerImpl();

		this.personalizeProductAccountControllerImpl.operKey();

		this.personalizeProductAccountControllerImpl.offMessage();

		this.personalizeProductAccountControllerImpl.successful();

		this.personalizeProductAccountFacade = Mockito
				.mock(PersonalizeProductFacade.class);

	}

}
