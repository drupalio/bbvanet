package com.bbva.net.front.controller.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class ApplicationControllerTest extends AbstractBbvaControllerTest {

	private ApplicationControllerImpl applicationControler;

	private MultiValueGroupFacade multiValueGroupFacade;

	@Before
	public void init() {

		super.setUp();

		this.applicationControler = new ApplicationControllerImpl();
		this.multiValueGroupFacade = mock(MultiValueGroupFacade.class);
		this.applicationControler.setMultiValueGroupFacade(multiValueGroupFacade);
	}

	@Test
	public void checkInit() {
		this.applicationControler.init();
		Assert.assertNotNull(this.applicationControler.getLikes());
	}

	@Test
	public void checkGetListMultiValueLikes_OK() {

		when(this.multiValueGroupFacade.getMultiValueTypes(Mockito.anyInt())).thenReturn(
				new ArrayList<MultiValueGroup>());

		Assert.assertNotNull(this.applicationControler.getListMultiValueLikes());

		verify(this.multiValueGroupFacade).getMultiValueTypes(Mockito.anyInt());

	}

	@SuppressWarnings("unchecked")
	@Test(expected = BadRequestException.class)
	public void checkGetListMultiValueLikes_ThrowException() {

		when(this.multiValueGroupFacade.getMultiValueTypes(1)).thenThrow(BadRequestException.class);

		this.applicationControler.getListMultiValueLikes();

	}
}
