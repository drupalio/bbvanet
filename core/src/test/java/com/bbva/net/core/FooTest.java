package com.bbva.net.core;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class FooTest extends AbstractBbvaDTOTest<Foo> {

	@Override
	protected Foo getInstance() {
		return new Foo();
	}

}
