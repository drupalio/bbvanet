package com.bbva.net.webservices.accounts;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.webservices.accounts.impl.AccountsServiceImpl;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class AccountsServiceImplTest extends AbstractBbvaRestClientTest {

	private AccountsServiceImpl accountsServiceImpl;

	private static final String ACCOUNT_ID = "00112345678909954345";

	private static final String filter = "00112345678909954345";

	private static final String CHECK_ID = "99887766";

	private static final String CHECKBOOK_ID = "887766";

	private static final Integer paginationKey = 1;

	private static final Integer pageSize = 9;

	@Before
	public void init() {

		this.accountsServiceImpl = (AccountsServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new AccountsServiceImpl();
	}

	@Test
	public void checkGetAccount() {
		Mockito.when(webClient.get(Account.class)).thenReturn(Mockito.mock(Account.class));
		this.accountsServiceImpl.getAccount(ACCOUNT_ID);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Account.class);
	}

	@Test
	public void checkGetCheck() {
		Mockito.when(webClient.get(Check.class)).thenReturn(Mockito.mock(Check.class));
		this.accountsServiceImpl.getCheck(ACCOUNT_ID, CHECK_ID);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Check.class);
	}

	@Test
	public void checkGetCheckBook() {
		Mockito.when(webClient.get(Checkbook.class)).thenReturn(Mockito.mock(Checkbook.class));
		this.accountsServiceImpl.getCheckbook(ACCOUNT_ID, CHECKBOOK_ID);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Checkbook.class);
	}

	@Test
	public void checkListCheck() {
		Mockito.when(webClient.getCollection(Check.class)).thenReturn(Mockito.anyCollection());
		this.accountsServiceImpl.listCheck(ACCOUNT_ID, filter, paginationKey, pageSize);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Check.class);
	}

	@Test
	public void checkGetAccountMonthlyBalance() {
		Mockito.when(webClient.getCollection(MonthlyBalances.class)).thenReturn(Mockito.anyCollection());
		this.accountsServiceImpl.getAccountMonthlyBalance(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(MonthlyBalances.class);
	}

	// getAccMovementResume

	@Test
	public void checkGetAccMovementResume() {
		Mockito.when(webClient.getCollection(AccMovementsResume.class)).thenReturn(Mockito.anyCollection());
		this.accountsServiceImpl.getAccMovementResume(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(AccMovementsResume.class);
	}
}
