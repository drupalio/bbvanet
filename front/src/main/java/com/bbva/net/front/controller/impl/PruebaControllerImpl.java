package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.Prueba;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.PruebaFacade;
import com.bbva.net.back.model.globalposition.Cuenta;
import com.bbva.net.front.controller.PruebaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * 
 *
 */
@Controller
public class PruebaControllerImpl extends AbstractBbvaController implements
		PruebaController {

	private static final long serialVersionUID = -3131447320234866206L;

	@Resource(name = "pruebaFacade")
	private transient PruebaFacade pruebaFacade;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	public void preRender(ComponentSystemEvent event) {
		System.out.println("");
	}

	public Prueba createPrueba() {
		return this.pruebaFacade.getPrueba();
	}

	public Prueba refreshPrueba() {
		final Prueba prueba = new Prueba();
		prueba.setName("AAAAADIOS JUAN");
		return prueba;
	}

	public Prueba getPrueba() {
		final Prueba prueba = new Prueba();
		prueba.setName("AN");
		return prueba;
	}

	public void click(ActionEvent actionEvent) {
		System.out.println("");
	}

	public void onComboChange() {

		System.out.println("change"); // message is shown only the first time
										// the combo is changed
	}

	public void onKeyUp() {

		System.out.println("Key Up"); // message is shown only the first time
										// the combo is changed
	}
	
	public List<Cuenta> getCuentas() {
		

		final List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas.add(new Cuenta("cuenta ahorooro 1", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 2", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 3", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 4", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 5", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 6", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 7", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 8", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 9", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		cuentas.add(new Cuenta("cuenta ahorooro 10", "0013-0073-00-0200108391", "Cuenta ahorro", "$999.999.999"));
		
		
		return cuentas;
	}
	

	public void setGlobalPositionFacade(
			GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setPruebaFacade(PruebaFacade pruebaFacade) {
		this.pruebaFacade = pruebaFacade;
	}

}
