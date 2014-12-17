package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.DetailConditionsDto;
import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.back.model.accounts.PostalAddresDto;
import com.bbva.net.back.model.accounts.ProductInformationDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

@Facade(value = "TermsFacade")
public class TermasAccountsFacadeImpl extends AbstractBbvaFacade implements TermasAccountsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227089419683594718L;

	@Override
	public TermsAccountsDto getAllConditions(String numCuenta, String usuario) {

		TermsAccountsDto prueba = new TermsAccountsDto();
		ProductInformationDto informacionProducto = new ProductInformationDto("Cuenta Ahorro 1",
				"0013-0073-00-0200108391", "Cuenta Ahorro");
		InvolvedDto intervinientes = new InvolvedDto("Maricale Gonzales Hernandez", "Marthina Ruis Bravo", "SOLIDARIOS");
		DetailConditionsDto detalleCondiciones = new DetailConditionsDto("Plan Clasico", "Descripcion del producto",
				"15/08/2014", "Comision de mantenimiento");
		PostalAddresDto direccionPostal = new PostalAddresDto("OFICINA 223 ANTONIO",
				"LOREM IPSIM. 61 1, 2A 30-23 ANTONIO BOGOTA COLOMBIA");
		prueba.setInformacionProducto(informacionProducto);
		prueba.setDetalleCondiciones(detalleCondiciones);
		prueba.setIntervinientes(intervinientes);
		prueba.setDireccionPostal(direccionPostal);

		// TODO Auto-generated method stub
		return prueba;
	}

}
