package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.recoveryData.RecoverydDto;
import com.bbva.net.front.controller.RecoverPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "recoverPassController")
@Scope(value = "globalSession")
public class RecoverPasswordControllerImpl extends AbstractBbvaController implements RecoverPasswordController {

	private static final long serialVersionUID = 6795761532672076491L;

	private static final Integer LIST_DOC_TYPES = 4;

	private RecoverydDto recoveryDto;

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@PostConstruct
	public void init() {
		this.multiValueList = this.getListMultiValueDocuments();
	}

	@Override
	public List<MultiValueGroup> getListMultiValueDocuments() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_DOC_TYPES);
	}

	@Override
	public String showMessageCheck() {
		return "yes";
	}

	@Override
	public String respuesta() {
		System.out.println("Respuesta ");
		return "start";
	}

	/**
	 * @return the recoveryDto
	 */
	public RecoverydDto getRecoveryDto() {
		return recoveryDto;
	}

	/**
	 * @param recoveryDto the recoveryDto to set
	 */
	public void setRecoveryDto(RecoverydDto recoveryDto) {
		this.recoveryDto = recoveryDto;
	}

	/**
	 * @return the multiValueList
	 */
	public List<MultiValueGroup> getMultiValueList() {
		return multiValueList;
	}

	/**
	 * @param multiValueList the multiValueList to set
	 */
	public void setMultiValueList(List<MultiValueGroup> multiValueList) {
		this.multiValueList = multiValueList;
	}
}