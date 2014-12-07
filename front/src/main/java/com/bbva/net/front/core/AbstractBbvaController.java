package com.bbva.net.front.core;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.faces.webflow.FlowFacesContext;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaController implements Serializable {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractBbvaController.class);

	private static final long serialVersionUID = -4820146844257478597L;

	protected String DEFAULT_USER = "123";

	/**
	 * @param componenteSystemEvent
	 */
	public void preRender(ComponentSystemEvent componenteSystemEvent) {
		LOGGER.info("Rendering .... " + this.getClass().getSimpleName());
	}

	/**
	 * @param script
	 */
	protected void executeScript(final String script) {
		RequestContext.getCurrentInstance().execute(script);
	}

	/**
	 * @return current HttpSession from FacesContext
	 */
	protected HttpSession getSession() {
		final FacesContext fCtx = FlowFacesContext.getCurrentInstance();
		return (HttpSession)fCtx.getExternalContext().getSession(true);
	}

	/**
	 * @return
	 */
	protected ResourceBundle getMessages() {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return facesContext.getApplication().getResourceBundle(facesContext, "msg");
	}

	protected String getCurrentUser() {
		return DEFAULT_USER;
	}

}
