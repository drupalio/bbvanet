package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TurnsOutwardsFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.turnsClient.BasicBankDto;
import com.bbva.net.back.model.turnsClient.BasicPersonDto;
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
        turnsClientDto turns = new turnsClientDto("T00283", new Date(05102015), "STD", "EUR", new Money(
                new BigDecimal(7600000)), "3,655.00", "Liberado / Efectuado", "IN", "");
        turnsClientDto turns2 = new turnsClientDto("T002370", new Date(14092015), "STD1", "USD", new Money(
                new BigDecimal(100456123)), "1,965.00", "Proceso", "1898", "");
        turnsClientOutside.add(turns);
        turnsClientOutside.add(turns2);
        return turnsClientOutside;
    }

    @Override
    public turnsClientDetailDto onTurnDetail(final String productId, final String movementId) {
        turnsClientDetailDto turnsDetail = new turnsClientDetailDto(new Date(05102015), "T00283",
                new BasicPersonDto("Pepito Perez", "796001880", "Colombia", "Bogotá"), new Date(),
                "STD", "Transferencia personal", new BasicPersonDto("Fermando Suarez", "", "Inglaterra", "Londres"),
                new BasicBankDto("Citibank", "Inglaterra", "0987"), new BasicBankDto("Bancolombia", "Argentina", "1344"), "EUR", "NM",
                "0013-0411-00-398000030", new Money(new BigDecimal(3655)), new Money(new BigDecimal(1965)), "1", "SETECIENTOS SESENTA MIL",
                new Money(new BigDecimal(7600000)), "34252435", new Money(new BigDecimal(3655)), new Money(new BigDecimal(277784)), "3535");
        return turnsDetail;
    }
}
