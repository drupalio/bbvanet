package com.bbva.net.front.controller.impl;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.UserData.ForgotPasswordDto;
import com.bbva.net.front.controller.UserRecoverPassword;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "userRecoverPassword")
public class UserRecoverPasswordImpl extends AbstractBbvaController implements
		UserRecoverPassword {
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
}
