package com.bbva.net.back.model.personalize;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PersonalizeProductDtoTest extends AbstractBbvaDTOTest<PersonalizeAccountDto> {

	private PersonalizeAccountDto personalizeAccount;

	public PersonalizeProductDtoTest() {
		this.personalizeAccount = new PersonalizeAccountDto(true, "1234");
	}

	@Override
	protected PersonalizeAccountDto getInstance() {
		return new PersonalizeAccountDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		PersonalizeAccountDto personalizeInEquals = new PersonalizeAccountDto();
		// Cuando el objeto es nulo
		this.personalizeAccount.equals(null);
		// Cuando el dto comparado no es el mismo
		this.personalizeAccount.equals(new MovementCriteriaDto());
		// Caso exitoso
		personalizeInEquals.setVirtualMail(true);
		personalizeInEquals.setOperationKey("1234");
		this.personalizeAccount.equals(personalizeInEquals);
		// el operationKey del objeto es diferente
		personalizeInEquals.setOperationKey("12345");
		this.personalizeAccount.equals(personalizeInEquals);
		// el virtualMail del objeto es diferente
		personalizeInEquals.setVirtualMail(false);
		this.personalizeAccount.equals(personalizeInEquals);
	}
}
