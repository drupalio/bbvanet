/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.entity.MultiCoordinates;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class CityOfficePredicate extends BbvaPredicate<MultiCoordinates> {

	private String city;

	public CityOfficePredicate(final String city) {
		this.city = city;
	}

	@Override
	protected boolean eval(final MultiCoordinates office) {

		if (office == null || office.getCity() == null) {
			return false;
		}
		return office.getCity().contentEquals(this.city);
	}

}
