package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Holder;
import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

public class ConditionsMapperImpTest {

	private ConditionsMapperImpl conditionsMapper;

	private TermsAccountsDto termsAccounts;

	private List<InvolvedDto> listHolders;

	@Before
	public void init() {
		this.conditionsMapper = new ConditionsMapperImpl();
		// Mockitos
		this.termsAccounts = Mockito.mock(TermsAccountsDto.class);
		this.listHolders = new ArrayList<InvolvedDto>();
	}

	@Test
	public void map() {
		Conditions condiciones = Mockito.mock(Conditions.class);
		this.termsAccounts = conditionsMapper.map(condiciones);
		Assert.assertNotNull(termsAccounts);
	}

	@Test
	public void mapHeadlinesList() {
		List<Holder> Headlines = new ArrayList<Holder>();
		this.listHolders = conditionsMapper.mapHeadlinesList(Headlines);
		Assert.assertNotNull(listHolders);
	}
}
