package com.bbva.net.back.model.citeriaMovements;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class MovementCriteriaDtoTest extends AbstractBbvaDTOTest<MovementCriteriaDto> {

	private MovementCriteriaDto movementCriteriaDto;

	public MovementCriteriaDtoTest() {
		this.movementCriteriaDto = new MovementCriteriaDto(new DateRangeDto(new Date(), new Date()),
				new BalanceRangeDto(new BigDecimal(10000), new BigDecimal(10000)), new Date(), new Date(), new Date(),
				new Date(), new Date(), new Date(), new Date(), new Date(), "123", "vacio", "1");
	}

	@Override
	protected MovementCriteriaDto getInstance() {
		return new MovementCriteriaDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		MovementCriteriaDto moveCriInEquals = new MovementCriteriaDto(new DateRangeDto(new Date(), new Date()),
				new BalanceRangeDto(new BigDecimal(10000), new BigDecimal(10000)), new Date(), new Date(), new Date(),
				new Date(), new Date(), new Date(), new Date(), new Date(), "123", "vacio", "1");
		// Cuando el objeto es nulo
		this.movementCriteriaDto.equals(null);
		// Cuando el dto comparado no es el mismo
		this.movementCriteriaDto.equals(new QuotaDetailDto());
		// Caso exitoso
		this.movementCriteriaDto.equals(moveCriInEquals);
		// IncomesOrExpenses diferente
		moveCriInEquals.setIncomesOrExpenses("Lleno");
		this.movementCriteriaDto.equals(moveCriInEquals);
		// SelectDate diferente
		moveCriInEquals.setSelectDate("2");
		this.movementCriteriaDto.equals(moveCriInEquals);
		// Movement diferente
		moveCriInEquals.setMovement("1234");
		this.movementCriteriaDto.equals(moveCriInEquals);
		// Yesterday diferente
		moveCriInEquals.setYesterday(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// Today diferente
		moveCriInEquals.setToday(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// LastWeek diferente
		moveCriInEquals.setLastWeek(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// LastTwoWeeks diferente
		moveCriInEquals.setLastTwoWeeks(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// LasTwoMonth diferente
		moveCriInEquals.setLasTwoMonth(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// LastMonth diferente
		moveCriInEquals.setLastMonth(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// ConcreteDateTo diferente
		moveCriInEquals.setConcreteDateTo(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// ConcreteDateSince diferente
		moveCriInEquals.setConcreteDateSince(new Date(121232342));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// BalanceRange diferente
		moveCriInEquals.setBalanceRange(new BalanceRangeDto(new BigDecimal(30000), new BigDecimal(30000)));
		this.movementCriteriaDto.equals(moveCriInEquals);
		// DateRange diferente
		moveCriInEquals.setDateRange(new DateRangeDto(new Date(121232342), new Date(121232342)));
		this.movementCriteriaDto.equals(moveCriInEquals);

	}
}