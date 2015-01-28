//package com.bbva;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//import org.fluttercode.datafactory.impl.DataFactory;
//
//import com.bbva.czic.dto.net.Check;
//import com.bbva.czic.dto.net.Checkbook;
//import com.bbva.czic.dto.net.EnumCheckbookStatus;
//import com.bbva.jee.arq.spring.core.servicing.utils.Money;
//import com.google.gson.Gson;
//
//public class GenerateJSON {
//
//	public static void main(String[] args) {
//		Gson gson = new Gson();
//		String checkJSON = gson.toJson(getCheck());
//		System.out.println(checkJSON);
//		getCheck();
//	}
//
//	
//	public static String dateToSring(Date date){
//		String str= null;
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		str = dateFormat.format(date);		
//		return str;
//	}
//	
//	
//	
//	public static <E> Checkbook getCheckbook() {
//		Checkbook checkBook = new Checkbook();
//		DataFactory dataFactory = new DataFactory();
//		
//		checkBook.setActualState(EnumCheckbookStatus.HABILITADO);
//		//checkBook.setDeliveryDate(value);
//		checkBook.setFirstCheck(dataFactory.getNumberUpTo(10));
//		checkBook.setId(dataFactory.getNumberUpTo(10)+"");
//		checkBook.setLastCheck(dataFactory.getNumberUpTo(10));
//		//checkBook.setRequestDate(value);
//		checkBook.setTotalCheck(dataFactory.getNumberUpTo(10));
//		return checkBook;
//		
//	}
//	
//
//	public static <E> Check getCheck() {
//		Check check = new Check();
//		DataFactory dataFactory = new DataFactory();
//		Date minDate = dataFactory.getDate(2014, 1, 1);
//		Date maxDate = new Date();
//		Date start = dataFactory.getDateBetween(minDate, maxDate);			
//		Date end = dataFactory.getDateBetween(start, maxDate);
//		Money money = new Money() ;
//		
//		
//		
//		check.setId(new Random().nextInt(Integer.MAX_VALUE)+"");
//		check.setIssueDate(dateToSring(start));
//		check.setModifiedDate(dateToSring(end));
//		check.setStatus("HABILITADO");
//		money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE)+"1"));
//		money.setCurrency("COP");
//		check.setValue(money);
//
//		return check;
//		
//	}
//	
//	
//	
//	public static <E> List<Check> getCheckList() {		
//		
//		DataFactory dataFactory = new DataFactory();
//		Date minDate = dataFactory.getDate(2014, 1, 1);
//		Date maxDate = new Date();
//		
//		Check check;
//		Money money ;
//
//		List<Check> checkList = new ArrayList<Check>();
//		
//		for (int i = 0; i < 10; i++) {
//			Date start = dataFactory.getDateBetween(minDate, maxDate);			
//			Date end = dataFactory.getDateBetween(start, maxDate);
//			check = new Check();
//			money = new Money();
//			check.setId(new Random().nextInt(Integer.MAX_VALUE)+"1");
//			check.setIssueDate(dateToSring(start));
//			check.setModifiedDate(dateToSring(end));
//			check.setStatus("HABILITADO");
//			money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE)+"1"));
//			money.setCurrency("COP");
//			check.setValue(money);
//			checkList.add(check);
//		}
//
//
//		return checkList;
//	}
//
//}