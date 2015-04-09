package com.bbva.net.core.pattern;

import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;

public class VisitorCommandTest {

	private List<Long> elements;

	private DataFactory dataFactory;

	@Before
	public void setUp() {

		this.elements = new ArrayList<Long>();
		this.dataFactory = new DataFactory();
		this.elements.add(Long.valueOf(dataFactory.getNumberBetween(0, 10)));
		this.elements.add(Long.valueOf(dataFactory.getNumberBetween(0, 10)));
		this.elements.add(Long.valueOf(dataFactory.getNumberBetween(0, 10)));
	}

	@Test
	public void checkVisitWithElements() {
		new CustomVisitorCommand(this.elements);
	}

	@Test
	public void checkVisitWithOutElements() {

		new CustomVisitorCommand(new ArrayList<Long>());
		new CustomVisitorCommand(null);
	}

	/**
	 * @author Entelgy
	 */
	private static class CustomVisitorCommand extends VisitorCommand<Long> {

		public CustomVisitorCommand(List<Long> list) {
			super(list);
		}

		@Override
		protected void execute(Long object) {
			// Nothing to do .........
		}

	}
}
