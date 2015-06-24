package com.bbva.net.front.controller;

import com.bbva.net.back.model.accounts.TermsAccountsDto;

public interface TermsController {

	TermsAccountsDto getAllConditions();

	void exportDocumentPdf();
}
