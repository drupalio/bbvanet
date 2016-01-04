package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TurnsOutwardsFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.turnsClient.BankDto;
import com.bbva.net.back.model.turnsClient.CityDto;
import com.bbva.net.back.model.turnsClient.ContactDto;
import com.bbva.net.back.model.turnsClient.DivisaDto;
import com.bbva.net.back.model.turnsClient.FormCurrencyDto;
import com.bbva.net.back.model.turnsClient.QuotationMoneyDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.back.model.turnsClient.turnsClientDto;

/**
 * @author Entelgy
 */
@Facade(value = "turnsOutwardsFacade")
public class TurnsOutwardsFacadeImpl extends AbstractBbvaFacade implements TurnsOutwardsFacade {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public List<turnsClientDto> getTurns(final String productId, final DateRangeDto dateRange, final Integer paginationKey, final Integer pageSize) {
        List<turnsClientDto> turnsClientOutside = new ArrayList<turnsClientDto>();
        turnsClientDto turns = new turnsClientDto("T00283", new Date(05102015), "STD", "EUR", new BigDecimal(7600000), "3,655.00",
                "Liberado / Efectuado", "IN", "");
        turnsClientDto turns2 = new turnsClientDto("T002370", new Date(14092015), "STD1", "USD", new BigDecimal(100456123), "1,965.00", "Proceso",
                "1898", "");
        turnsClientOutside.add(turns);
        turnsClientOutside.add(turns2);
        return turnsClientOutside;
    }

    @Override
    public turnsClientDetailDto onTurnDetail(final String productId, final String movementId) {
        turnsClientDetailDto turnsDetail = new turnsClientDetailDto(new Date(), "T00283", new Date(), "STD", "Transferencia personal",
                "SETECIENTOS SESENTA MIL", "34252435",
                new ContactDto("Pepito Gomez", "Carrera 22 B N° 50 - 40", "34573456", new CityDto("Inglaterra", "3", "Londres", "4"), "",
                        new BankDto("Citibank", new CityDto("Colombia", "1", "Bogotá", "2"), "796001880", "3535")),
                new ContactDto("Fermando dolores", "Carrera 30 C N° 13 - 28", "4523176", new CityDto("Colombia", "1", "Bogota", "2"), "",
                        new BankDto("Citibank", new CityDto("Inglaterra", "2", "Londres", "3"), "34567786785", "5050")),
                new BankDto("Bancolombia", new CityDto("Argentina", "3", "Lima", "4"), "796001880", "3030"),
                new FormCurrencyDto("4", "1", ""), new QuotationMoneyDto(new DivisaDto("EUR", "3"), new BigDecimal(5000), "0013-0411-00-398000030",
                        "NM", "3,655.00", "3,655.00", "3,655.00", "3,655.00"));
        return turnsDetail;
    }
}
