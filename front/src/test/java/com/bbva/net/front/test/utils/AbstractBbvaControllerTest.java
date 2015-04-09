package com.bbva.net.front.test.utils;

import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.primefaces.context.RequestContext;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;

/**
 * @author Entelgy
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ FacesContext.class, RequestContext.class, RequestContextHolder.class, ResourceBundle.class,
		EnumProductType.class, EnumCheckStatus.class })
public abstract class AbstractBbvaControllerTest {

	@Mock
	protected FacesContext facesContext;

	@Mock
	protected ExternalContext externalContext;

	@Mock
	protected Flash flash;

	@Mock
	protected HttpServletRequest request;

	@Mock
	protected HttpServletResponse response;

	@Mock
	protected HttpSession httpSession;

	@Mock
	protected Application application;

	@Mock
	protected RequestContextHolder requestContextHolder;

	@Mock
	protected RequestControlContext webFlowRequestContext;

	@Mock
	protected RequestContext requestContext;

	@Mock
	protected MutableAttributeMap<Object> scope;

	@Mock
	protected EnumProductType enumProductType;

	@Mock
	protected EnumCheckStatus enumCheckStatus;

	protected ResourceBundle resourceBundle;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		this.resourceBundle = new CustomResource();
		initFacesContext();

	}

	/**
	 * Initialize: FacesContext, ExternalContext and Application
	 */
	protected void initFacesContext() {

		// creating an unknown enum value
		enumProductType = PowerMockito.mock(EnumProductType.class);
		Whitebox.setInternalState(enumProductType, "name", "Account");
		when(enumProductType.value()).thenReturn("Account");

		enumCheckStatus = PowerMockito.mock(EnumCheckStatus.class);
		Whitebox.setInternalState(enumCheckStatus, "name", "Account");
		when(enumCheckStatus.getValue()).thenReturn("check");

		// Using PowerMockito to mock the statics
		PowerMockito.mockStatic(FacesContext.class);
		PowerMockito.mockStatic(RequestContextHolder.class);
		PowerMockito.mockStatic(RequestContext.class);

		when(FacesContext.getCurrentInstance()).thenReturn(facesContext);
		when(facesContext.getExternalContext()).thenReturn(externalContext);
		when(externalContext.getFlash()).thenReturn(flash);
		when(externalContext.getRequest()).thenReturn(request);
		when(externalContext.getResponse()).thenReturn(response);
		when(externalContext.getSession(false)).thenReturn(httpSession);
		when(facesContext.getApplication()).thenReturn(application);
		when(application.getResourceBundle(facesContext, "msg")).thenReturn(resourceBundle);
		when(application.getResourceBundle(facesContext, "i18")).thenReturn(resourceBundle);
		when(RequestContext.getCurrentInstance()).thenReturn(requestContext);

		final Map<Object, Object> attributes = new HashMap<Object, Object>();
		attributes.put(RequestContext.class.getName(), requestContext);

		when(facesContext.getAttributes()).thenReturn(attributes);
		when(RequestContextHolder.getRequestContext()).thenReturn(webFlowRequestContext);
		when(webFlowRequestContext.getViewScope()).thenReturn(scope);
		when(webFlowRequestContext.getFlowScope()).thenReturn(scope);
		when(webFlowRequestContext.getFlashScope()).thenReturn(scope);
	}

	/**
	 * @author Entelgy
	 */
	private static class CustomResource extends ResourceBundle {

		@Override
		protected Object handleGetObject(String key) {
			return key;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

	}
}
