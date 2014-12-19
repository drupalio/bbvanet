package com.bbva.net.back.accounts;

import com.bbva.net.back.model.accounts.PostalAddresDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PostalAddresDtoTest extends AbstractBbvaDTOTest<PostalAddresDto> {

	@Override
	protected PostalAddresDto getInstance() {
		return new PostalAddresDto();
	}

}
