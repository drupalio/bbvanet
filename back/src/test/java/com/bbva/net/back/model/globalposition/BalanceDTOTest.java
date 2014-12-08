package com.bbva.net.back.model.globalposition;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BalanceDTOTest {

	public static void main(String[] args) {

		BalanceDTO balanceDTO = new BalanceDTO();
		balanceDTO.setAvailableBalance(new BigDecimal("2.56"));
		balanceDTO.setTotalBalance(new BigDecimal("5356.32"));

		try {

			File file = new File("src/test/resources/balanceDTO.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BalanceDTO.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(balanceDTO, file);
			jaxbMarshaller.marshal(balanceDTO, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
