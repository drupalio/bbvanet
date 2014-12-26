package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.HeaderControllerFacade;
import com.bbva.net.back.model.executive.ExecutiveDto;
import com.bbva.net.back.model.office.OfficeDto;

@Facade(value = "headerControllerFacade")
public class HeaderControllerFacadeImpl extends AbstractBbvaFacade implements HeaderControllerFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451180024940294464L;

	@Override
	public ExecutiveDto getExecutive() {
		OfficeDto off = new OfficeDto();
		off.setAddres("calle 93-52");
		off.setName("Edificio de la calle93");
		ExecutiveDto exc = new ExecutiveDto();
		exc.setCoordenadas("@4.6768597,-74.0525267,19z");
		exc.setMail("Jhon00021@gmail.com");
		exc.setName("Jhon J Velasquez J");
		exc.setOffice(off);
		exc.setPhone("3080808");
		return exc;
	}

}
