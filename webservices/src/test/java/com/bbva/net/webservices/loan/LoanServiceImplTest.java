package com.bbva.net.webservices.loan;

import org.junit.Assert;
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
		// Get LoanServiceImpl instance
		loanServiceImpl = (LoanServiceImpl)this.restService;
	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new LoanServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@Test
	public void checkGetRotaryQuota() {
		Loan loan = new Loan();
		// Mockito
		Mockito.when(this.loanServiceImpl.getRotaryQuota("00130443000200009410")).thenReturn(loan);
		// Llamar método getRotaryQuota
		loan = this.loanServiceImpl.getRotaryQuota("00130443000200009410");
		// Verificar que no venga nulo
		Assert.assertNotNull(loan);
		// Verificar el get del servicio
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Loan.class);
	}

	@Test
	public void checkGetRotaryQuotaMovement() {
		RotaryQuotaMove rotary = new RotaryQuotaMove();
		// Mockito
		Mockito.when(this.loanServiceImpl.getRotaryQuotaMovement("00130443000200009410", "5645535")).thenReturn(rotary);
		// Llamar método getRotaryQuota
		rotary = this.loanServiceImpl.getRotaryQuotaMovement("00130443000200009410", "56456788");
		// Verificar que no venga nulo
		Assert.assertNotNull(rotary);
		// Verificar el get del servicio
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(RotaryQuotaMove.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListRotaryQuotaMovements() {
		// Mockito
		Mockito.when(webClient.getCollection(Movement.class)).thenReturn(Mockito.anyCollection());
		// Llamar método listRotaryQuotaMovements
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", "1", 10, null);
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", null, 10, null);
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", null, null, "$filter");
		this.loanServiceImpl.listRotaryQuotaMovements("00130443000200009410", "1", null, "$filter");
		// Verificar el get del servicio
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Movement.class);
	}
}
