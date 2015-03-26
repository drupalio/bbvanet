package com.bbva.net.back.model.header;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.office.OfficeDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ExecutiveDtoTest extends AbstractBbvaDTOTest<ExecutiveDto> {

	private ExecutiveDto executive;

	@Override
	protected ExecutiveDto getInstance() {
		return new ExecutiveDto();
	}

	@Override
	@Test
	public void checkEqualsMethod() {
		OfficeDto office = new OfficeDto("Oficina", "cll 119 A32 -a 27");
		this.executive = new ExecutiveDto("Pepito", office, "6803126", "pepito@bbva.com.co", "latitud");
		ExecutiveDto executive = new ExecutiveDto("Pepito", office, "6803126", "pepito@bbva.com.co", "latitud");

		Assert.assertFalse(this.executive.equals(null));

		Assert.assertTrue(this.executive.equals(executive));

		executive.setName("Beto");
		Assert.assertFalse(this.executive.equals(executive));

		OfficeDto offices = new OfficeDto("Oficina", "cll 119 A32 -a 27");
		executive.setOffice(offices);
		Assert.assertFalse(this.executive.equals(executive));

		executive.setMail("mail");
		Assert.assertFalse(this.executive.equals(executive));

		executive.setPhone("0000000");
		Assert.assertFalse(this.executive.equals(executive));

		executive.setCoordenadas("longitud");
		Assert.assertFalse(this.executive.equals(executive));
	}

	@Test
	public void checkExecutiveDto() {
		OfficeDto office = new OfficeDto("Oficina", "cll 119 A32 -a 27");
		this.executive = new ExecutiveDto("Pepito", office, "6803126", "pepito@bbva.com.co", "latitud");
		Assert.assertNotNull(executive);
	}

}
