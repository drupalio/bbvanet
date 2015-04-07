/**
 * 
 */
package com.bbva.net.back.model.updateAlias;

import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;
import com.bbva.zic.commons.v01.EnumSubjectType;

/**
 * @author Entelgy
 */
public class UpdateAccountDtoTest extends AbstractBbvaDTOTest<UpdateAccountDto> {

	private UpdateAccountDto updateAccount;

	public UpdateAccountDtoTest() {
		this.updateAccount = new UpdateAccountDto("", "", "", EnumSubjectType.CED_ACCOUNT, "");
	}

	@Override
	protected UpdateAccountDto getInstance() {
		return new UpdateAccountDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		// Inicializar entrada
		UpdateAccountDto eqUpdateAccount = new UpdateAccountDto("", "", "", EnumSubjectType.CED_ACCOUNT, "");
		// Caso exitoso
		this.updateAccount.equals(eqUpdateAccount);
		// Cuando el objeto es nulo
		this.updateAccount.equals(null);
		// Cuando el dto comparado no es el mismo
		this.updateAccount.equals(new QuotaDetailDto());
		// setSubject diferente
		eqUpdateAccount.setSubject("1234");
		this.updateAccount.equals(eqUpdateAccount);
		// setSubjectType diferente
		eqUpdateAccount.setSubjectType(EnumSubjectType.CHECK_ACCOUNT);
		this.updateAccount.equals(eqUpdateAccount);
		// setUserId diferente
		eqUpdateAccount.setUserId("121232342");
		this.updateAccount.equals(eqUpdateAccount);
		// setAlias diferente
		eqUpdateAccount.setAlias("2");
		this.updateAccount.equals(eqUpdateAccount);
		// setFolio diferente
		eqUpdateAccount.setFolio("Lleno");
		this.updateAccount.equals(eqUpdateAccount);
	}
}
