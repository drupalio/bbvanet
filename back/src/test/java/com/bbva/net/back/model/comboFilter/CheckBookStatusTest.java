package com.bbva.net.back.model.comboFilter;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class CheckBookStatusTest {

	@Test
	public void checkEnumCheckBookStatus() {
		TestUtils.enumCodeCoverage(EnumCheckBookStatus.class);
	}

	@Test
	public void checkAttribute() {
		EnumCheckBookStatus.ANULADO.setStatusId("1");
		EnumCheckBookStatus.ANULADO.setValue("Anulado");
		Assert.assertEquals(EnumCheckBookStatus.ANULADO.getStatusId(), "1");
		Assert.assertEquals(EnumCheckBookStatus.ANULADO.getValue(), "Anulado");

		EnumCheckBookStatus.ANULADO_PETICION.setStatusId("C");
		EnumCheckBookStatus.ANULADO_PETICION.setValue("Anulado por petición");
		Assert.assertEquals(EnumCheckBookStatus.ANULADO_PETICION.getStatusId(), "C");
		Assert.assertEquals(EnumCheckBookStatus.ANULADO_PETICION.getValue(), "Anulado por petición");

		EnumCheckBookStatus.DE_BAJA.setStatusId("B");
		EnumCheckBookStatus.DE_BAJA.setValue("De baja");
		Assert.assertEquals(EnumCheckBookStatus.DE_BAJA.getStatusId(), "B");
		Assert.assertEquals(EnumCheckBookStatus.DE_BAJA.getValue(), "De baja");

		EnumCheckBookStatus.EN_IMPRESOR.setStatusId("I");
		EnumCheckBookStatus.EN_IMPRESOR.setValue("Impresor");
		Assert.assertEquals(EnumCheckBookStatus.EN_IMPRESOR.getStatusId(), "I");
		Assert.assertEquals(EnumCheckBookStatus.EN_IMPRESOR.getValue(), "Impresor");

		EnumCheckBookStatus.EN_OFICINA.setStatusId("O");
		EnumCheckBookStatus.EN_OFICINA.setValue("OficinaEn");
		Assert.assertEquals(EnumCheckBookStatus.EN_OFICINA.getStatusId(), "O");
		Assert.assertEquals(EnumCheckBookStatus.EN_OFICINA.getValue(), "OficinaEn");

		EnumCheckBookStatus.ENTRE_CLIENTE.setStatusId("E");
		EnumCheckBookStatus.ENTRE_CLIENTE.setValue("Clientes");
		Assert.assertEquals(EnumCheckBookStatus.ENTRE_CLIENTE.getStatusId(), "E");
		Assert.assertEquals(EnumCheckBookStatus.ENTRE_CLIENTE.getValue(), "Clientes");

		EnumCheckBookStatus.NO_RECIBIDO.setStatusId("N");
		EnumCheckBookStatus.NO_RECIBIDO.setValue("No recibido");
		Assert.assertEquals(EnumCheckBookStatus.NO_RECIBIDO.getStatusId(), "N");
		Assert.assertEquals(EnumCheckBookStatus.NO_RECIBIDO.getValue(), "No recibido");

		EnumCheckBookStatus.PED_OFICINA.setStatusId("A");
		EnumCheckBookStatus.PED_OFICINA.setValue("Oficina");
		Assert.assertEquals(EnumCheckBookStatus.PED_OFICINA.getStatusId(), "A");
		Assert.assertEquals(EnumCheckBookStatus.PED_OFICINA.getValue(), "Oficina");

		EnumCheckBookStatus.PERDIDO.setStatusId("2");
		EnumCheckBookStatus.PERDIDO.setValue("Perdido");
		Assert.assertEquals(EnumCheckBookStatus.PERDIDO.getStatusId(), "2");
		Assert.assertEquals(EnumCheckBookStatus.PERDIDO.getValue(), "Perdido");
	}

	@Test
	public void checkValueOf() {
		// check Ok
		Assert.assertNotNull(EnumCheckBookStatus.valueOfEnum("1"));

	}

	@Test
	public void mistValueOf() {
		// check mistake
		Assert.assertNull(EnumCheckBookStatus.valueOfEnum("5"));
	}

}
