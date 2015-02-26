package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Holder;
import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

public interface ConditionsMapper {

	TermsAccountsDto map(Conditions condiciones);

	List<InvolvedDto> mapHeadlinesList(List<Holder> Headlines);
}
