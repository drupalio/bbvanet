package com.bbva.net.back.model.comboFilter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckStatusTest {

	@Before
	public void init() {
	}

	@Test
	public void checkEnumCheckEstatus() {
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
	}

	@Test
	public void checkAttribute() {
		EnumCheckStatus.DISPONIBLE.setStatusId(0);
		EnumCheckStatus.DISPONIBLE.setValue("Disponible");
		Assert.assertEquals(EnumCheckStatus.DISPONIBLE.getStatusId(), 0);
		Assert.assertEquals(EnumCheckStatus.DISPONIBLE.getValue(), "Disponible");

		EnumCheckStatus.ANULADO.setStatusId(1);
		EnumCheckStatus.ANULADO.setValue("Anulado");
		Assert.assertEquals(EnumCheckStatus.ANULADO.getStatusId(), 1);
		Assert.assertEquals(EnumCheckStatus.ANULADO.getValue(), "Anulado");

		EnumCheckStatus.PERDIDO.setStatusId(2);
		EnumCheckStatus.PERDIDO.setValue("Perdido");
		Assert.assertEquals(EnumCheckStatus.PERDIDO.getStatusId(), 2);
		Assert.assertEquals(EnumCheckStatus.PERDIDO.getValue(), "Perdido");

		EnumCheckStatus.PAGADO_X_CANJE.setStatusId(3);
		EnumCheckStatus.PAGADO_X_CANJE.setValue("Pagado por Canje");
		Assert.assertEquals(EnumCheckStatus.PAGADO_X_CANJE.getStatusId(), 3);
		Assert.assertEquals(EnumCheckStatus.PAGADO_X_CANJE.getValue(), "Pagado por Canje");

		EnumCheckStatus.PAGADO_X_VENTANILLA.setStatusId(4);
		EnumCheckStatus.PAGADO_X_VENTANILLA.setValue("Pagado por Ventanilla");
		Assert.assertEquals(EnumCheckStatus.PAGADO_X_VENTANILLA.getStatusId(), 4);
		Assert.assertEquals(EnumCheckStatus.PAGADO_X_VENTANILLA.getValue(), "Pagado por Ventanilla");

		EnumCheckStatus.ORDEN_NO_PAGO.setStatusId(8);
		EnumCheckStatus.ORDEN_NO_PAGO.setValue("Orden de no Pago");
		Assert.assertEquals(EnumCheckStatus.ORDEN_NO_PAGO.getStatusId(), 8);
		Assert.assertEquals(EnumCheckStatus.ORDEN_NO_PAGO.getValue(), "Orden de no Pago");
	}

	@Test
	public void checkValueOf() {
		// check Ok
		EnumCheckStatus.valueOf(0);

	}

	@Test
	public void mistValueOf() {
		// check mistake
		EnumCheckStatus.valueOf(5);
	}

}
