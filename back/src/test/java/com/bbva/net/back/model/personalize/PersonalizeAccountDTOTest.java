package com.bbva.net.back.model.personalize;

import com.bbva.net.back.model.personalize.PersonalizeAccountDTO;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PersonalizeAccountDTOTest extends AbstractBbvaDTOTest<PersonalizeAccountDTO> {

	@Override
	protected PersonalizeAccountDTO getInstance() {
		return new PersonalizeAccountDTO();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {

	}
}
