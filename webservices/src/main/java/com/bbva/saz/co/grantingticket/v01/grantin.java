package com.bbva.saz.co.grantingticket.v01;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

public class grantin {

	public static void main(String[] args) {

		ConsumerContext consumerContext = new ConsumerContext();
		Authentication autentication = new Authentication();
		UserPreferences userPreferences = new UserPreferences();
		AuthenticationData authenticationData = new AuthenticationData();

		// Authentication-Data
		authenticationData.setKey("iv_ticketService");
		authenticationData.getValue().add(
				"cqwAIvi92lzshpPQR9RYK2RFo9axRY697/TtCA4N/bnM6d5znws5S1T3rYwHVRU3YnYvpZZXF4s=");

		// Authentication
		/**
		 * Concatenaciópn de Nick Usuario + Tipo de documento (identificationType) + Identification
		 */
		autentication.setUserId("julio123CC000001020715321");
		autentication.setConsumerId("12000001");
		autentication.setAuthenticationType("00");
		autentication.getAuthenticationData().add(authenticationData);

		// UserPreferences
		userPreferences.setUserId(StringUtils.EMPTY);
		userPreferences.setAccessCode("julio123CC000001020715321");
		userPreferences.setDialogId(StringUtils.EMPTY);
		// ConsumerContext
		consumerContext.setUserPreferences(userPreferences);
		consumerContext.setAuthentication(autentication);

		final Gson gson = new Gson();
		String json = gson.toJson(consumerContext);
		System.out.println(json);
	}
}
