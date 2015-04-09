package com.bbva.net.front.core;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BbvaExceptionHandlerFactoryTest {

	private BbvaExceptionHandlerFactory bbvaExceptionHandlerFactory;

	@Before
	public void setUp() {
		this.bbvaExceptionHandlerFactory = new BbvaExceptionHandlerFactory(new ExceptionHandlerFactory() {

			@Override
			public ExceptionHandler getExceptionHandler() {
				return new BbvaExceptionHandler(null);
			}
		});
	}

	@Test
	public void checkConstructorAndGet() {
		Assert.assertNotNull(this.bbvaExceptionHandlerFactory.getExceptionHandler());
	}
}
