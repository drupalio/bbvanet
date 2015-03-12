package com.bbva.net.front.ui.menu;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class ItemMenuTest {

	@Test
	public void checkItemMenuEnum() {
		TestUtils.enumCodeCoverage(ItemMenu.class);
	}

}
