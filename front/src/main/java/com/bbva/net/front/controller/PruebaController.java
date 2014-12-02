package com.bbva.net.front.controller;

import org.springframework.web.client.RestClientException;

import com.bbva.net.back.entity.Prueba;

/**
 * 
 * @author Entelgy
 *
 */
public interface PruebaController {
	
	/**
	 * 
	 * @return
	 * @throws RestClientException 
	 */
	Prueba createPrueba() ;

	/**
	 * 
	 * @return
	 */
	Prueba refreshPrueba();

}
