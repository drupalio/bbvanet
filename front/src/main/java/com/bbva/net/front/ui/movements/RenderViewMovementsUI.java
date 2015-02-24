package com.bbva.net.front.ui.movements;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.bbva.net.back.model.enums.RenderAttributes;

public class RenderViewMovementsUI implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	public void init() {
		renderComponents = new HashMap<String, Boolean>();
		// Tables check and movements
		getRenderComponents().put(RenderAttributes.CHECKTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), true);

		// Footers
		getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.toString(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);

		// Title movemens and checks
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), true);
		getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), false);

		getRenderComponents().put(RenderAttributes.CALENDAR.toString(), true);
		getRenderComponents().put(RenderAttributes.BUTTONDATE.toString(), true);
		getRenderComponents().put(RenderAttributes.BUTTONBALANCE.toString(), true);
		// Filtros
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), false);
		getRenderComponents().put(RenderAttributes.BALANCEFILTER.toString(), false);
		getRenderComponents().put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), false);
		getRenderComponents().put(RenderAttributes.MOVEMENTSFILTER.toString(), false);

		getRenderComponents().put(RenderAttributes.CALENDARCHECK.toString(), true);
		getRenderComponents().put(RenderAttributes.BUTTONDATECHECK.toString(), true);

		getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), true);
		getRenderComponents().put(RenderAttributes.STATUS.toString(), true);
		getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), true);
		getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), true);

		getRenderComponents().put(RenderAttributes.FILTERSTATUS.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), false);

	}

	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

}
