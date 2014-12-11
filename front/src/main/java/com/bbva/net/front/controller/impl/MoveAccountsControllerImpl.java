package com.bbva.net.front.controller.impl;

import org.springframework.stereotype.Controller;

import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class MoveAccountsControllerImpl extends AbstractBbvaController {

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void capturaFecha(javax.faces.event.AjaxBehaviorEvent e) {

		System.out.println("aw" + date);
	}

}
