package com.bbva.net.back.model.personalize;

import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PersonalizeAccountDTOTest extends AbstractBbvaDTOTest<PersonalizeAccountDto> {

	@Override
	protected PersonalizeAccountDto getInstance() {
		return new PersonalizeAccountDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {

	}
}
