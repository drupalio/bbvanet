/**
 * 
 */
package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */
@Controller(value = "quotaController")
public class QuotaControllerImpl extends AbstractBbvaController implements QuotaController {

	private static final long serialVersionUID = 1L;

	@Override
	public PersonalizeAccountDTO getPersonalizeProductAccountDto() {
		// TODO Auto-generated method sgetSelectedProduct();()
		return null;
	}

	@Override
	public TermsAccountsDto getAllConditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchQuotaMovement(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public RotatingAccountDTO getSelectedProduct() {
		return (RotatingAccountDTO)super.getSelectedProduct();
	}

}
