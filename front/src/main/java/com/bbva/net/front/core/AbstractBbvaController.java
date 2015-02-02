package com.bbva.net.front.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.faces.webflow.FlowFacesContext;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContextHolder;

import com.bbva.net.back.model.globalposition.ProductDto;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaController implements Serializable {

	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractBbvaController.class);

	private static final long serialVersionUID = -4820146844257478597L;

	protected String DEFAULT_USER = "12345678";

	protected String DEFAULT_ACCOUNT = "12345678909876543210";

	protected enum SessionParamenterType {

		SELECTED_PRODUCT, TSEC
	}

	/**
	 * @param componenteSystemEvent
	 */
	public void preRender(final ComponentSystemEvent componentSystemEvent) {
		LOGGER.info("Rendering .... " + this.getClass().getSimpleName());
	}

	/**
	 * @param script
	 */
	protected void executeScript(final String script) {
		if (RequestContext.getCurrentInstance() != null) {
			RequestContext.getCurrentInstance().execute(script);
		}
	}

	/**
	 * @return current HttpSession from FacesContext
	 */
	protected HttpSession getSession() {
		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return (HttpSession)facesContext.getExternalContext().getSession(false);
	}

	/**
	 * @param parameter
	 * @return
	 */
	protected String getRequestParameter(final String parameter) {

		final HttpServletRequest request = (HttpServletRequest)FlowFacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		return request.getParameter(parameter);
	}

	/**
	 * @return
	 */
	protected ResourceBundle getMessages() {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return facesContext.getApplication().getResourceBundle(facesContext, "msg");
	}

	/**
	 * Redirect to new flow
	 * 
	 * @param url to initialize flow
	 */
	protected void initFlow(final String url) {

		final ExternalContext externalContext = FlowFacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(url);
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
		}
	}

	/**
	 * @param action to send in current flow
	 */
	protected void sendAction(final String action) {
		((RequestControlContext)getWebFlowRequestContext()).handleEvent(new Event(this, action));
	}

	/**
	 * @param var
	 * @param object
	 */
	protected void putVarInFlow(final String var, final Object object) {
		getWebFlowRequestContext().getFlashScope().put(var, object);
	}

	/**
	 * @return
	 */
	protected String getCurrentUser() {
		return DEFAULT_USER;
	}

	/**
	 * @return get RequestContext (WebFlow) Instance
	 */
	private org.springframework.webflow.execution.RequestContext getWebFlowRequestContext() {

		org.springframework.webflow.execution.RequestContext requestContext = RequestContextHolder.getRequestContext();
		return requestContext;
	}

	/**
	 * @return
	 */
	public ProductDto getSelectedProduct() {
		return (ProductDto)getSession().getAttribute(SessionParamenterType.SELECTED_PRODUCT.name());
	}

	/**
	 * @param selectedProduct
	 */
	public void setSelectedProduct(final ProductDto selectedProduct) {
		getSession().setAttribute(SessionParamenterType.SELECTED_PRODUCT.name(), selectedProduct);
	}

	/**
	 * @param selectEvent
	 */
	public void onProductSelected(final SelectEvent selectEvent) {
		this.setSelectedProduct((ProductDto)selectEvent.getObject());
		System.out.print("ON productSelected\n");
	}
}
