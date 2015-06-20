package com.bbva.net.front.core;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.event.SystemEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class BbvaExceptionHandlerTest extends AbstractBbvaControllerTest {

	private BbvaExceptionHandler bbvaExceptionHandler;

	@Override
	@Before
	public void setUp() {

		super.setUp();

		this.bbvaExceptionHandler = new BbvaExceptionHandler(new ExceptionHandler() {

			@Override
			public void processEvent(SystemEvent exceptionQueuedEvent) throws AbortProcessingException {
			}

			@Override
			public boolean isListenerForSource(Object source) {
				return false;
			}

			@Override
			public void handle() throws FacesException {
			}

			@Override
			public Iterable<ExceptionQueuedEvent> getUnhandledExceptionQueuedEvents() {
				return getHandledExceptionQueuedEvents();
			}

			@Override
			public Throwable getRootCause(Throwable t) {
				return null;
			}

			@Override
			public Iterable<ExceptionQueuedEvent> getHandledExceptionQueuedEvents() {
				final ExceptionQueuedEvent exceptionQueuedEvent = new ExceptionQueuedEvent(
						new ExceptionQueuedEventContext(facesContext, new NullPointerException()));
				final ArrayList<ExceptionQueuedEvent> list = new ArrayList<ExceptionQueuedEvent>();
				list.add(exceptionQueuedEvent);
				return list;
			}

			@Override
			public ExceptionQueuedEvent getHandledExceptionQueuedEvent() {
				return getHandledExceptionQueuedEvents().iterator().next();
			}
		});

	}

	@Test
	public void checkBbvaExceptionHandlerWithExceptions() {

		Assert.assertNotNull(this.bbvaExceptionHandler.getHandledExceptionQueuedEvent());

		this.bbvaExceptionHandler.handle();

	}

	// @Test(expected = NullPointerException.class)
	public void checkBbvaExceptionThrowException() {

		Mockito.doThrow(NullPointerException.class).when(this.facesContext).renderResponse();

		this.bbvaExceptionHandler.handle();

	}

	@Test
	public void checkBbvaExceptionHandleUnexpected() {

		String result = this.bbvaExceptionHandler.handleUnexpected(facesContext, new RuntimeException());
		Assert.assertNotNull(result);
		verify(this.facesContext, never()).renderResponse();

	}
}
