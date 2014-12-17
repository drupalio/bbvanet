package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.front.controller.TermsController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "TermsController")
public class TermsControllerImpl extends AbstractBbvaController implements TermsController {

	/**
	 * 
	 */
	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	private static final long serialVersionUID = -9161774389839616910L;

	@Override
	public TermsAccountsDto getAllConditions() {

		TermsAccountsDto detalle = this.detallesCuenta.getAllConditions("numCuenta", "usuario");
		detalle.getInformacionProducto().getAlias();
		// TODO Auto-generated method stub
		return detalle;
	}

}
