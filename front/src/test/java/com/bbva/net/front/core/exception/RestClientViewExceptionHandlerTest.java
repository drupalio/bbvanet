package com.bbva.net.front.core.exception;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.View;
import org.springframework.webflow.execution.ViewFactory;

public class RestClientViewExceptionHandlerTest {

	private RequestControlContext requestControlContext;

	@Before
	public void init() {
		this.requestControlContext = Mockito.mock(RequestControlContext.class);
	}

	@Test
	public void checkcanHandle_OK() {

		assertNotNull(new RestClientViewExceptionHandler().canHandle(new FlowExecutionException(StringUtils.EMPTY,
				StringUtils.EMPTY, StringUtils.EMPTY)));
	}

	@Test(expected = NullPointerException.class)
	public void checkHandle_ThrowException() {

		// Invoke and Throw exception
		new RestClientViewExceptionHandler().handle(new FlowExecutionException(StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY), null);
	}

	@Test
	public void checkHandle_ViewState() throws IOException {

		// Create Mocks
		final Flow flow = new Flow("1234");
		final ViewFactory viewFactory = Mockito.mock(ViewFactory.class);
		final View view = Mockito.mock(View.class);
		Mockito.when(viewFactory.getView(requestControlContext)).thenReturn(view);
		Mockito.when(requestControlContext.getCurrentState()).thenReturn(new ViewState(flow, "12356", viewFactory));

		// Invoke to handle
		new RestClientViewExceptionHandler().handle(new FlowExecutionException(StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY), requestControlContext);

		// Verify
		Mockito.verify(view, Mockito.atLeastOnce()).render();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkHandle_ThrowIOException() throws IOException {

		// Create Mocks
		final Flow flow = new Flow("1234");
		final ViewFactory viewFactory = Mockito.mock(ViewFactory.class);
		final View view = Mockito.mock(View.class);
		Mockito.when(viewFactory.getView(requestControlContext)).thenThrow(IOException.class);
		Mockito.when(requestControlContext.getCurrentState()).thenReturn(new ViewState(flow, "12356", viewFactory));

		// Invoke to handle
		new RestClientViewExceptionHandler().handle(new FlowExecutionException(StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY), requestControlContext);

		// Verify Never
		Mockito.verify(view, Mockito.never()).render();
	}

	@Test
	public void checkHandle_NotViewState() {

		new RestClientViewExceptionHandler().handle(new FlowExecutionException(StringUtils.EMPTY, StringUtils.EMPTY,
				StringUtils.EMPTY), requestControlContext);
	}

}
