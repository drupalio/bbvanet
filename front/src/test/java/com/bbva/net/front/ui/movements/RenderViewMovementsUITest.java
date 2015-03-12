package com.bbva.net.front.ui.movements;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class RenderViewMovementsUITest extends AbstractBbvaDTOTest<RenderViewMovementsUI> {

	@Override
	protected RenderViewMovementsUI getInstance() {
		return new RenderViewMovementsUI();
	}

	@Test
	public void checkInitMethod() {
		final RenderViewMovementsUI renderViewMovementsUI = new RenderViewMovementsUI();
		renderViewMovementsUI.init();
		Assert.assertNotNull(renderViewMovementsUI.getRenderComponents());
	}

}
