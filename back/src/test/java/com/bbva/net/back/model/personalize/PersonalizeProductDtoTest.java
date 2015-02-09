package com.bbva.net.back.model.personalize;

import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PersonalizeProductDtoTest extends AbstractBbvaDTOTest<PersonalizeAccountDto> {

	@Override
	protected PersonalizeAccountDto getInstance() {
		return new PersonalizeAccountDto();
	}
}
