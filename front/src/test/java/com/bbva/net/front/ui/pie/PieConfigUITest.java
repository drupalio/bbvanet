package com.bbva.net.front.ui.pie;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PieConfigUITest extends AbstractBbvaDTOTest<PieConfigUI> {

	@Override
	protected PieConfigUI getInstance() {
		return new PieConfigUI();
	}

	@Test
	public void checkIsVisible() {
		final PieConfigUI pieConfigUI = new PieConfigUI();
		pieConfigUI.setVisible(true);
		Assert.assertNotNull(pieConfigUI.isVisible());
	}

}
