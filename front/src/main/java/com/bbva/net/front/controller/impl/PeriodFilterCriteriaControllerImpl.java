package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.controller.PeriodFilterCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "periodFilterCriteriaController")
public class PeriodFilterCriteriaControllerImpl extends AbstractBbvaController implements
		PeriodFilterCriteriaController {

	private static final Integer LIST_CHECK_STATUS = 3;

	private MultiValueGroup period;

	private static final long serialVersionUID = -8550174788177930813L;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Override
	public List<MultiValueGroup> getListMultiValuePeriod() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	public void onComboSelectedAccount() {

		System.out.println("HOLA TIA");

	}

	public MultiValueGroup getPeriod() {
		return period;
	}

	public void setPeriod(MultiValueGroup period) {
		this.period = period;
	}

}
