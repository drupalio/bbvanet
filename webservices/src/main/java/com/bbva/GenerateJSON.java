// package com.bbva;
//
// import java.math.BigDecimal;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Random;
//
// import org.fluttercode.datafactory.impl.DataFactory;
//
// import com.bbva.czic.dto.net.Check;
// import com.bbva.czic.dto.net.Checkbook;
// import com.bbva.czic.dto.net.EnumCheckbookStatus;
// import com.bbva.czic.dto.net.Movement;
// import com.bbva.jee.arq.spring.core.servicing.utils.Money;
// import com.google.gson.Gson;
//
// public class GenerateJSON {
//
// public static void main(String[] args) {
// Gson gson = new Gson();
// String checkJSON = gson.toJson(getMovementList());
// System.out.println(checkJSON);
// getMovementList();
// }
//
// public static String dateToSring(Date date) {
// String str = null;
// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
// str = dateFormat.format(date);
// return str;
// }

//
// public static <E> Checkbook getCheckbook() {
// Checkbook checkBook = new Checkbook();
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// Date end = dataFactory.getDateBetween(start, maxDate);
//
// checkBook.setActualState(EnumCheckbookStatus.HABILITADO);
// //checkBook.setDeliveryDate(dateToSring(start));
// checkBook.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// //checkBook.setRequestDate(dateToSring(end));
// checkBook.setTotalCheck(dataFactory.getNumberUpTo(10));
// return checkBook;
//
// }
//
// public static <E> Check getCheck() {
// Check check = new Check();
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// Date end = dataFactory.getDateBetween(start, maxDate);
// Money money = new Money();
//
// check.setId(new Random().nextInt(Integer.MAX_VALUE) + "");
// check.setIssueDate(dateToSring(start));
// check.setModifiedDate(dateToSring(end));
// check.setStatus("HABILITADO");
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + "1"));
// money.setCurrency("COP");
// check.setValue(money);
//
// return check;
//
// }
// public static <E> Movement getMovementDetail() {
//
// Movement movementDetail = new Movement();
//
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
//
// Money money;
//
// movementDetail.setBalance(value);
// movementDetail.setConcept(value);
// movementDetail.setDestinationReference(value);
// movementDetail.setNumberOfQuotas(value);
// movementDetail.setOffice(value);
// movementDetail.set
// movementDetail.set
// movementDetail.set
// movementDetail.set
// movementDetail.set
//
// return movementDetail;
// }
//
//
//
// public static <E> List<Movement> getMovementList() {
// List<Movement> movementList = new ArrayList<Movement>();
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
//
// Movement movement;
// Money money;
// for (int i = 0; i < 10; i++) {
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// movement = new Movement();
// money = new Money();
// movement.setId(new Random().nextInt(Integer.MAX_VALUE) + "");
// movement.setConcept("Pago cupo rotativo");
// movement.setTransactionDate(dateToSring(start));
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + ""));
// money.setCurrency("COP");
// movement.setValue(money);
// movement.setBalance(money);
// movementList.add(movement);
//
// }
// return movementList;
// }

// public static <E> List<Check> getCheckList() {
//
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
//
// Check check;
// Money money;
//
// List<Check> checkList = new ArrayList<Check>();
//
// for (int i = 0; i < 30; i++) {
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// Date end = dataFactory.getDateBetween(start, maxDate);
// check = new Check();
// money = new Money();
// check.setId(new Random().nextInt(Integer.MAX_VALUE) + "1");
// check.setIssueDate(dateToSring(start));
// check.setModifiedDate(dateToSring(end));
// check.setStatus("HABILITADO");
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + "1"));
// money.setCurrency("COP");
// check.setValue(money);
// checkList.add(check);
// }
//
// return checkList;
// }
//
// }
