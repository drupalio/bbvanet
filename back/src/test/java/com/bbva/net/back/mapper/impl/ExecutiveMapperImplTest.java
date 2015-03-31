package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Executive;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.header.ExecutiveDto;

public class ExecutiveMapperImplTest {
	
	ExecutiveMapperImpl mapper;
	
	@Before
	public void init() {
		this.mapper = new ExecutiveMapperImpl();
	}
	
	@Test
	public void map() {
		Executive exc = new Executive();
		ExecutiveDto executive = mapper.map(exc);
		Assert.assertNotNull(executive);		
	}

}
