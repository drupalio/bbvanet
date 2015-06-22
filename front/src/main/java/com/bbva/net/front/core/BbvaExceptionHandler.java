package com.bbva.net.front.core;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.net.front.core.exception.RestClientViewExceptionHandler;

public class BbvaExceptionHandler extends ExceptionHandlerWrapper {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BbvaExceptionHandler.class);

	private final ExceptionHandler wrapped;

	@Autowired
	private RestClientViewExceptionHandler restClientViewExceptionHandler;

	public BbvaExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {

		// List<FacesMessage> mensajes = FacesContext.getCurrentInstance().getMessageList();
		// LOGGER.info("Mensajes " + mensajes);
		// FacesMessage mensaje = mensajes.get(0);
		// LOGGER.info("Mensajes " + mensaje);
		// final Iterator<ExceptionQueuedEvent> i = FacesContext.getCurrentInstance().getExceptionHandler()
		// .getUnhandledExceptionQueuedEvents().iterator();

		// while (i.hasNext()) {
		// ExceptionQueuedEvent event = i.next();
		// ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();
		// // get the exception from context
		// Throwable t = context.getException();
		// // final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		// // final Map<String, Object> requestMap = externalContext.getRequestMap();
		// // final ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication()
		// // .getNavigationHandler();
		// // here you do what ever you want with exception
		//
		// //
		// // LOGGER.error("Severe Exception Occured");
		// // // log.log(Level.SEVERE, "Critical Exception!", t);
		// // // red6irect error page
		// // requestMap.put("exceptionMessage", t.getMessage());
		// // nav.performNavigation("/TestPRoject/error.xhtml");
		// FacesContext.getCurrentInstance().renderResponse();
		// // remove the comment below if you want to report the error in a
		// // jsf error mes6sage
		// // JsfUtil.addErrorMessage(t.getMessage());
		// i.remove();
		// }
		// parent handle
		// getWrapped().handle();
	}

	public String handleUnexpected(FacesContext facesContext, final Throwable t) {

		return "jsftoolkit.exception.UncheckedException";
	}
}
