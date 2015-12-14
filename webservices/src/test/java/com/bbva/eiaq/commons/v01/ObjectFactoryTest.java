package com.bbva.eiaq.commons.v01;

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

        assertNotNull(objectFactory.createCardNumber());
        assertNotNull(objectFactory.createCardNumber(objectFactory.createCardNumber()));
        assertNotNull(objectFactory.createCcc());
        assertNotNull(objectFactory.createCcc(objectFactory.createCcc()));
        assertNotNull(objectFactory.createClabe());
        assertNotNull(objectFactory.createClabe(objectFactory.createClabe()));
        assertNotNull(objectFactory.createCreditNumber());
        assertNotNull(objectFactory.createCreditNumber(objectFactory.createCreditNumber()));
        assertNotNull(objectFactory.createCardNumber(objectFactory.createCardNumber()));
        assertNotNull(objectFactory.createMobilePhoneNumber());
        assertNotNull(objectFactory.createMobilePhoneNumber(objectFactory.createMobilePhoneNumber()));

    }
}
