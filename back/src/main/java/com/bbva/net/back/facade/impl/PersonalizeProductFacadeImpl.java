package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;

@Facade(value = "personalizeProductAccountFacade")
public class PersonalizeProductFacadeImpl extends AbstractBbvaFacade implements PersonalizeProductFacade {

	private static final long serialVersionUID = -8535409693026365524L;


	@Override
	public PersonalizeAccountDto getPersonalizeAccountDto(String defaultUser, String defaultProduct) {
		return new PersonalizeAccountDto();
	}

}
