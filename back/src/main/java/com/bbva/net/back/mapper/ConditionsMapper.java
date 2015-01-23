package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

public interface ConditionsMapper {

	TermsAccountsDto map(Conditions condiciones);
}
