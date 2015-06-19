package com.bbva.net.back.predicate;

import com.bbva.net.back.model.header.EmailDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class EmailPredicate extends BbvaPredicate<EmailDto> {

	@Override
	protected boolean eval(EmailDto email) {
		return email != null && email.getPrimary();

	}

}
