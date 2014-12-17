package com.bbva.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Operation;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.dto.net.State;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.net.core.utils.FileBbvaUtils;

public class GenerateJson {

	public static void main(String[] args) {

		System.out.println(FileBbvaUtils.getJsonString(getProducts()));

	}

	public static ArrayList<Product> getProducts() {

		ArrayList<Product> productList = new ArrayList<Product>();

		for (int i = 0; i < 20; i++) {

			Product product = new Product();

			product.setAlias("Mi Cuenta A" + i);
			product.setConditions(getConditions());
			product.setId("2020");
			product.setMovement(getMovements());

			product.setContactInfo(getContactInfo());
			product.setFinancialState(EnumFinancialStatusType.A);
			product.setBalance(getBalance());
			product.setName("Cuenta");
			product.setOperable(true);
			product.setType(EnumProductType.PC);
			product.setVisible(true);

			productList.add(product);

		}

		return productList;
	}

	public static Money getMoney() {
		Money money = new Money();
		money.setAmount(new BigDecimal(100000));
		money.setCurrency("$");

		return money;

	}

	public static ContactInfo getContactInfo() {
		List<Email> emailList = new ArrayList<Email>();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		Email email = new Email();
		email.setActive(true);
		email.setAddres("xxx@gmail.com");
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emailList.add(email);

		Email emailTwo = new Email();
		emailTwo.setActive(true);
		emailTwo.setAddres("yoyoyo@yahoo.com");
		emailTwo.setPrimary(false);
		emailTwo.setSource(EnumContactSourceType.WEB);
		emailList.add(emailTwo);

		PhoneNumber phoneNumber = new PhoneNumber();

		phoneNumber.setActive(true);
		phoneNumber.setContactSource(EnumContactSourceType.MOBILE);
		phoneNumber.setCountryCode("57");
		phoneNumber.setNumber("5555555");
		phoneNumber.setPrimary(true);
		phoneNumber.setRegionalCode("1");
		phoneNumber.setType(EnumPhoneNumberType.LANDLINE);
		phoneList.add(phoneNumber);

		PhoneNumber phoneNumber2 = new PhoneNumber();

		phoneNumber2.setActive(true);
		phoneNumber2.setContactSource(EnumContactSourceType.MOBILE);
		phoneNumber2.setCountryCode("57");
		phoneNumber2.setNumber("5555555");
		phoneNumber2.setPrimary(true);
		phoneNumber2.setRegionalCode("1");
		phoneNumber2.setType(EnumPhoneNumberType.LANDLINE);
		phoneList.add(phoneNumber2);

		ContactInfo contact = new ContactInfo();
		contact.setEmails(emailList);
		contact.setPhoneNumbers(phoneList);

		return contact;

	}

	public static List<Movement> getMovements() {

		Operation operation = new Operation();
		List<Movement> movementList = new ArrayList<Movement>();
		Movement movement = new Movement();

		operation.setDescription("Pago Movistar");
		operation.setCode("0987");
		movement.setBalance(getMoney());
		movement.setConcept("Pago");
		movement.setDestinationReference("Movistar 123");
		movement.setId("456");
		movement.setOperation(operation);
		movement.setSourceReference("12-23");

		movement.setValue(getMoney());
		movementList.add(movement);
		movementList.add(movement);
		Movement movement2 = new Movement();
		movement2.setBalance(getMoney());
		movement2.setConcept("Transferencia");
		movement2.setDestinationReference("559900");
		movement2.setId("411");
		movement2.setOperation(operation);
		movement2.setSourceReference("08-23");

		movement2.setValue(getMoney());
		movementList.add(movement2);
		return movementList;

	}

	public static Balance getBalance() {

		Balance balance = new Balance();

		balance.setAvailableBalance(getMoney());
		balance.setTotal(getMoney());

		return balance;
	}

	public static Conditions getConditions() {

		Conditions conditions = new Conditions();

		conditions.setCategory("Some Category");
		conditions.setCommission("8");
		conditions.setDescription("Some Description");
		conditions.setMobilizationConditions("Some mobilizationConditions");
		conditions.setOffice(getOffice());
		conditions.setOpeningDate("17-12-2014");

		return conditions;
	}

	public static Office getOffice() {

		Office office = new Office();

		office.setCode("22");
		office.setLocation(getLocation());
		office.setName("Rosales");
		office.setPostalAddress("A-345");

		return office;

	}

	public static Location getLocation() {

		Location location = new Location();
		City city = new City();
		State state = new State();
		Country country = new Country();

		country.setId("57");
		country.setName("Colombia");

		state.setCountry(country);
		state.setId("Bogotá DC");
		state.setName("Bogota");

		city.setId("01");
		city.setName("Bogota");
		city.setState(state);

		location.setCategory("Some Category");
		location.setCity(city);

		return location;

	}

}
