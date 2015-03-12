package com.bbva.net.webservices.cards;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.cards.impl.CardServiceImpl;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class CardsCustomerServiceImplTest extends AbstractBbvaRestClientTest {

	private CardServiceImpl cardServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get CardServiceImpl instance
		cardServiceImpl = (CardServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new CardServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@Test
	public void checkGetCreditCardCharges_norFilter() {
		Mockito.when(webClient.getCollection(CardCharge.class)).thenReturn(Mockito.anyCollection());
		List<CardCharge> lista = cardServiceImpl.getCreditCardCharges("", "", "", "", "");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(CardCharge.class);
	}

	@Test
	public void checkGetCreditCardCharges_Filter() {
		Mockito.when(webClient.getCollection(CardCharge.class)).thenReturn(Mockito.anyCollection());
		List<CardCharge> lista = cardServiceImpl.getCreditCardCharges("123", "filter", "", "", "");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(CardCharge.class);
	}

}
