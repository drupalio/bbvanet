package com.bbva.net.back.facade;

import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;

/**
 * fachada de servicio que devuelde el ejecutivo del clientw
 * 
 * @author Entelgy
 */
public interface HeaderFacade {

	/**
	 * @return
	 */
	ExecutiveDto getExecutive();

	CustomerDto getCustomer();

}
