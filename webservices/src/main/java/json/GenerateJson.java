package json;

import java.math.BigDecimal;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.State;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.google.gson.Gson;

public class GenerateJson {

	public static void main(String[] args) {

		Gson json = new Gson();

		System.out.println(json.toJson(getLoan()));

	}

	public static Loan getLoan() {

		Office ofic = new Office();
		Location location = new Location();
		City city = new City();
		State state = new State();
		Country country = new Country();
		Loan loan = new Loan();
		Balance balance = new Balance();
		Money money = new Money();
		Conditions condiciones = new Conditions();
		ContactInfo contactInfo = new ContactInfo();
		EnumFinancialStatusType d = null;
		EnumFinancialStatusType c2 = null;

		money.setAmount(new BigDecimal(1000000));
		money.setCurrency("COP");

		country.setId("12");
		country.setName("Colombia");

		state.setCountry(country);
		state.setId("123456");
		state.setName("Cundinamarca");

		city.setState(state);
		city.setId("123");
		city.setName("Bogota");

		location.setCity(city);
		location.setCategory("Kennedy");

		ofic.setLocation(location);
		ofic.setCode("0073");
		ofic.setName("BBVA 23247");
		ofic.setPostalAddress("Calle 36");

		balance.setAvailableBalance(money);
		balance.setTotal(money);

		condiciones.setCategory("Categoria");
		condiciones.setCommission("Comision");
		condiciones.setDescription("Descripcion");
		condiciones.setMobilizationConditions("condiciones movilizacion");
		condiciones.setOffice(ofic);
		condiciones.setOpeningDate("Fecha de apertura");

		loan.setAlias("Alias Loan");
		loan.setBalance(balance);
		loan.setConditions(condiciones);
		loan.setContactInfo(contactInfo);
		loan.setFinancialState(d);
		loan.setId("IDLoan");
		loan.setName("nombre Loan");
		loan.setOperable(true);
		loan.setType(null);
		loan.setVisible(true);

		return loan;
	}

}
