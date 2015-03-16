package com.bbva.zic.agileoperations.v01;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class AdaptedDestinationAdapterTest extends AbstractBbvaDTOTest<AdaptedIDestinationAdapter> {

	@Override
	protected AdaptedIDestinationAdapter getInstance() {
		return new AdaptedIDestinationAdapter();
	}

}
