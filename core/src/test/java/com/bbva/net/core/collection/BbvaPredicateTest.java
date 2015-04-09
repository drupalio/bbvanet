package com.bbva.net.core.collection;

import org.junit.Assert;
import org.junit.Test;

public class BbvaPredicateTest {

	private static final Long VALUE = 1L;

	private static final Long ANOTHER_VALUE = 2L;

	@Test
	public void checkEvalBbvaPredicate_True() {

		final CustomBbvaPredicate customBbvaPredicate = new CustomBbvaPredicate(VALUE);
		Assert.assertTrue(customBbvaPredicate.evaluate(VALUE));

	}

	@Test
	public void checkEvalBbvaPredicate_False() {

		final CustomBbvaPredicate customBbvaPredicate = new CustomBbvaPredicate(VALUE);
		Assert.assertFalse(customBbvaPredicate.evaluate(ANOTHER_VALUE));

	}

	/**
	 * @author Entelgy
	 */
	private static class CustomBbvaPredicate extends BbvaPredicate<Long> {

		private Long value;

		public CustomBbvaPredicate(final Long value) {
			this.value = value;
		}

		@Override
		protected boolean eval(Long value) {
			return this.value.equals(value);
		}

	}

}
