package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class UserTest extends AbstractBbvaDTOTest<User> {

	@Override
	protected User getInstance() {
		return new User();
	}

}
