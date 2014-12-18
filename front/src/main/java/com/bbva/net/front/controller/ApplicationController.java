package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.front.ui.menu.ItemMenu;

/**
 * @author Entelgy
 */
public interface ApplicationController {

	/**
	 * @return
	 */
	List<MultiValueGroup> getListMultiValueLikes();

	/**
	 * @param itemMenu
	 */
	void setMenuActive(ItemMenu itemMenu);

	/**
	 * @return
	 */
	String getMenuActive();

}
