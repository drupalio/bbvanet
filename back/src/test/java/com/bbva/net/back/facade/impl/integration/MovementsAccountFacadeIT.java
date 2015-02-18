package com.bbva.net.back.facade.impl.integration;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MovementsAccountFacadeIT {

	private static final String DEFAULT_ACCOUNT = "12345678998765432101";

	private static final String ALPHA_ACCOUNT = "12E4567899O765432101";

	private static final String BAD_ACCOUNT = "1234567899";
	
	private static final String DEFAULT_PRODUC_TYPE = "AH";

	private static final String BAD_PRODUC_TYPE = "01";

	private static final String DEFAULT_MOVEMENT_ID = "88445598765432101236";

	private static final String ALPHA_MOVEMENT_ID = "12E45678PPO76543210L";

	private static final String BAD_MOVEMENT_ID = "1234567899";

	@Resource(name = "movementsAccountFacade")
	private MovementsAccountFacade movementsAccountFacade;

	// *********** List Movement ***********

	@Test()
	public void checkListMovementsOK() {
		// SrvProductsV01 -> listMovements

		final List<MovementDto> resume = this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, 
				DEFAULT_PRODUC_TYPE, new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)),
				1, 50);

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.get(0));
	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadAccount() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(BAD_ACCOUNT,  DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsAlphaCustomer() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadCustomer() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadAlphaAccount() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(ALPHA_ACCOUNT, DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadProductType() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, BAD_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadFilterDateRange() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, DEFAULT_PRODUC_TYPE, null,
					new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadFilterBalanceRange() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), null, 1, 50);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test(expected = BadRequestException.class)
	public void checkListMovementsBadPaginationSize() {
		// SrvProductsV01 -> listMovements
		try {
			this.movementsAccountFacade.listMovements(DEFAULT_ACCOUNT, DEFAULT_PRODUC_TYPE,
					new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), null, null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	// *********** Movement ***********

	@Test()
	public void checkMovementOK() {
		// SrvProductsV01 -> listMovements

		// final MovementDetailDto resume = this.movementsAccountFacade.getMovement(DEFAULT_ACCOUNT, DEFAULT_MOVEMENT_ID,
		// new DateRangeDto());

		// Assert.assertNotNull(resume);

	}

	/*
	 * >>>@Test(expected = BadRequestException.class) public void checkMovementsBadMovementID() { // SrvProductsV01 ->
	 * Movement try { getMovement(DEFAULT_ACCOUNT, BAD_MOVEMENT_ID, new DateRangeDto()); } catch (final BadRequestException
	 * notFoundException) { Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request"); throw
	 * notFoundException; } } >>>@Test(expected = BadRequestException.class) public void checkMovementsAlphaAccount() { //
	 * SrvProductsV01 -> listMovements try { this.movementsAccountFacade.getMovement(ALPHA_ACCOUNT, DEFAULT_MOVEMENT_ID,
	 * DEFAULT_PRODUC_TYPE, new DateRangeDto(), new BalanceRangeDto(new BigDecimal(100), new BigDecimal(500)), 1, 50); }
	 * catch (final BadRequestException notFoundException) { Assert.assertEquals(notFoundException.getMessage(),
	 * "HTTP 400 Bad Request"); throw notFoundException; } }
	 */

}
