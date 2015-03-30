package com.bbva.net.back.facade;

import com.bbva.net.back.model.updateAlias.UpdateAccountDto;

public interface UpdateAliasFacade {

	UpdateAccountDto updateSubject(String contractNumber, UpdateAccountDto updateAccountDto);

}
