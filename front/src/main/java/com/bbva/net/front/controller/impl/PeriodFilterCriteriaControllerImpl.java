package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.front.controller.PeriodFilterCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * Clase controladora que obtiene itmes combo filtro
 * 
 * @author Entelgy
 */
@Controller(value = "periodFilterCriteriaController")
public class PeriodFilterCriteriaControllerImpl extends AbstractBbvaController implements
		PeriodFilterCriteriaController {

	/**
	 * 
	 */
	private static final Integer LIST_CHECK_STATUS = 3;

	/**
	 * 
	 */
	private EnumPeriodType period;

	// private String period;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8550174788177930813L;

	/**
	 * Facade MultivalueGroups
	 */
	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	/**
	 * Método que obtiene los items del combo filtro en grafica cuentas
	 */
	@Override
	public List<MultiValueGroup> getListMultiValuePeriod() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	// public String getPeriod() {
	// return period;
	// }
	//
	// public void setPeriod(String period) {
	// this.period = period;
	// }

	/**
	 * @return
	 */
	public EnumPeriodType getPeriod() {
		return period;
	}

	/**
	 * @param period
	 */
	public void setPeriod(final EnumPeriodType period) {
		this.period = period;
	}

}
