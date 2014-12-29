/**
 * 
 */
package com.bbva.net.back.dao;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 */
public interface MultiValueGroupDAO {

	/**
	 * Metodo que consulta una lista de multivalores dado un tipo.
	 * 
	 * @param typeId
	 * @return
	 */
	List<MultiValueGroup> getTypes(Integer typeId);

}
