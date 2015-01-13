package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementsResumeFacade;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.customers.CustomerService;

/**
 * Clase que implementa cliente REST para resumen de movimientos en las cuentas
 * 
 * @author Entelgy
 */
@Facade(value = "globalMovementsFacade")
public class MovementsResumeFacadeImpl extends AbstractBbvaFacade implements MovementsResumeFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "customerService")
	private CustomerService customerService;

	@Resource(name = "globalResumeMovementsMapper")
	private GlobalResumeMovementsMapper globalResumeMovementsMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	/**
	 * Método que implementa el cliente REST para obtener el resumend de movimientos en las cuentas de un usuario
	 */
	@Override
	public GlobalResumeMovementsDto getMovementsResumeByeCustomer(final String customerId, final DateRangeDto dateRange)
			throws RestClientException {
		GlobalResumeMovementsDto globalMovements = new GlobalResumeMovementsDto();

		if (dateRange == null) {

			final List<AccMovementsResume> response = this.customerService.listAccountsMovementsResume(customerId, "");
			globalMovements.setMovementsResumeDto(globalResumeMovementsMapper.map(response));
			return globalMovements;
		} else {
			// Pasar FilQL
			String filter = "?$filter=(" + fiqlService.getFiqlQueryByDateRange(dateRange) + ")";
			final List<AccMovementsResume> response = this.customerService.listAccountsMovementsResume(customerId,
					filter);
			globalMovements.setMovementsResumeDto(globalResumeMovementsMapper.map(response));
			return globalMovements;
		}
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/
	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

}
