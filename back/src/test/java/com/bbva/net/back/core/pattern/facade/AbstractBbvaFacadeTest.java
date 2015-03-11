package com.bbva.net.back.core.pattern.facade;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

public class AbstractBbvaFacadeTest {

	@Test
	public void checkAbstractBbvaFacade() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {

		final AbstractBbvaFacade facade = new AbstractBbvaFacade() {

			private static final long serialVersionUID = 5773722594275787845L;
		};

		Assert.assertNotNull(facade);
	}

}
