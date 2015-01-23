package com.bbva.net.webservices.loan.impl;

import com.bbva.czic.dto.net.Account;
import com.google.gson.Gson;

public class GenerateJSON {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String account = gson.toJson(getAccount());
		System.out.println(account);
	}

	public static Account getAccount() {
		return null;
	}

}
