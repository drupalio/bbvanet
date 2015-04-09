package com.bbva.net.back.predicate;

import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumCheckBookStatus;
import com.bbva.net.core.collection.BbvaPredicate;

public class CheckBookStatusPredicate extends BbvaPredicate<CheckbookDto> {

	@Override
	protected boolean eval(final CheckbookDto checkBookDto) {

		if (checkBookDto == null || checkBookDto.getId() == null) {
			return false;
		} else if (checkBookDto.getActualState().equals("1")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("1").getValue());
		} else if (checkBookDto.getActualState().equals("A")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("A").getValue());
		} else if (checkBookDto.getActualState().equals("I")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("I").getValue());
		} else if (checkBookDto.getActualState().equals("O")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("O").getValue());
		} else if (checkBookDto.getActualState().equals("E")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("E").getValue());
		} else if (checkBookDto.getActualState().equals("B")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("B").getValue());
		} else if (checkBookDto.getActualState().equals("N")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("N").getValue());
		} else if (checkBookDto.getActualState().equals("C")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("C").getValue());
		} else if (checkBookDto.getActualState().equals("2")) {
			checkBookDto.setActualState(EnumCheckBookStatus.valueOfEnum("2").getValue());
		}

		return !checkBookDto.getActualState().isEmpty();
	}
}
