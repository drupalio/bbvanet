package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ProductTest extends AbstractBbvaDTOTest<Product> {

	@Override
	protected Product getInstance() {
		return new Product();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final Product producto = new Product();

		assertNull(producto.isOperable());
		assertNull(producto.isVisible());

		producto.setOperable(true);
		producto.setVisible(true);
		assertNotNull(producto.isOperable());
		assertNotNull(producto.isVisible());

		assertNotNull(producto.getMovement());
		assertNotNull(producto.getExtracts());

	}

}
