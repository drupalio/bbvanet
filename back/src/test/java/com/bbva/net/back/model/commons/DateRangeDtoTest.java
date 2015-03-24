package com.bbva.net.back.model.commons;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class DateRangeDtoTest extends AbstractBbvaDTOTest<DateRangeDto> {

	private DateRangeDto dateRangeDto;

	public DateRangeDtoTest() {
		this.dateRangeDto = new DateRangeDto(new Date(), new Date());
	}

	@Override
	protected DateRangeDto getInstance() {
		return new DateRangeDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		DateRangeDto dateInEquals = new DateRangeDto(new Date(), new Date());
		// Cuando el objeto es nulo
		this.dateRangeDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.dateRangeDto.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.dateRangeDto.equals(dateInEquals);
		// el DateTo del objeto es diferente
		dateRangeDto.setDateTo(new Date(453534534));
		this.dateRangeDto.equals(dateInEquals);
		// el DateSince del objeto es diferente
		dateRangeDto.setDateSince(new Date(43534534));
		this.dateRangeDto.equals(dateInEquals);
	}

}