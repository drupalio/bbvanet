package com.bbva.net.front.test.utils;

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

/**
 * @author Entelgy
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ FacesContext.class })
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

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		// Using PowerMockito to mock the statics
		PowerMockito.mockStatic(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(facesContext);

		PowerMockito.when(facesContext.getExternalContext()).thenReturn(externalContext);
		PowerMockito.when(externalContext.getFlash()).thenReturn(flash);

		PowerMockito.when(externalContext.getRequest()).thenReturn(request);
		PowerMockito.when(externalContext.getResponse()).thenReturn(response);

		PowerMockito.when(externalContext.getSession(false)).thenReturn(httpSession);

	}
}
