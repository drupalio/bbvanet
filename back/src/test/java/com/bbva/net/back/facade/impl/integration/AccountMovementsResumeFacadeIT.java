package com.bbva.net.back.facade.impl.integration;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.ClientErrorException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountMovementsResumeFacadeIT {

	private static final String DEFAULT_USER = "123";

	@Resource(name = "accountMovementsFacade")
	private AccountMovementsResumeFacade accountMovementsFacade;
	/*
	@Test
	public void checkMovementsResumeByCustomerOk() {

		// SrvCustomersV01 -> listAccountsMovementsResume
		final GlobalResumeMovementsDto resume = this.accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER,
				new DateRangeDto(new Date(), new Date()));

		Assert.assertNotNull(resume.getMovementsResumeDto().get(0));

	}
	
	@Test
	public void listCheckOk(){
		final CheckDto cheques;
	}

	@Test(expected = ClientErrorException.class)
	public void checkMovementsResumeByCustomerNotUser() {
		this.accountMovementsFacade.getMovementsResumeByCustomer(null, new DateRangeDto(new Date(), new Date()));
	}
	*/
	@Test(expected = ClientErrorException.class)
	public void checkMovementsResumeByCustomerNotDate() {
		this.accountMovementsFacade.getMovementsResumeByCustomer(DEFAULT_USER, new DateRangeDto(null, null));
	}

}
