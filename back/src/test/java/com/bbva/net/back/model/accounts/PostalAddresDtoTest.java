package com.bbva.net.back.model.accounts;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PostalAddresDtoTest extends AbstractBbvaDTOTest<PostalAddresDto> {

	private PostalAddresDto postalAddres;

	public PostalAddresDtoTest() {
		this.postalAddres = new PostalAddresDto("hayi", "2222");
	}

	@Override
	protected PostalAddresDto getInstance() {
		return new PostalAddresDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		PostalAddresDto postalInEquals = new PostalAddresDto("hayi", "2222");
		// Cuando el objeto es nulo
		this.postalAddres.equals(null);
		// Cuando el dto comparado no es el mismo
		this.postalAddres.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.postalAddres.equals(postalInEquals);
		// el NombreOficina del objeto es diferente
		postalInEquals.setNombreOficina("Har");
		this.postalAddres.equals(postalInEquals);
		// el DireccionPostal del objeto es diferente
		postalInEquals.setDireccionPostal("123");
		this.postalAddres.equals(postalInEquals);
	}
}
