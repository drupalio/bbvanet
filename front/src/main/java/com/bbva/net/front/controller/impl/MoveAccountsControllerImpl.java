package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class MoveAccountsControllerImpl extends AbstractBbvaController {

	private String date;

	private List exam;

	private String valor;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void capturaFecha(javax.faces.event.AjaxBehaviorEvent e) {

		System.out.println("aw" + date);
	}
	public List getExam() {
		return exam;
	}

	public void setExam(List exam) {
		this.exam = exam;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@PostConstruct
	public void init() {

		exam = new ArrayList();
		exam.add("1");
		exam.add("2");
		exam.add("3");
		exam.add("4");
		exam.add("5");

	}

	public void seleccionC(ValueChangeEvent event) {
		System.out.print("Nuevo dato: " + event.getNewValue() + ", Viejo dato: " + event.getOldValue());
	}
	public void nextPage(){
		
	}
	public void seleccionACC(SelectEvent event) {
		System.out.print("Nuevo dato: " + event.getSource() + ", Viejo dato: " + event.getObject());
	}
}
