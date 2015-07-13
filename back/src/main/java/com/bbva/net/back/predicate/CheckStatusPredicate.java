/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class CheckStatusPredicate extends BbvaPredicate<CheckDto> {

	@Override
	protected boolean eval(final CheckDto checkDto) {

		if (checkDto == null || checkDto.getId() == null) {
			return false;
		} else if (checkDto.getStatus() == null) {
			checkDto.setStatus(" ");
		} else if (checkDto.getStatus().contentEquals("0")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("0")).getValue());
		} else if (checkDto.getStatus().contentEquals("1")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("1")).getValue());
		} else if (checkDto.getStatus().contentEquals("2")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("2")).getValue());
		} else if (checkDto.getStatus().contentEquals("3")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("3")).getValue());
		} else if (checkDto.getStatus().contentEquals("4")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("4")).getValue());
		} else if (checkDto.getStatus().contentEquals("8")) {
			checkDto.setStatus(EnumCheckStatus.valueOf(Integer.parseInt("8")).getValue());
		}

		return !checkDto.getStatus().isEmpty();
	}
}
