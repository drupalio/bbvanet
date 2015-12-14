package com.bbva.eiaq.commons.v01;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CardNumberTest extends AbstractBbvaDTOTest<CardNumber> {

    @Override
    protected CardNumber getInstance() {
        return new CardNumber();
    }
    
}
