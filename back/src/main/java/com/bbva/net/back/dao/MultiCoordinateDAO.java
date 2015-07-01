/**
 * 
 */
package com.bbva.net.back.dao;

import java.util.List;

import com.bbva.net.back.entity.MultiCoordinates;

/**
 * @author User
 */
public interface MultiCoordinateDAO {

	/**
	 * Metodo que consulta una lista de coordenadas dado un id.
	 * 
	 * @param officeId
	 * @return
	 */
	List<MultiCoordinates> getTypes(final String officeId);

}
