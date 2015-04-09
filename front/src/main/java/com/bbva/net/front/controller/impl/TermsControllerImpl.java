package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.front.controller.TermsController;
import com.bbva.net.front.core.AbstractBbvaController;

public class TermsControllerImpl extends AbstractBbvaController implements TermsController {

	/**
	 * 
	 */
	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	private static final long serialVersionUID = -9161774389839616910L;

	@Override
	public TermsAccountsDto getAllConditions() {

		try {
			TermsAccountsDto detalle = this.detallesCuenta.getAllConditions(super.getSelectedProduct().getProductId());
			return detalle;
		} catch (final Exception exception) {
			return new TermsAccountsDto();
		}

	}

	/**
	 * @param detallesCuenta the detallesCuenta to set
	 */
	public void setDetallesCuenta(TermasAccountsFacade detallesCuenta) {
		this.detallesCuenta = detallesCuenta;
	}

}
