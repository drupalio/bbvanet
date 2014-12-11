package com.bbva.net.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;
import com.bbva.net.core.utils.CollectionBbvaUtils;
import com.bbva.net.test.Foo;

public class CollectionBbvaUtilsTest {

	private List<Foo> foos;

	@Before
	public void init() {
		this.foos = new ArrayList<Foo>();
		this.foos.add(new Foo(5L, 3, "Valor 1"));
		this.foos.add(new Foo(8L, 9, "Valor 1"));
		this.foos.add(new Foo(15L, 12, "Valor 1"));

	}

	@Test
	public void checkClass() {
		TestUtils.superficialAbstractCodeCoverage(CollectionBbvaUtils.class);
	}

	@Test
	public void checkGetValueByEl() {

		final Foo foo = new Foo(5L, 3, "Prueba");
		double resultQuantity = CollectionBbvaUtils.getValueByEL(foo, "quantity");
		Assert.assertTrue(5.0 == resultQuantity);

		double resultValue = CollectionBbvaUtils.getValueByEL(foo, "value");
		Assert.assertTrue(3.0 == resultValue);

		double descriptionValue = CollectionBbvaUtils.getValueByEL(foo, "description");
		Assert.assertTrue(0.0 == descriptionValue);

	}

	@Test
	public void checkCalculateTotalByLIst() {

		BigDecimal resultQuantity = CollectionBbvaUtils.calculateTotal(this.foos, "quantity");
		Assert.assertEquals(new BigDecimal("28.0"), resultQuantity);

	}

}
