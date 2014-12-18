package com.bbva.net.back.model.globalposition;

import com.bbva.net.back.model.commons.Money;

public class AdquirenceAccountDTO extends ProductDTO {

	private static final long serialVersionUID = 1L;

	private Money overDraft;

	public Money getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(Money value) {
		this.overDraft = value;
	}

	public boolean isSetOverDraft() {
		return (this.overDraft != null);
	}

}
