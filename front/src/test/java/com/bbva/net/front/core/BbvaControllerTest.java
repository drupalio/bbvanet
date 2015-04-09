package com.bbva.net.front.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.core.test.TestUtils;
import com.bbva.net.front.core.AbstractBbvaController.SessionParamenterType;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class BbvaControllerTest extends AbstractBbvaControllerTest {

	private CustomController customController;

	@Before
	public void init() {
		super.setUp();
		this.customController = new CustomController();
	}

	@Test
	public void checkPreRender() {
		this.customController.preRender(null);
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkExecuteStript_WithRequestContext() {
		this.customController.executeScript("alert('hola')");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkExecuteStript_WithOutRequestContext() {
		when(RequestContext.getCurrentInstance()).thenReturn(null);
		this.customController.executeScript("alert('hola')");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();

	}

	@Test
	public void checkGetSession() {
		assertNotNull(this.customController.getSession());
	}

	@Test
	public void checkGetRequestParameter() {
		assertNull(this.customController.getRequestParameter(StringUtils.EMPTY));
	}

	@Test
	public void checkGetRequest() {
		assertNotNull(this.customController.getRequest());
	}

	@Test
	public void checkGetMessages() {
		assertNotNull(this.customController.getMessages());
	}

	@Test
	public void checkInitFlow() {
		this.customController.initFlow("Flow");
	}

	@Test
	public void checkInitFlowThrowException() throws IOException {
		Mockito.doThrow(IOException.class).when(externalContext).redirect(Mockito.anyString());
		this.customController.initFlow("Flow");
	}

	@Test
	public void checkSelectProduct() {
		this.customController.setSelectedProduct(new ProductDto());
		assertNull(this.customController.getSelectedProduct());
	}

	@Test
	public void checkSelectMovement() {
		this.customController.setSelectedMovements(new MovementDto());
		assertNull(this.customController.getSelectedMovements());
	}

	@Test
	public void checkSelectUser() {
		this.customController.setDefaultUser(StringUtils.EMPTY);
		assertNotNull(this.customController.getCurrentUser());
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkSendAction() {
		this.customController.sendAction("Action");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkOnProductSelected() {

		final UIComponent uiComponent = Mockito.mock(UIComponent.class);
		final Behavior behavior = Mockito.mock(Behavior.class);
		final SelectEvent selectEvent = new SelectEvent(uiComponent, behavior, new ProductDto());
		this.customController.onProductSelected(selectEvent);
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();

	}

	@SuppressWarnings("static-access")
	@Test
	public void checkOnMovementSelected() {

		final UIComponent uiComponent = Mockito.mock(UIComponent.class);
		final Behavior behavior = Mockito.mock(Behavior.class);
		final SelectEvent selectEvent = new SelectEvent(uiComponent, behavior, new MovementDto());
		this.customController.onMovementSelected(selectEvent);
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkPutViewVar() {
		this.customController.putViewVar("var", new ProductDto());
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkPutFlowVar() {
		this.customController.putFlowVar("var", new ProductDto());
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkPutFlashVar() {
		this.customController.putFlashVar("var", new ProductDto());
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkGetViewVar() {
		this.customController.getViewVarView("var");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkGetFlowVar() {
		this.customController.getFlowVar("var");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkGetFlashVar() {
		this.customController.getFlashVar("var");
		verify(this.requestContext, atLeastOnce()).getCurrentInstance();
	}

	@Test
	public void checkEnumCoverage() {
		TestUtils.enumCodeCoverage(SessionParamenterType.class);
	}
}
