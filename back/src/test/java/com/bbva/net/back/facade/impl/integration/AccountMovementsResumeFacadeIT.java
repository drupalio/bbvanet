package com.bbva.net.back.facade.impl.integration;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

	private DateRangeDto dateRange;

	private static final String DEFAULT_USER = "123";

	@Resource(name = "accountMovementsFacade")
	private AccountMovementsResumeFacade accountMovementsFacade;

	@Before
	public void init() {

		dateRange = Mockito.mock(DateRangeDto.class);
	}

	@Test
	public void checkMovementsResumeByCustomerOk() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER,
				new DateRangeDto(new Date(), new Date()));

		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}

}
