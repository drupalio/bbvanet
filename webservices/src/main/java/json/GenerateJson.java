package json;

import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.State;
import com.google.gson.Gson;

public class GenerateJson {

	public static void main(String[] args) {

		Gson json = new Gson();

		System.out.println(json.toJson(getExecutive()));

	}

	public static Executive getExecutive() {
		Office ofic = new Office();
		Location location = new Location();
		Executive exce = new Executive();
		City city = new City();
		State state = new State();

		Country country = new Country();
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

		exce.setOffice(ofic);
		exce.setEmail("Jhon002@gmail.com");
		exce.setName("Jhon ");
		exce.setId("123");
		exce.setPhone("3212324");

		return exce;
	}

}
