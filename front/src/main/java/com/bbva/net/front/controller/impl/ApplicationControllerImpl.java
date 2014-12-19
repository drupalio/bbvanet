package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.controller.ApplicationController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.ui.menu.ItemMenu;

@Controller(value = "applicationController")
@Scope(value = "globalSession")
public class ApplicationControllerImpl extends AbstractBbvaController implements ApplicationController {

	private static final long serialVersionUID = -7098769540244437001L;

	// private GraphicUI graphicUI;
	private Integer LISTA_QUIEROS = 1;

	private ItemMenu menuActive = ItemMenu.PG;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	private List<MultiValueGroup> likes;

	@PostConstruct
	public void init() {
		this.likes = this.getListMultiValueLikes();
	}

	/**
	 * @return the listMultiValueLikes
	 */
	@Override
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LISTA_QUIEROS);
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

	public List<MultiValueGroup> getLikes() {
		return likes;
	}

	@Override
	public void setMenuActive(ItemMenu menuActive) {
		this.menuActive = menuActive;
	}

	@Override
	public String getMenuActive() {
		return this.menuActive.name();
	}
}
