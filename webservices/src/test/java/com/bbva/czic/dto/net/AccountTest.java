package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class AccountTest extends AbstractBbvaDTOTest<Account> {

	@Override
	protected Account getInstance() {
		return new Account();
	}

}
