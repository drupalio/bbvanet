package com.bbva.net.back.model;

import com.bbva.net.back.model.globalposition.Cuenta;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CuentaTest extends AbstractBbvaDTOTest<Cuenta> {

	@Override
	protected Cuenta getInstance() {
		return new Cuenta();
	}

}
