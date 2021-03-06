package com.bbva.net.front.delegate;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

public interface GraphicBarLineDelegate {

	AccountBarLineUI getInOutBalanceAccount(GlobalResumeMovementsDto globalResumenMovementsDTO);

}
