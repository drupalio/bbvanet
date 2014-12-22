package com.bbva.net.back.accounts;

import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class InvolvedDtoTest extends AbstractBbvaDTOTest<InvolvedDto> {

	@Override
	protected InvolvedDto getInstance() {
		return new InvolvedDto();
	}
}
