package com.bbva.net.back.model.movements;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MovementsResumeDtoTest extends AbstractBbvaDTOTest<MovementsResumeDto> {

	@Override
	protected MovementsResumeDto getInstance() {
		MovementsResumeDto movement = new MovementsResumeDto(new Money(), new Money(), new Money(), EnumMonth.APRIL);
		return new MovementsResumeDto();
	}

}
