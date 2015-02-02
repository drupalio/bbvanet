package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.webservices.products.ProductsService;

@Facade(value = "TermsFacade")
public class TermasAccountsFacadeImpl extends AbstractBbvaFacade implements TermasAccountsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227089419683594718L;

	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "conditionsMapper")
	private ConditionsMapper mapper;

	@Override
	public TermsAccountsDto getAllConditions(String numCuenta) {

		// TermsAccountsDto prueba = new TermsAccountsDto();
		//
		// ProductInformationDto informacionProducto = new ProductInformationDto("Cuenta Ahorro 1",
		// "0013-0073-00-0200108391", "Cuenta Ahorro");
		// InvolvedDto intervinientes = new InvolvedDto("Maricale Gonzales Hernandez", "Marthina Ruis Bravo", "SOLIDARIOS");
		// DetailConditionsDto detalleCondiciones = new DetailConditionsDto("Plan Clasico", "Descripcion del producto",
		// "15/08/2014", "Comision de mantenimiento");
		// PostalAddresDto direccionPostal = new PostalAddresDto("OFICINA 223 ANTONIO",
		// "LOREM IPSIM. 61 1, 2A 30-23 ANTONIO BOGOTA COLOMBIA");
		// prueba.setInformacionProducto(informacionProducto);
		// prueba.setDetalleCondiciones(detalleCondiciones);
		// prueba.setIntervinientes(intervinientes);
		// prueba.setDireccionPostal(direccionPostal);
		// Se quema numero para realizar prueba
		// numCuenta = "00130073000296247953";
		final Conditions condiciones = this.productsService.getConditions(numCuenta);

		return mapper.map(condiciones);
	}

}
