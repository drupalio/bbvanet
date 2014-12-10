package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private boolean stateGlobalPosition = true;

	public boolean isStateGlobalPosition() {
		return stateGlobalPosition;
	}

	public void setStateGlobalPosition(boolean stateGlobalPosition) {
		this.stateGlobalPosition = stateGlobalPosition;
	}

	private static final String DEFAULT_USER = "123";

	// private GraphicUI graphicUI;
	private Integer LISTA_QUIEROS = 1;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		LOGGER.info("STARTING BBVA NET .................");

	}

	@Override
	public GlobalProducts getCustomerProducts() {

		final GlobalProducts globalProductos = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(globalProductos);

		return globalProductos;
	}

	public void renderPieSituation() {
		this.activePanel = ActivePanelType.SITUATION;
	}

	public void renderPieAssets() {
		this.activePanel = ActivePanelType.ASSET;
	}

	public void renderPieFinanciation() {
		this.activePanel = ActivePanelType.FINANCIATION;
	}

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public String getActivePanel() {
		return this.activePanel.name();
	}

	public SituationPiesUI getSituationGraphicPieUI() {
		return situationGraphicPieUI;
	}

	/**
	 * @return the listMultiValueLikes
	 */
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LISTA_QUIEROS);
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

	public String goAccounts() {
		return "accounts";
	}
	
	public void hola(ActionEvent action){
		JOptionPane.showMessageDialog(null,"hola!!");
	}

}
