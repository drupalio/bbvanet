package com.bbva.net.back.facade;

import com.bbva.net.back.model.personalize.PersonalizeAccountDto;

public interface PersonalizeProductAccountFacade {

	PersonalizeAccountDto getPersonalizeAccountDto(String defaultUser, String defaultProduct);

}
