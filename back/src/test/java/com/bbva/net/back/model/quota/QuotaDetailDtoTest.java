package com.bbva.net.back.model.quota;

import java.util.Date;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class QuotaDetailDtoTest extends AbstractBbvaDTOTest<QuotaDetailDto> {

	private QuotaDetailDto quotaDetailDto;

	public QuotaDetailDtoTest() {
		this.quotaDetailDto = new QuotaDetailDto("10172689182791776545", new Money(), new Money(), 1, "Activo",
				new Money(), new Money(), new Money(), new Money(), new Date(), new Date(), new Date());
		this.quotaDetailDto.setNumberOfShares(1);
	}

	@Override
	protected QuotaDetailDto getInstance() {
		return new QuotaDetailDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		QuotaDetailDto quotaInEquals = new QuotaDetailDto();
		// Cuando el objeto es nulo
		this.quotaDetailDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.quotaDetailDto.equals(new MovementCriteriaDto());
		// Caso exitoso
		quotaInEquals.setId("10172689182791776545");
		this.quotaDetailDto.equals(quotaInEquals);
		// el id del objeto es diferente
		quotaInEquals.setId("10172689182791776543");
		this.quotaDetailDto.equals(quotaInEquals);
		// Cuando el id del objeto entrante es nulo
		quotaInEquals.setId(null);
		this.quotaDetailDto.equals(quotaInEquals);
		// Cuando el id global es nulo
		this.quotaDetailDto.setId(null);
		this.quotaDetailDto.equals(quotaInEquals);
	}
}
