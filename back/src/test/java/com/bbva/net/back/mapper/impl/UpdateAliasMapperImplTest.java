package com.bbva.net.back.mapper.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

public class UpdateAliasMapperImplTest {

	private UpdateAliasMapperImpl updateAliasMapperImpl;

	private UpdateSubjectIn updateSubjectIn;

	private UpdateAccountDto updateAccountDto;

	@Before
	public void init() {
		this.updateAliasMapperImpl = new UpdateAliasMapperImpl();
		this.updateAccountDto = new UpdateAccountDto();
		this.updateSubjectIn = new UpdateSubjectIn();
	}

	@Test
	public void checkMapUpdateAccountIn() {
		this.updateSubjectIn = this.updateAliasMapperImpl.mapUpdateAccountIn(new UpdateAccountDto());
		Assert.assertNotNull(updateSubjectIn);
	}

	@Test
	public void checkMapUpdateAccountOut() {
		this.updateAccountDto = this.updateAliasMapperImpl.mapUpdateAccountOut(new UpdateAccountOut());
		Assert.assertNotNull(updateAccountDto);
	}

}
