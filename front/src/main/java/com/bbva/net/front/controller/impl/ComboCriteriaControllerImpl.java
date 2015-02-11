package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.front.controller.ComboCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * Clase controladora que obtiene itmes combo filtro
 * 
 * @author Entelgy
 */
@Controller(value = "comboCriteriaController")
@Scope(value = "globalSession")
public class ComboCriteriaControllerImpl extends AbstractBbvaController implements ComboCriteriaController {

	/**
	 * 
	 */
	private static final Integer LIST_CHECK_STATUS = 3;

	/**
	 * 
	 */
	private static final Integer LIST_CHECKBOOK_STATUS = 2;

	/**
	 * 
	 */
	private EnumPeriodType period;

	/**
	 * 
	 */
	private List<MultiValueGroup> multiValuePeriod;

	/**
	 * 
	 */
	private List<MultiValueGroup> multiValueList;

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
	 * Inicialización de Combos
	 */
	@PostConstruct
	public void init() {
		this.multiValuePeriod = this.getListMultiValuePeriod();
		this.multiValueList = this.getListMultiValueChecks();
	}

	/**
	 * Método que obtiene los items del combo filtro en grafica cuentas
	 */
	@Override
	public List<MultiValueGroup> getListMultiValuePeriod() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	/**
	 * Método que obtiene los items del combo en cheques
	 */
	@Override
	public List<MultiValueGroup> getListMultiValueChecks() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECKBOOK_STATUS);
	}

	// ************* Getters Methods *************

	/**
	 * @return
	 */
	public List<MultiValueGroup> getMultiValuePeriod() {
		return multiValuePeriod;
	}

	/**
	 * @return
	 */

	public List<MultiValueGroup> getMultiValueList() {
		return multiValueList;
	}

	/**
	 * @return
	 */
	public EnumPeriodType getPeriod() {
		return period;
	}

}
