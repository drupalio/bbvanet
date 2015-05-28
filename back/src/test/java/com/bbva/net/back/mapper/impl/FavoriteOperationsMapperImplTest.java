package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.eiaq.commons.v01.CardNumber;
import com.bbva.eiaq.commons.v01.Ccc;
import com.bbva.eiaq.commons.v01.Clabe;
import com.bbva.eiaq.commons.v01.CreditNumber;
import com.bbva.eiaq.commons.v01.MobilePhoneNumber;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.zic.agileoperations.v01.AdaptedIDestinationAdapter;
import com.bbva.zic.agileoperations.v01.AdaptedIOriginAdapter;
import com.bbva.zic.agileoperations.v01.AgileOperation;

/**
 * @author Entelgy
 */
public class FavoriteOperationsMapperImplTest {

	private FavoriteOperationsMapperImpl favoriteOperationMapper;

	@Before
	public void init() {
		this.favoriteOperationMapper = new FavoriteOperationsMapperImpl();

	}

	@Test
	public void checkGetFavoriteOperations() {
		List<AgileOperation> agileOperation = new ArrayList<AgileOperation>();
		List<FavoriteOperationDto> favoriteOperationDto = favoriteOperationMapper.map(agileOperation);
		Assert.assertNotNull(favoriteOperationDto);

	}

	@Test
	public void check() {
		FavoriteOperationDto favoriteOperationDto = new FavoriteOperationDto();
		AgileOperation agileOperation = favoriteOperationMapper.map(favoriteOperationDto);
		Assert.assertNotNull(agileOperation);

	}

	@Test
	public void checkGetNameClassOrigin() {
		Assert.assertNotNull(favoriteOperationMapper.getNameClassOrigin(Mockito.mock(AdaptedIOriginAdapter.class)));

		AdaptedIOriginAdapter origen = new AdaptedIOriginAdapter();
		origen.setCardNumber(Mockito.mock(CardNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassOrigin(origen), "cardNumber");

		origen = new AdaptedIOriginAdapter();
		origen.setCcc(Mockito.mock(Ccc.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassOrigin(origen), "ccc");

		origen = new AdaptedIOriginAdapter();
		origen.setClabe(Mockito.mock(Clabe.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassOrigin(origen), "clabe");

		origen = new AdaptedIOriginAdapter();
		origen.setCreditNumber(Mockito.mock(CreditNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassOrigin(origen), "creditNumber");

		origen = new AdaptedIOriginAdapter();
		origen.setMobilePhoneNumber(Mockito.mock(MobilePhoneNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassOrigin(origen), "mobilePhoneNumber");

	}

	@Test
	public void checkGetNameClassDestination() {
		Assert.assertNotNull(favoriteOperationMapper.getNameClassDestination(Mockito
				.mock(AdaptedIDestinationAdapter.class)));

		AdaptedIDestinationAdapter destino = new AdaptedIDestinationAdapter();
		destino.setCardNumber(Mockito.mock(CardNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassDestination(destino), "cardNumber");

		destino = new AdaptedIDestinationAdapter();
		destino.setCcc(Mockito.mock(Ccc.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassDestination(destino), "ccc");

		destino = new AdaptedIDestinationAdapter();
		destino.setClabe(Mockito.mock(Clabe.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassDestination(destino), "clabe");

		destino = new AdaptedIDestinationAdapter();
		destino.setCreditNumber(Mockito.mock(CreditNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassDestination(destino), "creditNumber");

		destino = new AdaptedIDestinationAdapter();
		destino.setMobilePhoneNumber(Mockito.mock(MobilePhoneNumber.class));
		Assert.assertEquals(favoriteOperationMapper.getNameClassDestination(destino), "mobilePhoneNumber");
	}
}
