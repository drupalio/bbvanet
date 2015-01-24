package com.bbva.net.back.utils;

import java.util.Arrays;
import java.util.List;

import com.bbva.czic.dto.net.EnumProductType;

public final class ProductUtils {

	public static EnumProductType getEnumProductTypeBySubType(final String subType) {

		String cuentasVect[] = { "CC", "AH", "CT", "CD", "CE" };
		List<String> cuentasList = Arrays.asList(cuentasVect);

		String cupoVect[] = { "CR" };
		List<String> cupoList = Arrays.asList(cupoVect);

		String foundsVect[] = { "FA", "BD", "BF", "PA", "BP", "FN", "FC", "FE", "FZ", "AN", "FG", "MD", "FR", "FB" };
		List<String> foundList = Arrays.asList(foundsVect);

		String pensionesVect[] = { "FP" };
		List<String> pensionesList = Arrays.asList(pensionesVect);

		String loanVect[] = { "HI", "CS", "CM", "MC", "CL" };
		List<String> loanList = Arrays.asList(loanVect);

		String cardVect[] = { "TC", "TE", "TO" };
		List<String> cardList = Arrays.asList(cardVect);

		String leasingVect[] = { "LS" };
		List<String> leasingList = Arrays.asList(leasingVect);

		if (cuentasList.contains(subType)) {
			return EnumProductType.PC;
		} else if (cupoList.contains(subType)) {
			return EnumProductType.RQ;
		} else if (foundList.contains(subType)) {
			return EnumProductType.SI;
		} else if (pensionesList.contains(subType)) {
			return null;
		} else if (loanList.contains(subType)) {
			return EnumProductType.LO;
		} else if (cardList.contains(subType)) {
			return EnumProductType.TC;
		} else if (leasingList.contains(subType)) {
			return EnumProductType.LI;
		}

		return null;
	}

}