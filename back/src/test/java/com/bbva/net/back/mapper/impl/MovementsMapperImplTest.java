package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.model.movements.MovementDto;

public class MovementsMapperImplTest {

	private MovementsMapperImpl movementsMapper;

	@Before
	public void init() {
		this.movementsMapper = new MovementsMapperImpl();

	}

	@Test
	public void checkMaperMovemntList() {
		List<Movement> movementList = new ArrayList<Movement>();
		List<MovementDto> movementsDto = movementsMapper.mapMovementDtoList(movementList);
		Assert.assertNotNull(movementsDto);

	}

	@Test
	public void checkMaperMovemntDto() {
		Assert.assertNotNull(movementsMapper.mapMovement(new Movement()));
	}

}
