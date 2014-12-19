package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.PersonalizeAccountDTO;

public interface PersonalizeProductAccountFacade {

	PersonalizeAccountDTO getPersonalizeAccountDto(String defaultUser, String defaultProduct);

}
