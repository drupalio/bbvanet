package com.bbva.net.webservices.executives;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.executives.impl.ExecutiveServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class ExecutiveServiceImplTest extends AbstractBbvaRestClientTest {

	private ExecutiveServiceImpl executiveServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get CardServiceImpl instance
		executiveServiceImpl = (ExecutiveServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new ExecutiveServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@SuppressWarnings("unchecked")
	@Test
	public void checkGetExecutive_notFilter() {
		Mockito.when(webClient.get(Executive.class)).thenReturn(Mockito.any(Executive.class));
		executiveServiceImpl.getExecutive(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Executive.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkGetExecutive_Filter() {
		Mockito.when(webClient.get(Executive.class)).thenReturn(Mockito.any(Executive.class));
		executiveServiceImpl.getExecutive("123", "filter", StringUtils.EMPTY, StringUtils.EMPTY);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Executive.class);
	}

}
