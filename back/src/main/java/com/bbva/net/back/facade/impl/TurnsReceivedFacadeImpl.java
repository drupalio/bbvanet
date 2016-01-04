package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TurnsReceivedFacade;
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
@Facade(value = "turnsReceivedFacade")
public class TurnsReceivedFacadeImpl extends AbstractBbvaFacade implements TurnsReceivedFacade {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public List<turnsClientDto> getTurns(final String productId, final DateRangeDto dateRange, final Integer paginationKey, final Integer pageSize) {
        List<turnsClientDto> turnsClientRecived = new ArrayList<turnsClientDto>();
        turnsClientDto turns = new turnsClientDto("H001252", new Date(14092015), "STD1", "USD", new BigDecimal(5985), "1.0000",
                "Liberado / Efectuado", "", "796001880");
        turnsClientDto turns2 = new turnsClientDto("H000828", new Date(06012015), "STD", "EUR", new BigDecimal(5000), "1.0000",
                "Liberado / Efectuado", "", "796001880");
        turnsClientRecived.add(turns);
        turnsClientRecived.add(turns2);
        return turnsClientRecived;
    }

    @Override
    public turnsClientDetailDto onTurnDetail(final String productId, final String movementId) {
        turnsClientDetailDto turnsDetail = new turnsClientDetailDto(new Date(), "H001252", new Date(), "STD", "Transferencia personal", "CINCO MIL",
                "34252435", new ContactDto("Pepito Perez", "Carrera 35 B N° 30 - 40", "45634765", new CityDto("Colombia", "1", "Bogotá", "2"), "",
                        new BankDto("Citibank", new CityDto("Colombia", "1", "Bogotá", "2"), "796001880", "3535")),
                new ContactDto("Fermando Suarez", "Carrera 40 C N° 50 - 35", "30976394", new CityDto("Inglaterra", "2", "Londres", "3"), "",
                        new BankDto("Citibank", new CityDto("Inglaterra", "2", "Londres", "3"), "34567786785", "5050")),
                new BankDto("Bancolombia", new CityDto("Argentina", "3", "Lima", "4"), "796001880", "3030"),
                new FormCurrencyDto("4", "1", ""), new QuotationMoneyDto(new DivisaDto("USD", "2"), new BigDecimal(5000), "0013-0411-00-398000030",
                        "NM", "3,655.00", "3,655.00", "3,655.00", "3,655.00"));
        return turnsDetail;
    }
}
