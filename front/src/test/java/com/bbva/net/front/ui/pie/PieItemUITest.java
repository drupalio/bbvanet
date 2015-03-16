package com.bbva.net.front.ui.pie;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PieItemUITest extends AbstractBbvaDTOTest<PieItemUI> {

	@Override
	protected PieItemUI getInstance() {
		return new PieItemUI();
	}

	@Test
	public void checkAccessMethods() {

		final PieItemUI pieItemUI = new PieItemUI("#FFFFFF", "Text Legen", BigDecimal.valueOf(22.34));
		pieItemUI.setCurrency('$');
		Assert.assertNotNull(pieItemUI.getCurrency());

	}
}
