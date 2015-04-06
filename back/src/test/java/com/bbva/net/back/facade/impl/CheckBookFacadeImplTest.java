package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.mapper.CheckBookMapper;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.accounts.AccountsService;

public class CheckBookFacadeImplTest {

	private static final String DEFAULT_ID = "00130443000200009410";

	private CheckBookFacadeImpl checkBookFacade;

	private AccountsService accountService;

	private CheckBookMapper checkBookMapper;

	private FiqlService fiqlService;

	@Before
	public void init() {
		this.checkBookFacade = new CheckBookFacadeImpl();

		// Mockitos
		this.accountService = Mockito.mock(AccountsService.class);
		this.checkBookMapper = Mockito.mock(CheckBookMapper.class);
		this.fiqlService = Mockito.mock(FiqlService.class);
		// set
		this.checkBookFacade.setAccountService(accountService);
		this.checkBookFacade.setCheckBookMapper(checkBookMapper);
		this.checkBookFacade.setFiqlService(fiqlService);

	}

	@Test
	public void checkGetCheckById() {
		Check check = new Check();
		Mockito.when(this.accountService.getCheck(DEFAULT_ID, "1234566")).thenReturn(check);
		this.checkBookFacade.getCheckById(DEFAULT_ID, "1234566");
	}

	@Test
	public void getCheckByStatusOrDate() {
		List<Check> lstCheck = new ArrayList<Check>();
		String filter = "date";
		DateRangeDto date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		Mockito.when(this.fiqlService.getFiqlQueryByStatus("1", "")).thenReturn(DEFAULT_ID);
		Mockito.when(this.fiqlService.getFiqlQueryByDateRange(date, "", "")).thenReturn(filter);
		Mockito.when(this.accountService.listCheck(DEFAULT_ID, filter, 0, 10)).thenReturn(lstCheck);
		this.checkBookFacade.getCheckByStatusOrDate(DEFAULT_ID, date, "2", 0, 10);
		date = null;
		this.checkBookFacade.getCheckByStatusOrDate(DEFAULT_ID, date, "2", 0, 10);

	}

	@Test
	public void getCheckBookByAccountId() {
		List<Checkbook> lstCheBook = new ArrayList<Checkbook>();
		Mockito.when(this.accountService.getCheckbook(DEFAULT_ID, "1234566")).thenReturn(lstCheBook);
		this.checkBookFacade.getCheckBookByAccountId(DEFAULT_ID, "1234566");
	}

	@Test
	public void getCheckBooksById() {
		Account account = Mockito.mock(Account.class);
		List<Checkbook> lstCheBook = new ArrayList<Checkbook>();
		Mockito.when(this.accountService.getAccount(DEFAULT_ID)).thenReturn(account);
		Mockito.when(account.getCheckbooks()).thenReturn(lstCheBook);
		this.checkBookFacade.getCheckBooksById(DEFAULT_ID);
	}
}
