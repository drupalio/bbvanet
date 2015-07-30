package com.bbva.net.back.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bbva.net.back.core.pattern.dao.AbstractBbvaDao;
import com.bbva.net.back.dao.MultiValueGroupDAO;
import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 *
 */
@Repository(value = "multiValueGroupDao")
public class MultiValueGroupDAOImpl extends AbstractBbvaDao<MultiValueGroup>
		implements MultiValueGroupDAO {

	private static final String TYPE_ID = "typeId";

	@Override
	@SuppressWarnings("unchecked")
	public List<MultiValueGroup> getTypes(final Integer typeId) {

		if (typeId == null) {

			return new ArrayList<MultiValueGroup>();
		}

		final Criteria criteria = getSession().createCriteria(
				MultiValueGroup.class).add(Restrictions.eq(TYPE_ID, typeId));

		return criteria.list();

	}

}