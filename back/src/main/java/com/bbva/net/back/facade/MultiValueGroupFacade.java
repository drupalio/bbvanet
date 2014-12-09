/**
 * 
 */
package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 *
 */
public interface MultiValueGroupFacade {

	/**
	 * Metodo que consulta un multivalor dado su id.
	 * 
	 * @param Integer
	 *            typeId id del multivalor
	 * @return Objeto con lista de Multivalores
	 * 
	 */

	List<MultiValueGroup> getMultiValueTypes(final Integer typeId);

}
