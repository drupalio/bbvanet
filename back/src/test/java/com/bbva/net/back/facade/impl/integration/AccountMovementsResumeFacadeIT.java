package com.bbva.net.back.facade.impl.integration;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountMovementsResumeFacadeIT {

	private static final String DEFAULT_USER = "12345678";

	private static final String BAD_USER = "123456";

	@Resource(name = "accountMovementsFacade")
	private AccountMovementsResumeFacade accountMovementsFacade;

	@Test
	public void checkMovementsResumeByCustomerOk() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER,
				new DateRangeDto(new Date(), new Date()));

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test
	public void checkMovementsResumeByCustomerOkWhitoutFilter() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER,
				null);

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test(expected = BadRequestException.class)
	public void checkMovementsResumeByCustomerNotUser() {
		try {
			this.accountMovementsFacade.getMovementsResumeByCustomer(null, new DateRangeDto(new Date(), new Date()));
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test()
	public void checkMovementsResumeByCustomerNotDate() {

		GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER,
				new DateRangeDto(null, null));
		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test(expected = BadRequestException.class)
	public void checkMovementsResumeByBadCustomer() {
		try {
			this.accountMovementsFacade
					.getMovementsResumeByCustomer(BAD_USER, new DateRangeDto(new Date(), new Date()));
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

}
