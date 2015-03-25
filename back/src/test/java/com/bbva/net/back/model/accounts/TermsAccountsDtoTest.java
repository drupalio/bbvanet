package com.bbva.net.back.model.accounts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class TermsAccountsDtoTest extends AbstractBbvaDTOTest<TermsAccountsDto> {

	private TermsAccountsDto termsAccount;

	private DetailConditionsDto detailConditions;

	private PostalAddresDto postal;

	private InvolvedDto hold;

	private List<InvolvedDto> holders;

	public TermsAccountsDtoTest() {
		this.detailConditions = new DetailConditionsDto("A", "Al", new Date(), "comitions");
		this.postal = new PostalAddresDto("hold", "calle 15");
		this.hold = new InvolvedDto("alias");
		this.holders = new ArrayList<InvolvedDto>();
		this.holders.add(hold);
		this.termsAccount = new TermsAccountsDto(this.detailConditions, this.postal, this.holders, "condi");
	}

	@Override
	protected TermsAccountsDto getInstance() {
		return new TermsAccountsDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		TermsAccountsDto termsInEquals = new TermsAccountsDto(this.detailConditions, this.postal, this.holders, "condi");
		// Cuando el objeto es nulo
		this.termsAccount.equals(null);
		// Cuando el dto comparado no es el mismo
		this.termsAccount.equals(new MovementCriteriaDto());
		// Caso exitoso
		this.termsAccount.equals(termsInEquals);
		// el CondicionesMovilizacion del objeto es diferente
		termsInEquals.setCondicionesMovilizacion("12345");
		this.termsAccount.equals(termsInEquals);
		// el Holders del objeto es diferente
		termsInEquals.setHolders(new ArrayList<InvolvedDto>());
		this.termsAccount.equals(termsInEquals);
		// el DireccionPostal del objeto es diferente
		termsInEquals.setDireccionPostal(new PostalAddresDto());
		this.termsAccount.equals(termsInEquals);
		// el DetalleCondiciones del objeto es diferente
		termsInEquals.setDetalleCondiciones(new DetailConditionsDto());
		this.termsAccount.equals(termsInEquals);
	}
}
