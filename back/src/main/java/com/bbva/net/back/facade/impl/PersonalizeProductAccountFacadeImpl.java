package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.PersonalizeProductAccountFacade;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;

@Facade(value = "personalizeProductAccountFacade")
public class PersonalizeProductAccountFacadeImpl extends AbstractBbvaFacade implements PersonalizeProductAccountFacade {

	private static final long serialVersionUID = -8535409693026365524L;


	@Override
	public PersonalizeAccountDTO getPersonalizeAccountDto(String defaultUser, String defaultProduct) {
		return new PersonalizeAccountDTO();
	}

}
