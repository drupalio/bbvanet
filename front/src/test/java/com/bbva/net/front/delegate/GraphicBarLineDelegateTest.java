package com.bbva.net.front.delegate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.model.movements.MovementsResumeDto;
import com.bbva.net.front.delegate.impl.GraphicBarLineDelegateImpl;

public class GraphicBarLineDelegateTest {

	private GraphicBarLineDelegate graphicBarLineDelegate;

	private GlobalResumeMovementsDto globalResumeMovementsDto;

	private MovementsResumeDto movementsResumeDto;

	Money balance;

	Money inCome;

	Money outCome;

	EnumMonth month;

	@Before
	public void init() {

		this.graphicBarLineDelegate = new GraphicBarLineDelegateImpl();
		this.movementsResumeDto = new MovementsResumeDto();
		List<MovementsResumeDto> listMovementsResume = new ArrayList<MovementsResumeDto>();

		movementsResumeDto.setBalance(balance);
		movementsResumeDto.setInCome(inCome);
		movementsResumeDto.setOutCome(outCome);
		movementsResumeDto.setMonth(month);
		listMovementsResume.add(movementsResumeDto);

		this.globalResumeMovementsDto = new GlobalResumeMovementsDto();
		globalResumeMovementsDto.setMovementsResumeDto(listMovementsResume);

	}

	public void chekGetInOutBalanceAccount() {

	}

}
