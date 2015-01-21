/**
 * 
 */
package com.bbva.net.back.model.enums;

/**
 * Enum of renders
 * 
 * @author User
 */
public enum RenderAttributes {

	NUMBERBOOK("disabledNumberBook"), NUMBERCHECK("disabledNumberCheck"), BUTTONBOOK("disabledButtonBook"), CALENDAR(
			"disabledCalendar"), BUTTONDATE("disabledButtonDate");

	private String name;

	private RenderAttributes(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
