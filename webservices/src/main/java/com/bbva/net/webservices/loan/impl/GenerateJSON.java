package com.bbva.net.webservices.loan.impl;

import java.math.BigDecimal;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.State;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.google.gson.Gson;

public class GenerateJSON {
/*
	public static void main(String[] args) {
		Gson gson = new Gson();
		String loanJSON = gson.toJson(getLoan());
		System.out.println(loanJSON);
	}

	public static <E> Loan getLoan() {
		Loan loan = new Loan();
		loan.setAlias("xxxx");
		loan.setId("loanQuotaRotary");
		loan.setFinancialState(EnumFinancialStatusType.A);
		loan.setName("Rotary");
		loan.setOperable(false);
		loan.setType(EnumProductType.SI);
		loan.setVisible(true);

		Balance balance = new Balance();
		Money moneyAvailable = new Money();
		Money moneyTotal = new Money();
		moneyAvailable.setAmount(new BigDecimal(200));
		moneyAvailable.setCurrency("$");
		moneyTotal.setAmount(new BigDecimal(500));
		moneyTotal.setCurrency("$");
		balance.setAvailableBalance(moneyAvailable);
		balance.setTotal(moneyTotal);
		loan.setBalance(balance);

		Conditions conditions = new Conditions();
		conditions.setAlias("conditions");
		conditions.setCategory("2");
		conditions.setCommission("ninguna");
		conditions.setDescription("ninguna");
		conditions.setMobilizationConditions("ninguna");
		Office office = new Office();
		office.setCode("12345");
		Location location = new Location();
		location.setCategory("2");
		City city = new City();
		city.setId("1");
		city.setName("Bogota");
		location.setCity(city);
		Country country = new Country();
		country.setId("1");
		country.setName("Colombia");
		location.setCountry(country);
		location.setPostalAddress("cra 15 n° 142 -74");
		State state = new State();
		state.setId("1");
		state.setName("");
		location.setState(state);
		office.setLocation(location);
		office.setName("office");
		office.setPostalAddress("cra 15 n° 142 -74");
		conditions.setOffice(office);
		loan.setConditions(conditions);

		ContactInfo contactInfo = new ContactInfo();
		loan.setContactInfo(contactInfo);

		Contract contract = new Contract();
		contract.setNumber("31543576655");
		loan.setContract(contract);

		return loan;
	}*/
}
