package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.UpdateAliasMapper;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

@Mapper(value = "updateAliasMapper")
public class UpdateAliasMapperImpl extends ConfigurableMapper implements UpdateAliasMapper {

	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(UpdateAccountDto.class, UpdateSubjectIn.class).field("alias", "alias")
				.field("userId", "userId").field("subjectType", "subjectType").field("subject", "subject").byDefault()
				.register();

		factory.classMap(UpdateAccountOut.class, UpdateAccountDto.class).field("folio", "folio").byDefault().register();
	}

	@Override
	public UpdateSubjectIn mapUpdateAccountIn(final UpdateAccountDto updateAccountDto) {
		final UpdateSubjectIn updateAlias = map(updateAccountDto, UpdateSubjectIn.class);
		return updateAlias;
	}

	@Override
	public UpdateAccountDto mapUpdateAccountOut(final UpdateAccountOut updateAccountOut) {
		final UpdateAccountDto updateAlias = map(updateAccountOut, UpdateAccountDto.class);
		return updateAlias;
	}

}
