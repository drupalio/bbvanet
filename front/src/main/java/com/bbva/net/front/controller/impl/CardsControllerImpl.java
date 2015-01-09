package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import org.apache.cxf.jaxrs.ext.search.client.SearchConditionBuilder;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.facade.MovementsResumeFacade;
import com.bbva.net.front.controller.CardsController;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

@ManagedBean
@ViewScoped
public class CardsControllerImpl extends AbstractBbvaController implements CardsController {

	private static final long serialVersionUID = 5726824668267606699L;

	private String selectedLike;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;
	
	@Resource(name = "cardsFacade")
	private transient CardsFacade cardsFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private GlobalProductsDto globalProductsDTO;

	private PieConfigUI graphicPieCards;

	private Map<String, List<String>> namesProducts;
	
	private String datos;

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

		// Get GlobalProductsDTO by currentUser (visibles and hidden)
		this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());
		
		// Calculate situation graphics panels
		this.graphicPieCards=graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(getCurrentUser()));

		// Get names of products
		this.namesProducts = globalPositionFacade.getNamesProducts(globalProductsDTO);

	}

	@Override
	public void preRender(final ComponentSystemEvent event) {
		
	}

	@Override
	public GlobalProductsDto getCustomerProducts() {
		return this.globalPositionFacade.getGlobalProductsVisibles(globalProductsDTO);
	}

	/**
	 * @return the selectedLike
	 */
	public String getSelectedLike() {
		return selectedLike;
	}
	/**
	 * @param selectedLike the selectedLike to set
	 */
	public void setSelectedLike(final String selectedLike) {
		this.selectedLike = selectedLike;
	}

	/**
	 * @return
	 */
	public PieConfigUI getGraphicPieCards() {
		return graphicPieCards;
	}

	/**
	 * @param graphicPieCards
	 */
	public void setGraphicPieCards(PieConfigUI graphicPieCards) {
		this.graphicPieCards = graphicPieCards;
	}

	/**
	 * 
	 */
	public void initChart() {
		executeScript("initChart();");
	}

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");

	}
	/**
	 * Filter combo of Cards
	 */
	public void onComboSelectedCard() {
		System.out.println("Seleciona combo tarjetas"+datos);
		if(MessagesHelper.INSTANCE.getString("text.allCards").equals(datos)){
			this.graphicPieCards=graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(getCurrentUser()));
		}else{
			SearchConditionBuilder b = SearchConditionBuilder.instance();
			//String ret = b.is("foo").greaterThan(20).and("bar").equalTo("plonk").query();
			//String ret = b.is(datos))
			//(chargeDate=ge={startDate};chargeDate=le={enDate})
			//this.graphicPieCards = graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesFilter(getCurrentUser(),"",""));
			//this.graphicPieCards = graphicPieDelegate.getAccountsfundsProducts(this.fundDTOs);
		}
	}

	/************************************* SETTER BEANS **************************************/

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public Map<String, List<String>> getNamesProducts() {
		return namesProducts;
	}
	
	public void setCardsFacade(CardsFacade cardsFacade) {
		this.cardsFacade = cardsFacade;
	}

	public CardsFacade getCardsFacade() {
		return cardsFacade;
	}
}
