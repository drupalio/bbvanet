package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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

	private RecoverydDto recoveryDto = new RecoverydDto();

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	private String binCard, cardNumber1, cardNumber2, cardNumber3, typeDoc;

	Integer passConfirm;

	boolean renderTermsAndConditions = false;

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
	public String close() {
		clean();
		System.out.println("Close");
		return "close";
	}

	@Override
	public String next() {
		System.out.println("next ");

		return "next";
	}

	@Override
	public void recoveryPass(final ActionEvent event) {
		StringBuilder sb = new StringBuilder();
		sb.append(getBinCard()).append(getCardNumber1()).append(getCardNumber2()).append(getCardNumber3());
		if (isRenderTermsAndConditions() == false) {
			setRenderTermsAndConditions(true);
		}

		if (recoveryDto.getCardKey() == getPassConfirm()) {

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta",
							"Por favor, escribe el mismo valor de nuevo."));
		}
	}

	@Override
	public void clean() {
		setRenderTermsAndConditions(false);
		setPassConfirm(null);
		setBinCard(null); setCardNumber1(null);setCardNumber2(null); setCardNumber3(null);;
		setTypeDoc(null);
		this.recoveryDto = new RecoverydDto();
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

	/**
	 * @return the binCard
	 */
	public String getBinCard() {
		return binCard;
	}

	/**
	 * @param binCard the binCard to set
	 */
	public void setBinCard(String binCard) {
		this.binCard = binCard;
	}

	/**
	 * @return the cardNumber1
	 */
	public String getCardNumber1() {
		return cardNumber1;
	}

	/**
	 * @param cardNumber1 the cardNumber1 to set
	 */
	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}

	/**
	 * @return the cardNumber2
	 */
	public String getCardNumber2() {
		return cardNumber2;
	}

	/**
	 * @param cardNumber2 the cardNumber2 to set
	 */
	public void setCardNumber2(String cardNumber2) {
		this.cardNumber2 = cardNumber2;
	}

	/**
	 * @return the cardNumber3
	 */
	public String getCardNumber3() {
		return cardNumber3;
	}

	/**
	 * @param cardNumber3 the cardNumber3 to set
	 */
	public void setCardNumber3(String cardNumber3) {
		this.cardNumber3 = cardNumber3;
	}

	/**
	 * @return the typeDoc
	 */
	public String getTypeDoc() {
		return typeDoc;
	}

	/**
	 * @param typeDoc the typeDoc to set
	 */
	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}

	/**
	 * @return the passConfirm
	 */
	public Integer getPassConfirm() {
		return passConfirm;
	}

	/**
	 * @param passConfirm the passConfirm to set
	 */
	public void setPassConfirm(Integer passConfirm) {
		this.passConfirm = passConfirm;
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

	/**
	 * @return the renderTermsAndConditions
	 */
	public boolean isRenderTermsAndConditions() {
		return renderTermsAndConditions;
	}

	/**
	 * @param renderTermsAndConditions the renderTermsAndConditions to set
	 */
	public void setRenderTermsAndConditions(boolean renderTermsAndConditions) {
		this.renderTermsAndConditions = renderTermsAndConditions;
	}
}