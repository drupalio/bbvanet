package com.bbva.net.back.facade.impl;

import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.core.pattern.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.dao.PruebaDao;
import com.bbva.net.back.entity.Prueba;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.PruebaFacade;
import com.google.gson.Gson;

@Facade(value = "pruebaFacade")
public class PruebaFacadeImpl extends AbstractBbvaFacade implements
		PruebaFacade {

	private String cadena;

	@Resource(name = "pruebaDao")
	private transient PruebaDao pruebaDao;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	public PruebaFacadeImpl() {
		this.cadena = "LUIS";
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(final String cadena) {
		this.cadena = cadena;
	}

	public void setPruebaDao(final PruebaDao pruebaDao) {
		this.pruebaDao = pruebaDao;
	}

	@Override
	public Prueba getPrueba() {
		final Prueba prueba = pruebaDao.getByID(1L, Prueba.class);
		return prueba;
	}

	public static void main(final String[] args) {

		Account obj = new Account();
		// obj.setOverDraft(BigDecimal.ONE);
		Product product = new Product();
		product.setAlias("hola");
		product.setAsset(true);
		// product.setCashAvailable(BigDecimal.ONE);
		product.setProductId("dasfa");
		product.setProductName("hohooas");
		product.setProductNumber("123113213");
		// product.setTotalCash(BigDecimal.ONE);
		obj.setProduct(product);
		Gson gson = new Gson();

		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(obj);

		try {
			// write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("c:\\bin\\file.json");
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(json);

	}

}
