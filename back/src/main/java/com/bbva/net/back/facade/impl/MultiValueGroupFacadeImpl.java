/**
 * 
 */
package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.dao.MultiValueGroupDAO;
import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;

/**
 * @author User
 *
 */
@Facade(value = "multiValueGroupFacade")
public class MultiValueGroupFacadeImpl extends AbstractBbvaFacade implements
		MultiValueGroupFacade {

	private static final long serialVersionUID = -3576143862712353581L;
	@Resource(name = "multiValueGroupDao")
	private transient MultiValueGroupDAO multiValueDao;

	@Override
	public List<MultiValueGroup> getMultiValueTypes(final Integer typeId) {
		final List<MultiValueGroup> multiValueList;
		if (typeId == null) {
			multiValueList = new ArrayList<MultiValueGroup>();
		} else {
			multiValueList = multiValueDao.getTypes(typeId);
		}

		return multiValueList;
	}
}
