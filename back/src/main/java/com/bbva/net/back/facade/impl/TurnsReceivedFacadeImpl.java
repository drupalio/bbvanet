package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TurnsReceivedFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.turnsClient.BasicBankDto;
import com.bbva.net.back.model.turnsClient.BasicPersonDto;
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
        turnsClientDto turns = new turnsClientDto("H001252", new Date(14092015), "STD1", "USD", new Money(
                new BigDecimal(5985)), "1.0000", "Liberado / Efectuado", "", "796001880");
        turnsClientDto turns2 = new turnsClientDto("H000828", new Date(06012015), "STD", "EUR", new Money(
                new BigDecimal(5000)), "1.0000", "Liberado / Efectuado", "", "796001880");
        turnsClientRecived.add(turns);
        turnsClientRecived.add(turns2);
        return turnsClientRecived;
    }

    @Override
    public turnsClientDetailDto onTurnDetail(final String productId, final String movementId) {
        turnsClientDetailDto turnsDetail = new turnsClientDetailDto(new Date(), "H001252",
                new BasicPersonDto("Pepito Perez", "796001880", "Colombia", "Bogotá"), new Date(),
                "STD", "Transferencia personal", new BasicPersonDto("Fermando Suarez", "", "Inglaterra", "Londres"),
                new BasicBankDto("Citibank", "Inglaterra", "0987"), new BasicBankDto("Bancolombia", "Argentina", "1344"), "USD", "NM",
                "0013-0411-00-398000030", new Money(new BigDecimal(1)), new Money(new BigDecimal(3655)), "1", "CINCO MIL",
                new Money(new BigDecimal(5000)), "34252435", new Money(new BigDecimal(3655)), new Money(new BigDecimal(277784)), "3535");
        return turnsDetail;
    }
}
