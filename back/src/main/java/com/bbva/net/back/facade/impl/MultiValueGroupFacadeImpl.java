/**
 * 
 */
package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.dao.MultiCoordinateDAO;
import com.bbva.net.back.dao.MultiValueGroupDAO;
import com.bbva.net.back.entity.MultiCoordinates;
import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;

/**
 * @author User
 */
@Facade(value = "multiValueGroupFacade")
public class MultiValueGroupFacadeImpl extends AbstractBbvaFacade implements MultiValueGroupFacade {

	private static final long serialVersionUID = -3576143862712353581L;

	@Resource(name = "multiValueGroupDao")
	private transient MultiValueGroupDAO multiValueDao;

	@Resource(name = "multiCoordinateDao")
	private transient MultiCoordinateDAO multiCoordinate;

	@Override
	public List<MultiValueGroup> getMultiValueTypes(final Integer typeId) {
		try {
			return multiValueDao.getTypes(typeId);
		} catch (Exception ex) {
			return new ArrayList<MultiValueGroup>();
		}

	}

	@Override
	public List<MultiCoordinates> getMultiCoordinate(String officeId) {
		try {
			return multiCoordinate.getTypes(officeId);
		} catch (Exception ex) {
			return new ArrayList<MultiCoordinates>();
		}
	}

}
