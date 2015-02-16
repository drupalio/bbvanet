package com.bbva.net.front.core.exception;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public class RestClientViewExceptionHandler implements FlowExecutionExceptionHandler {

	protected static final Log LOGGER = I18nLogFactory.getLog(RestClientViewExceptionHandler.class);

	@Override
	public boolean canHandle(FlowExecutionException exception) {
		return true;
	}

	@Override
	public void handle(FlowExecutionException exception, RequestControlContext context) {

		LOGGER.info("Handle RestClientException ...........");

		Object testState = context.getCurrentState();

		if (testState instanceof ViewState) {
			ViewState viewState = (ViewState)testState;
			try {
				viewState.getViewFactory().getView(context).render();
			} catch (IOException e) {
				// Properly handle rendering errors here
			}
		}
	}

}
