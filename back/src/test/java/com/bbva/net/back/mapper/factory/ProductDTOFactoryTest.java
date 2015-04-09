package com.bbva.net.back.mapper.factory;

import ma.glasnost.orika.MappingContext;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Card;
import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Product;

public class ProductDTOFactoryTest {

	@Test
	public void checkCreate() {
		ProductDTOFactory product = new ProductDTOFactory();

		Account account = new Account();
		account.setType("CC");
		Assert.assertNotNull(product.create(account, Mockito.mock(MappingContext.class)));
		account.setType("AQ");
		Assert.assertNotNull(product.create(account, Mockito.mock(MappingContext.class)));
		account.setType("CR");
		Assert.assertNotNull(product.create(account, Mockito.mock(MappingContext.class)));

		Card creditCard = new Card();
		creditCard.setType("TC");
		Assert.assertNotNull(product.create(creditCard, Mockito.mock(MappingContext.class)));

		Product leasing = new Product();
		leasing.setType("LS");
		Assert.assertNotNull(product.create(leasing, Mockito.mock(MappingContext.class)));

		Loan loan = new Loan();
		loan.setType("HI");
		Assert.assertNotNull(product.create(loan, Mockito.mock(MappingContext.class)));

		Product fund = new Product();
		fund.setType("FA");
		Assert.assertNotNull(product.create(fund, Mockito.mock(MappingContext.class)));

		Product deposit = new Product();
		deposit.setType("DE");
		Assert.assertNotNull(product.create(deposit, Mockito.mock(MappingContext.class)));
	}

}
