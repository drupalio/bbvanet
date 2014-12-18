package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author Entelgy
 */
public interface ApplicationController {

	/**
	 * @return
	 */
	List<MultiValueGroup> getListMultiValueLikes();

}
