package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.SituationPiesUI;

@Controller(value = "globalPositionController")
public class GlobalPositionControllerImpl extends AbstractBbvaController implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	// private GraphicUI graphicUI;
	private Integer LISTA_QUIEROS = 1;

	private String selectedLike;

	private List<String> listPrb;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private AccountDTO selectedProduct;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private transient boolean stateGlobalPosition = true;

	private List exam;

	private String valor;

	public boolean isStateGlobalPosition() {
		return stateGlobalPosition;
	}

	public void setStateGlobalPosition(boolean stateGlobalPosition) {
		this.stateGlobalPosition = stateGlobalPosition;
	}

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	@PostConstruct
	public void init() {

		listPrb = new ArrayList<String>();
		listPrb.add("hola 0");
		listPrb.add("holaa 1");
		listPrb.add("hoolaa 2");

		LOGGER.info("STARTING BBVA NET .................");

	}

	@Override
	public GlobalProductsDTO getCustomerProducts() {
		exam = new ArrayList();
		exam.add("1");
		exam.add("2");
		exam.add("3");
		exam.add("4");
		exam.add("5");
		final GlobalProductsDTO globalProductos = this.globalPositionFacade.getGlobalProductsByUser(getCurrentUser());

		situationGraphicPieUI = graphicPieDelegate.getSituationGlobalProducts(globalProductos);

		return globalProductos;
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

	/**
	 * @return the selectedProduct
	 */
	public AccountDTO getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(AccountDTO selectedProduct) {
		this.selectedProduct = selectedProduct;
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
	public void setSelectedLike(String selectedLike) {
		this.selectedLike = selectedLike;
	}

	/**
	 * @return the listPrb
	 */
	public List<String> getListPrb() {
		return listPrb;
	}

	/**
	 * @param listPrb the listPrb to set
	 */
	public void setListPrb(List<String> listPrb) {
		this.listPrb = listPrb;
	}

	public void onRowSelect(SelectEvent event) {
		System.out.println("LLego selected");
		System.out.println("Product Selected" + ((AccountDTO)event.getObject()).getProduct().getProductId());
		FacesMessage msg = new FacesMessage("Product Selected", ((AccountDTO)event.getObject()).getProduct()
				.getProductId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		System.out.println("LLego iunselected");
		FacesMessage msg = new FacesMessage("Product Unselected", ((AccountDTO)event.getObject()).getProduct()
				.getProductId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String goAccounts() {
		return "accounts";
	}

	public void selectedValue() {
		System.out.println("Selected Like" + getSelectedLike());
	}

	public void testValidate() {
		System.out.println("Test validate" + getSelectedLike());
	}

	public void seleccionC(ValueChangeEvent event) {
		System.out.print("Nuevo dato: " + event.getNewValue() + ", Viejo dato: " + event.getOldValue());
	}
}
