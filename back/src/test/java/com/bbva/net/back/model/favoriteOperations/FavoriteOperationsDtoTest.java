package com.bbva.net.back.model.favoriteOperations;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class FavoriteOperationsDtoTest extends AbstractBbvaDTOTest<FavoriteOperationDto> {

	private FavoriteOperationDto favoriteDto;

	@Override
	protected FavoriteOperationDto getInstance() {
		return new FavoriteOperationDto();
	}

	@Test
	public void checkFavoriteOperationDto() {
		Date transactionDate = new Date();

		Money amount = new Money();

		favoriteDto = new FavoriteOperationDto(transactionDate, amount, "origin", "destination", "contractId",
				"idOperation", "name", "transactionReference");
		Assert.assertNotNull(favoriteDto);
	}
}
