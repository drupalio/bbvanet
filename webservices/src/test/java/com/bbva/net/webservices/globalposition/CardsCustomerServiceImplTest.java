package com.bbva.net.webservices.globalposition;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.net.webservices.cards.impl.CardServiceImpl;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;

public class CardsCustomerServiceImplTest extends AbstractBbvaRestService {

	@Value("${rest.cardsCharges.url}")
	private String URL_CARDCHARGES;

	@Value("${rest.base.cards.url}")
	protected String URL_BASE_CARDS;

	private CardServiceImpl cardChargeServiceImpl;

	private WebClient wc;

	@Resource(name = "factoryBean")
	private JAXRSClientFactoryBean factoryBean;

	@Before
	public void init() {
		this.cardChargeServiceImpl = new CardServiceImpl();
		this.wc = Mockito.mock(WebClient.class);
		this.factoryBean = Mockito.mock(JAXRSClientFactoryBean.class);
		this.factoryBean.setAddress(Mockito.anyString());
	}

	@Test
	public void checkGetCreditCardCharges_OK() {

		// wc = getJsonWebClient(URL_BASE_CARDS + "2032" + URL_CARDCHARGES);
		// List<CardCharge> lista = cardChargeServiceImpl.getCreditCardCharges("2032", "", "", "", "");
	}
}
