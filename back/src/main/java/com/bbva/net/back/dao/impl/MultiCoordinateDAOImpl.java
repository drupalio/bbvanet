package com.bbva.net.back.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bbva.net.back.core.pattern.dao.AbstractBbvaDao;
import com.bbva.net.back.dao.MultiCoordinateDAO;
import com.bbva.net.back.entity.MultiCoordinates;

/**
 * @author User
 */
@Repository(value = "multiCoordinateDao")
public class MultiCoordinateDAOImpl extends AbstractBbvaDao<MultiCoordinates> implements MultiCoordinateDAO {

	private static final String OFFICE = "office";

	@SuppressWarnings("unchecked")
	@Override
	public List<MultiCoordinates> getTypes(final String officeId) {
		if (officeId == null) {

			return new ArrayList<MultiCoordinates>();
		}

		final Criteria criteria = getSession().createCriteria(MultiCoordinates.class).add(
				Restrictions.eq(OFFICE, officeId));

		return criteria.list();
	}
}