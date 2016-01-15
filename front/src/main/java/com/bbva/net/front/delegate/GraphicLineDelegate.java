package com.bbva.net.front.delegate;

import java.util.List;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.front.ui.line.LineConfigUI;

public interface GraphicLineDelegate {

    LineConfigUI getMonthlyBalance(GlobalMonthlyBalanceDto globalMonthlyBalance);

    LineConfigUI getMovementAccount(List<MovementDto> globalResumeMovements);

    /**
     * @param globalResumeMovements
     * @return
     */
    LineConfigUI getMovementDivisa(List<turnsClientDetailDto> globalResumeMovements);

}
