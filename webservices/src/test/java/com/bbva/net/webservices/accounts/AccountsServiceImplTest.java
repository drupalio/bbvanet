package com.bbva.net.webservices.accounts;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

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

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetAccountThrowException() {
        Mockito.when(webClient.get(Account.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.getAccount(ACCOUNT_ID);
    }

    @Test
    public void checkGetCheck() {
        Mockito.when(webClient.get(Check.class)).thenReturn(Mockito.mock(Check.class));
        this.accountsServiceImpl.getCheck(ACCOUNT_ID, CHECK_ID);
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Check.class);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetCheckThrowException() {
        Mockito.when(webClient.get(Check.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.getCheck(ACCOUNT_ID, CHECK_ID);
    }

    @Test
    public void checkGetCheckBook() {
        Mockito.when(webClient.get(Checkbook.class)).thenReturn(Mockito.mock(Checkbook.class));
        this.accountsServiceImpl.getCheckbook(ACCOUNT_ID, CHECKBOOK_ID);
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Checkbook.class);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetCheckBookThrowException() {
        Mockito.when(webClient.get(Checkbook.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.getCheckbook(ACCOUNT_ID, CHECKBOOK_ID);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void checkListCheck() {
        Mockito.when(webClient.getCollection(Check.class)).thenReturn(Matchers.anyCollection());
        this.accountsServiceImpl.listCheck(ACCOUNT_ID, filter, paginationKey, pageSize);
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Check.class);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkListCheckThrowException() {
        Mockito.when(webClient.getCollection(Check.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.listCheck(ACCOUNT_ID, filter, paginationKey, pageSize);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void checkGetAccountMonthlyBalance() {
        Mockito.when(webClient.getCollection(MonthlyBalances.class)).thenReturn(Matchers.anyCollection());
        this.accountsServiceImpl.getAccountMonthlyBalance(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
                StringUtils.EMPTY);
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(MonthlyBalances.class);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetAccountMonthlyBalanceThrow() {
        Mockito.when(webClient.getCollection(MonthlyBalances.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.getAccountMonthlyBalance(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
                StringUtils.EMPTY);
    }

    // getAccMovementResume

    @SuppressWarnings("unchecked")
    @Test
    public void checkGetAccMovementResume() {
        Mockito.when(webClient.getCollection(AccMovementsResume.class)).thenReturn(Matchers.anyCollection());
        this.accountsServiceImpl.getAccMovementResume(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
                StringUtils.EMPTY);
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(AccMovementsResume.class);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetAccMovementResumeThrow() {
        Mockito.when(webClient.getCollection(AccMovementsResume.class)).thenThrow(RestClientException.class);
        this.accountsServiceImpl.getAccMovementResume(ACCOUNT_ID, filter, StringUtils.EMPTY, StringUtils.EMPTY,
                StringUtils.EMPTY);
    }
}
