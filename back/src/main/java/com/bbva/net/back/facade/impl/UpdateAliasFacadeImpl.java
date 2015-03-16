package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.UpdateAliasFacade;
import com.bbva.net.back.mapper.UpdateAliasMapper;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.net.webservices.subjects.SubjetsService;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

@Facade(value = "updateAliasFacade")
public class UpdateAliasFacadeImpl extends AbstractBbvaFacade implements UpdateAliasFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "subjetsService")
	private SubjetsService subjetsService;

	@Resource(name = "updateAliasMapper")
	private UpdateAliasMapper updateAliasMapper;

	@Override
	public UpdateAccountDto updateSubject(String contractNumber, UpdateAccountDto updateAccountDto) {
		UpdateSubjectIn updateSubjectIn = new UpdateSubjectIn();
		UpdateAccountOut updateAccountOut = new UpdateAccountOut();
		UpdateAccountDto updateAccountRespon = new UpdateAccountDto();
		LOGGER.info("Comenzando mapeo del servicio de updateSubject (UpdateAccountDto -> UpdateSubjectIn)");
		updateSubjectIn = updateAliasMapper.mapUpdateAccountIn(updateAccountDto);
		LOGGER.info("Llamando al servicio de subjetsService");
		updateAccountOut = this.subjetsService.updateSubject(contractNumber, updateSubjectIn);
		LOGGER.info("Comenzando mapeo del servicio de updateSubject (UpdateAccountOut -> UpdateAccountDto)");
		updateAccountRespon = updateAliasMapper.mapUpdateAccountOut(updateAccountOut);
		return updateAccountRespon;
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/

	/**
	 * @param subjetsService the subjetsService to set
	 */
	public void setSubjetsService(SubjetsService subjetsService) {
		this.subjetsService = subjetsService;
	}

	/**
	 * @param updateAliasMapper the updateAliasMapper to set
	 */
	public void setUpdateAliasMapper(UpdateAliasMapper updateAliasMapper) {
		this.updateAliasMapper = updateAliasMapper;
	}

}
