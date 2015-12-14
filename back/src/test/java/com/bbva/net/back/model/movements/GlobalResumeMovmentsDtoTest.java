package com.bbva.net.back.model.movements;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class GlobalResumeMovmentsDtoTest extends AbstractBbvaDTOTest<GlobalResumeMovementsDto> {

	@Override
	protected GlobalResumeMovementsDto getInstance() {
		return new GlobalResumeMovementsDto();
	}

	@Test
	public void GlobalResumeMovementsDtoF() {
		List<MovementsResumeDto> movementsResumeDTO = new ArrayList<MovementsResumeDto>();
		GlobalResumeMovementsDto globalResumeMovementsDto = new GlobalResumeMovementsDto(movementsResumeDTO);
		Assert.assertNotNull(globalResumeMovementsDto.getMovementsResumeDto());
	}
}
