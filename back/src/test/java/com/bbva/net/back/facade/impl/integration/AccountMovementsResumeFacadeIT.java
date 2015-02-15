package com.bbva.net.back.facade.impl.integration;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang.StringUtils;
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

	private static final String DEFAULT_ACCOUNT = "12345678998765432101";

	private static final String BAD_ACCOUNT = "1234567899";

	@Resource(name = "accountMovementsFacade")
	private AccountMovementsResumeFacade accountMovementsFacade;

	// ***************** Customer Interface *****************
	@Test
	public void checkMovementsResumeByCustomerOk() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade
				.getMovementsResumeByCustomer(new DateRangeDto(new Date(), new Date()));

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test
	public void checkMovementsResumeByCustomerOkWhitoutFilter() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByCustomer(null);

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test()
	public void checkMovementsResumeByCustomerNotDate() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade
				.getMovementsResumeByCustomer(new DateRangeDto(null, null));
		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	// ***************** Accounts Interface *****************

	@Test(expected = BadRequestException.class)
	public void checkMovementsResumeByAccountsNotAccount() {
		// SrvAccountsV01 -> listAccountsMovementsResume
		try {
			this.accountMovementsFacade.getMovementsResumeByAccount(null, new DateRangeDto(new Date(), new Date()),
					StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test()
	public void checkMovementsResumeByAccountNotDate() {
		// Debe devolver los 12 meses sin fecha
		// SrvAccountsV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByAccount(
				DEFAULT_ACCOUNT, null, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

	@Test(expected = BadRequestException.class)
	public void checkMovementsResumeByBadAccount() {

		// SrvAccountsV01 -> listAccountsMovementsResume
		try {
			this.accountMovementsFacade.getMovementsResumeByAccount(BAD_ACCOUNT, new DateRangeDto(new Date(),
					new Date()), StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}

	}

	@Test()
	public void checkMovementsResumeByAccountOK() {

		// SrvAccountsV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByAccount(
				DEFAULT_ACCOUNT, new DateRangeDto(new Date(), new Date()), StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY);

		Assert.assertNotNull(resume);
		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

}
