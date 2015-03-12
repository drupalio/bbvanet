package com.bbva.net.webservices.loan;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.loan.impl.LoanServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class LoanServiceImplTest extends AbstractBbvaRestClientTest {

	private LoanServiceImpl loanServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get ProductsServiceImpl instance
		loanServiceImpl = (LoanServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new LoanServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@Test
	public void checkGetRotaryQuota() {
		this.loanServiceImpl.getRotaryQuota("00130443000200009410");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Loan.class);
	}

	@Test
	public void checkGetRotaryQuotaMovement() {
		this.loanServiceImpl.getRotaryQuotaMovement("00130443000200009410", "56456788");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(RotaryQuotaMove.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListRotaryQuotaMovements() {
		Mockito.when(webClient.getCollection(Movement.class)).thenReturn(Mockito.anyCollection());
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", 1, 10, null);
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", null, 10, null);
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", null, null, "$filter");
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", 1, null, "$filter");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Movement.class);
	}
}
