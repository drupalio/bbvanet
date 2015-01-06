package com.bbva.net.front.helper;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.faces.webflow.FlowFacesContext;

import com.bbva.czic.dto.net.EnumMonth;

public enum MessagesHelper {

	INSTANCE;

	/**
	 * @return
	 */
	public ResourceBundle getMessages() {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		return facesContext.getApplication().getResourceBundle(facesContext, "msg");
	}

	/**
	 * @param key
	 * @return
	 */
	public String getString(final String key) {
		return getMessages().getString(key);
	}

	/**
	 * @param month
	 * @return
	 */
	public String getMonthPrefix(final EnumMonth month) {
		return getString("month." + StringUtils.lowerCase(month.name()) + ".prefix");
	}

}
