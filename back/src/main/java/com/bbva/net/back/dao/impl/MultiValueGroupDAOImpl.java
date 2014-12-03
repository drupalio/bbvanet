package com.bbva.net.back.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bbva.net.back.core.pattern.AbstractBbvaDao;
import com.bbva.net.back.dao.MultiValueGroupDAO;
import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 *
 */
@Repository(value = "multiValueGroupDao")
public class MultiValueGroupDAOImpl extends AbstractBbvaDao<MultiValueGroup>
		implements MultiValueGroupDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<MultiValueGroup> getTypes(Integer typeId) throws Exception {
		
		 List<MultiValueGroup> listMultiValueGroup = new ArrayList<MultiValueGroup>();
		try {
			if (typeId != null) {

				Criteria criteria = getSession().createCriteria(MultiValueGroup.class).add(Restrictions.eq("TYPE_ID", typeId));
				listMultiValueGroup = criteria.list();				
			}
			
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		return listMultiValueGroup;		
	}

}