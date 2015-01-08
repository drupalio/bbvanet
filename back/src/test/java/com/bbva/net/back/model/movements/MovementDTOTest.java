package com.bbva.net.back.model.movements;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MovementDTOTest extends AbstractBbvaDTOTest<MovementDto> {

	@Override
	protected MovementDto getInstance() {

		return new MovementDto();
	}

}
