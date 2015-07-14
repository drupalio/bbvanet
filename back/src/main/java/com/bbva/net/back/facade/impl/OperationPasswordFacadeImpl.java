package com.bbva.net.back.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.jee.arq.spring.core.servicios.modulooperaciones.ServicioModuloOperacionesImpl;
import com.bbva.jee.arq.spring.core.servicios.modulooperaciones.excepciones.ArqSpringOperacionesExcepcion;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.OperationPasswordFacade;

@Facade(value = "operationPasswordFacade")
public class OperationPasswordFacadeImpl extends AbstractBbvaFacade implements
		OperationPasswordFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4410736662686921755L;

	@Value("${ldap.pais}")
	private String PAIS;

	@Value("${ldap.bank}")
	private String BANCO;

	@Value("${ldap.numberarrmpts}")
	private String NUMBERATTMPTS;
	
	@Autowired
	private ServicioModuloOperacionesImpl servicioModuloOperaciones;

	@Override
	public boolean validateOperation(String user, String operationPass) {
		LOGGER.info("Se Valida clave de operaciones en OperationPasswordFacadeImpl, Se prepara para llamar al metodo checkoperpwdUserAPI de ClienteOperaciones con datos User: "
				+ user
				+ " ClaveOperaciones: "
				+ operationPass
				+ " Pais "
				+ PAIS
				+ " Banco "
				+ BANCO
				+ " intento numero: "
				+ NUMBERATTMPTS);
		try {
			servicioModuloOperaciones.checkoperpwdUserAPI(user, operationPass,
					PAIS, BANCO, Integer.parseInt(NUMBERATTMPTS));
			return true;
		} catch (ArqSpringOperacionesExcepcion e) {
			return false;
		}
	}

}
