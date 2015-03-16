package com.bbva.net.back.mapper;

import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

public interface UpdateAliasMapper {

	UpdateSubjectIn mapUpdateAccountIn(final UpdateAccountDto updateAccountDto);

	UpdateAccountDto mapUpdateAccountOut(final UpdateAccountOut updateAccountDto);

}
