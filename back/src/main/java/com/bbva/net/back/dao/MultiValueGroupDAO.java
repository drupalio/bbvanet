/**
 * 
 */
package com.bbva.net.back.dao;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 *
 */
public interface MultiValueGroupDAO {
	
	
	/***
	 * Metodo que consulta una lista de multivalores dado un tipo.
	 * @param identificador de tipos
	 * @return List MultiValueGroup 
	 * @throws Exception 
	 * **/
	public List<MultiValueGroup> getTypes(Integer typeId) throws Exception;

}
