package com.bbva.net.front.controller.impl;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.UserData.ForgotPasswordDto;
import com.bbva.net.front.controller.RecoverPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "recoverPassController")
public class RecoverPasswordControllerImpl extends AbstractBbvaController implements
		RecoverPasswordController {
	private static final long serialVersionUID = 6795761532672076491L;

	private ForgotPasswordDto forgotPasswordDto;

	/**
	 * action to send in current flow
	 */

	@Override
	public String showMessageCheck() {
		return "yes";
	}

	public ForgotPasswordDto getForgotPasswordDto() {
		return forgotPasswordDto;
	}

	public void setForgotPasswordDto(ForgotPasswordDto forgotPasswordDto) {
		this.forgotPasswordDto = forgotPasswordDto;
	}
	
	
	public String respuesta(){
		System.out.println("Respuesta ");
		return "start";
	} 
}
