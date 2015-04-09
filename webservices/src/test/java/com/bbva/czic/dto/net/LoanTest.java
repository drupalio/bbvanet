package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class LoanTest extends AbstractBbvaDTOTest<Loan> {

	@Override
	protected Loan getInstance() {
		return new Loan();
	}

}
