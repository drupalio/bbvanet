package com.bbva.net.back.accounts;

import com.bbva.net.back.model.accounts.DetailConditionsDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class DetailConditionsDtoTest extends AbstractBbvaDTOTest<DetailConditionsDto> {

	@Override
	protected DetailConditionsDto getInstance() {
		return new DetailConditionsDto();
	}

}
