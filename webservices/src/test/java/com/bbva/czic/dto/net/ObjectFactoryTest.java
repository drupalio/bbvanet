package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ObjectFactoryTest extends AbstractBbvaDTOTest<ObjectFactory> {

	@Override
	protected ObjectFactory getInstance() {
		return new ObjectFactory();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final ObjectFactory objectFactory = new ObjectFactory();

		assertNotNull(objectFactory.createActivity());
		assertNotNull(objectFactory.createActivity(objectFactory.createActivity()));
		assertNotNull(objectFactory.createBalance());
		assertNotNull(objectFactory.createBalance(objectFactory.createBalance()));
		assertNotNull(objectFactory.createCity());
		assertNotNull(objectFactory.createCity(objectFactory.createCity()));
		assertNotNull(objectFactory.createConditions());
		assertNotNull(objectFactory.createConditions(objectFactory.createConditions()));
		assertNotNull(objectFactory.createContactInfo());
		assertNotNull(objectFactory.createContactInfo(objectFactory.createContactInfo()));
		assertNotNull(objectFactory.createContract());
		assertNotNull(objectFactory.createContract(objectFactory.createContract()));
		assertNotNull(objectFactory.createCountry());
		assertNotNull(objectFactory.createCountry(objectFactory.createCountry()));
		assertNotNull(objectFactory.createEmail());
		assertNotNull(objectFactory.createEmail(objectFactory.createEmail()));
		assertNotNull(objectFactory.createEnumMessageType(EnumMessageType.ADVERTISEMENT));
		assertNotNull(objectFactory.createEnumThirdPartyType(EnumThirdPartyType.AGGREGATE));
		assertNotNull(objectFactory.createExecutive());
		assertNotNull(objectFactory.createExecutive(objectFactory.createExecutive()));
		assertNotNull(objectFactory.createExtracto());
		assertNotNull(objectFactory.createExtracto(objectFactory.createExtracto()));
		assertNotNull(objectFactory.createFunction());
		assertNotNull(objectFactory.createFunction(objectFactory.createFunction()));
		assertNotNull(objectFactory.createHolder());
		assertNotNull(objectFactory.createHolder(objectFactory.createHolder()));
		assertNotNull(objectFactory.createLocation());
		assertNotNull(objectFactory.createLocation(objectFactory.createLocation()));
		assertNotNull(objectFactory.createMessage());
		assertNotNull(objectFactory.createMessage(objectFactory.createMessage()));
		assertNotNull(objectFactory.createMovement());
		assertNotNull(objectFactory.createMovement(objectFactory.createMovement()));
		assertNotNull(objectFactory.createOffice());
		assertNotNull(objectFactory.createOffice(objectFactory.createOffice()));
		assertNotNull(objectFactory.createOperation());
		assertNotNull(objectFactory.createOperation(objectFactory.createOperation()));
		assertNotNull(objectFactory.createPhoneNumber());
		assertNotNull(objectFactory.createPhoneNumber(objectFactory.createPhoneNumber()));
		assertNotNull(objectFactory.createProduct());
		assertNotNull(objectFactory.createProduct(objectFactory.createProduct()));
		assertNotNull(objectFactory.createState());
		assertNotNull(objectFactory.createState(objectFactory.createState()));
		assertNotNull(objectFactory.createThirdParty());
		assertNotNull(objectFactory.createThirdParty(objectFactory.createThirdParty()));
		assertNotNull(objectFactory.createUser());
		assertNotNull(objectFactory.createUser(objectFactory.createUser()));

	}
}
