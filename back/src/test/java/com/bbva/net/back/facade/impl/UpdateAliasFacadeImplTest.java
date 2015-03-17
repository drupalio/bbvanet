package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.mapper.UpdateAliasMapper;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.net.webservices.subjects.SubjetsService;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

public class UpdateAliasFacadeImplTest {

	private UpdateAliasFacadeImpl updateAliasFacade;

	@Resource(name = "subjetsService")
	private SubjetsService subjetsService;

	@Resource(name = "updateAliasMapper")
	private UpdateAliasMapper updateAliasMapper;

	private UpdateAccountDto updateAccountDto;

	private UpdateSubjectIn updateSubjectIn;

	private UpdateAccountOut updateAccountOut;

	@Before
	public void init() {
		this.updateAliasFacade = new UpdateAliasFacadeImpl();
		this.subjetsService = Mockito.mock(SubjetsService.class);
		this.updateAliasMapper = Mockito.mock(UpdateAliasMapper.class);
		this.updateAliasFacade.setSubjetsService(subjetsService);
		this.updateAliasFacade.setUpdateAliasMapper(updateAliasMapper);
		this.updateAccountDto = Mockito.mock(UpdateAccountDto.class);
		this.updateSubjectIn = Mockito.mock(UpdateSubjectIn.class);
		this.updateAccountOut = Mockito.mock(UpdateAccountOut.class);
	}

	@Test
	public void checkUpdateSubject() {
		Mockito.when(this.updateAliasFacade.updateSubject("12345678", updateAccountDto)).thenReturn(updateAccountDto);
		Mockito.when(this.updateAliasMapper.mapUpdateAccountIn(updateAccountDto)).thenReturn(updateSubjectIn);
		Mockito.when(this.subjetsService.updateSubject("12345678", updateSubjectIn)).thenReturn(updateAccountOut);
		Mockito.when(this.updateAliasMapper.mapUpdateAccountOut(updateAccountOut)).thenReturn(updateAccountDto);
	}
}
