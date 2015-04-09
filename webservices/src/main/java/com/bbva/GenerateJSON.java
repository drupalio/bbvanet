// package com.bbva;
//
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
//
// import org.fluttercode.datafactory.impl.DataFactory;
//
// import com.bbva.czic.dto.net.Checkbook;
// import com.bbva.czic.dto.net.EnumCheckbookStatus;
// import com.google.gson.Gson;
//
// public class GenerateJSON {
//
// public static void main(String[] args) {
// Gson gson = new Gson();
// String checkJSON = gson.toJson(getCheckbook());
// System.out.println(checkJSON);
// }
//
// public static String dateToSring(Date date) {
// String str = null;
// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
// str = dateFormat.format(date);
// return str;
// }
//
// public static <E> List<Checkbook> getCheckbook() {
// List<Checkbook> checkBook = new ArrayList<Checkbook>();
// Checkbook checkBook1 = new Checkbook();
// Checkbook checkBook2 = new Checkbook();
// Checkbook checkBook3 = new Checkbook();
// Checkbook checkBook4 = new Checkbook();
// Checkbook checkBook5 = new Checkbook();
// Checkbook checkBook6 = new Checkbook();
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// Date end = dataFactory.getDateBetween(start, maxDate);
//
// checkBook1.setActualState(EnumCheckbookStatus.ANULADO.getCode());
// checkBook1.setDeliveryDate(dateToSring(start));
// checkBook1.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook1.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook1.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook1.setRequestDate(dateToSring(end));
// checkBook1.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook1);
//
// checkBook2.setActualState(EnumCheckbookStatus.DE_BAJA.getCode());
// checkBook2.setDeliveryDate(dateToSring(start));
// checkBook2.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook2.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook2.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook2.setRequestDate(dateToSring(end));
// checkBook2.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook2);
//
// checkBook3.setActualState(EnumCheckbookStatus.PED_OFICINA.getCode());
// checkBook3.setDeliveryDate(dateToSring(start));
// checkBook3.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook3.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook3.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook3.setRequestDate(dateToSring(end));
// checkBook3.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook3);
//
// checkBook4.setActualState(EnumCheckbookStatus.EN_IMPRESOR.getCode());
// checkBook4.setDeliveryDate(dateToSring(start));
// checkBook4.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook4.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook4.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook4.setRequestDate(dateToSring(end));
// checkBook4.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook4);
//
// checkBook5.setActualState(EnumCheckbookStatus.PERDIDO.getCode());
// checkBook5.setDeliveryDate(dateToSring(start));
// checkBook5.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook5.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook5.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook5.setRequestDate(dateToSring(end));
// checkBook5.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook5);
//
// checkBook6.setActualState(EnumCheckbookStatus.EN_OFICINA.getCode());
// checkBook6.setDeliveryDate(dateToSring(start));
// checkBook6.setFirstCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook6.setId(dataFactory.getNumberUpTo(10) + "");
// checkBook6.setLastCheck(dataFactory.getNumberUpTo(10) + "");
// checkBook6.setRequestDate(dateToSring(end));
// checkBook6.setTotalCheck(dataFactory.getNumberUpTo(10));
// checkBook.add(checkBook6);
//
// return checkBook;
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
// check.setId(new Random().nextInt(Integer.MAX_VALUE) + "");
// check.setIssueDate(dateToSring(start));
// check.setModifiedDate(dateToSring(end));
// check.setStatus("Habilitado");
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + "1"));
// money.setCurrency("COP");
// check.setValue(money);
// return check;
// }
//
// // public static <E> Movement getMovementDetail() { Movement movementDetail = new
// // Movement(); DataFactory dataFactory = new DataFactory(); Date minDate = dataFactory.getDate(2014, 1, 1); Money
// money;
// // movementDetail.setBalance(value); movementDetail.setConcept(value); movementDetail.setDestinationReference(value);
// // movementDetail.setNumberOfQuotas(value); movementDetail.setOffice(value); movementDetail.set movementDetail.set
// // movementDetail.set movementDetail.set movementDetail.set return movementDetail; }
//
// public static <E> List<Movement> getMovementList() {
// List<Movement> movementList = new ArrayList<Movement>();
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
// Movement movement;
// Money money;
// for (int i = 0; i < 10; i++) {
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// movement = new Movement();
// money = new Money();
// movement.setId(new Random().nextInt(Integer.MAX_VALUE) + "");
// if (i % 2 != 0) {
// movement.setConcept("Transferencia");
// } else {
// movement.setConcept("Compra");
// }
// movement.setOperationDate(dateToSring(start));
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + ""));
// money.setCurrency("COP");
// movement.setValue(money);
// movement.setBalance(money);
// movementList.add(movement);
// }
// return movementList;
// }
//
// public static <E> List<Check> getCheckList() {
// DataFactory dataFactory = new DataFactory();
// Date minDate = dataFactory.getDate(2014, 1, 1);
// Date maxDate = new Date();
// Check check;
// Money money;
// List<Check> checkList = new ArrayList<Check>();
// for (int i = 0; i < 10; i++) {
// Date start = dataFactory.getDateBetween(minDate, maxDate);
// Date end = dataFactory.getDateBetween(start, maxDate);
// check = new Check();
// money = new Money();
// check.setId(new Random().nextInt(Integer.MAX_VALUE) + "1");
// check.setIssueDate(dateToSring(start));
// check.setModifiedDate(dateToSring(end));
// if (i % 2 != 0) {
// check.setStatus("0");
// } else {
// check.setStatus("8");
// }
// money.setAmount(new BigDecimal(new Random().nextInt(Integer.MAX_VALUE) + "1"));
// money.setCurrency("COP");
// check.setValue(money);
// checkList.add(check);
// }
// return checkList;
// }
// }
