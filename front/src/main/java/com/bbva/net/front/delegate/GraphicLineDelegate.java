package com.bbva.net.front.delegate;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalance;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.front.ui.line.LineConfigUI;

public interface GraphicLineDelegate {

	LineConfigUI getMonthlyBalance(GlobalMonthlyBalance globalMonthlyBalance);

	LineConfigUI getMovementAccount(GlobalResumeMovementsDto globalResumeMovements);

}
