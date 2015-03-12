package com.bbva.net.front.test.utils;

import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Entelgy
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ FacesContext.class, ResourceBundle.class })
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

		// Using PowerMockito to mock the statics
		PowerMockito.mockStatic(FacesContext.class);

		when(FacesContext.getCurrentInstance()).thenReturn(facesContext);
		when(facesContext.getExternalContext()).thenReturn(externalContext);
		when(externalContext.getFlash()).thenReturn(flash);
		when(externalContext.getRequest()).thenReturn(request);
		when(externalContext.getResponse()).thenReturn(response);
		when(externalContext.getSession(false)).thenReturn(httpSession);
		when(facesContext.getApplication()).thenReturn(application);
		when(application.getResourceBundle(facesContext, "msg")).thenReturn(resourceBundle);
		when(application.getResourceBundle(facesContext, "i18")).thenReturn(resourceBundle);

	}

	/**
	 * @author Entelgy
	 */
	private static class CustomResource extends ResourceBundle {

		@Override
		protected Object handleGetObject(String key) {
			return StringUtils.EMPTY;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

	}
}
