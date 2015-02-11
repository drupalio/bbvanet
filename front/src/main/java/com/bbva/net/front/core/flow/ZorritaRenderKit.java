package com.bbva.net.front.core.flow;

import java.lang.reflect.Constructor;

import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitWrapper;
import javax.faces.render.ResponseStateManager;

import org.springframework.beans.BeanUtils;
import org.springframework.faces.webflow.FlowRenderKit;
import org.springframework.faces.webflow.FlowResponseStateManager;
import org.springframework.faces.webflow.JsfRuntimeInformation;
import org.springframework.faces.webflow.JsfUtils;
import org.springframework.util.ClassUtils;

public class ZorritaRenderKit extends RenderKitWrapper {

	private final RenderKit wrapped;

	private final ResponseStateManager flowViewResponseStateManager;

	public ZorritaRenderKit(RenderKit wrapped) {
		this.wrapped = wrapped;
		this.flowViewResponseStateManager = initResponseStateManager(wrapped.getResponseStateManager());
	}

	private ResponseStateManager initResponseStateManager(ResponseStateManager wrapped) {
		if (!JsfRuntimeInformation.isMyFacesPresent() && !JsfRuntimeInformation.isMyFacesInUse()) {
			return new FlowResponseStateManager(wrapped);
		}
		Constructor<?> constructor;
		try {
			String className = "org.springframework.faces.webflow.MyFacesFlowResponseStateManager";
			Class<?> clazz = ClassUtils.forName(className, FlowRenderKit.class.getClassLoader());
			constructor = ClassUtils.getConstructorIfAvailable(clazz, FlowResponseStateManager.class);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Could not initialize MyFacesFlowResponseStateManager", e);
		} catch (LinkageError e) {
			throw new IllegalStateException("Could not initialize MyFacesFlowResponseStateManager", e);
		}
		return (ResponseStateManager)BeanUtils.instantiateClass(constructor, new FlowResponseStateManager(wrapped));
	}

	@Override
	public RenderKit getWrapped() {
		return this.wrapped;
	}

	/**
	 * Returns an instance of {@link FlowResponseStateManager} in a JSF 2 environment or returns the delegates's
	 * ResponseStateManager instance otherwise.
	 */
	@Override
	public ResponseStateManager getResponseStateManager() {
		if (JsfUtils.isFlowRequest()) {
			return this.flowViewResponseStateManager;
		}
		return this.wrapped.getResponseStateManager();
	}
}
