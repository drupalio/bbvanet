/**
 * 
 */
package com.bbva.net.back.model.recoveryData;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

/**
 * @author User
 */
public class RecoverydDtoTest extends AbstractBbvaDTOTest<RecoverydDto> {

	private static final Integer DEFAULT_INT = Integer.valueOf(1);

	private static final Integer ANOTHER_INT = Integer.valueOf(2);

	private static final String ANOTHER_USER = "AnotherUser";

	@Override
	protected RecoverydDto getInstance() {
		return new RecoverydDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Test
	@Override
	public void checkEqualsMethod() {

		final RecoverydDto recoverydDto = new RecoverydDto(StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, DEFAULT_INT,
				StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, true);

		final RecoverydDto anotherRecoverydDto = new RecoverydDto(StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT,
				DEFAULT_INT, StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, true);

		Assert.assertEquals(recoverydDto, anotherRecoverydDto);
	}

	@Test
	public void checkEqualsFalse() {

		final RecoverydDto recoverydDto = new RecoverydDto(StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, DEFAULT_INT,
				StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, true);

		final RecoverydDto anotherRecoverydDto = new RecoverydDto(StringUtils.EMPTY, ANOTHER_INT, ANOTHER_INT,
				ANOTHER_INT, ANOTHER_USER, ANOTHER_INT, ANOTHER_INT, false);

		final RecoverydDto anotherRecoverydDto2 = new RecoverydDto(ANOTHER_USER, ANOTHER_INT, ANOTHER_INT, ANOTHER_INT,
				ANOTHER_USER, ANOTHER_INT, ANOTHER_INT, false);

		final RecoverydDto anotherRecoverydDto3 = new RecoverydDto(ANOTHER_USER, ANOTHER_INT, ANOTHER_INT, ANOTHER_INT,
				ANOTHER_USER, DEFAULT_INT, ANOTHER_INT, false);

		// Another RecoveryDto
		Assert.assertNotEquals(recoverydDto, anotherRecoverydDto);
		Assert.assertEquals(anotherRecoverydDto, anotherRecoverydDto);
		Assert.assertNotEquals(recoverydDto, anotherRecoverydDto2);
		Assert.assertNotEquals(anotherRecoverydDto2, anotherRecoverydDto3);
		// With Null
		Assert.assertNotEquals(recoverydDto, null);
		// Another class
		Assert.assertNotEquals(recoverydDto, new ProductDto());
	}

	@Test
	public void checkAccess() {

		final RecoverydDto recoverydDto = new RecoverydDto(StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, DEFAULT_INT,
				StringUtils.EMPTY, DEFAULT_INT, DEFAULT_INT, true);

		recoverydDto.setConditions(false);
		Assert.assertNotNull(recoverydDto.isConditions());

	}
}
