package com.bbva.net.back.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bbva.net.back.core.pattern.AbstractBbvaDao;
import com.bbva.net.back.dao.PruebaDao;
import com.bbva.net.back.entity.Prueba;

@Transactional
@Repository(value="pruebaDao")
public class PruebaDaoImpl 
				extends AbstractBbvaDao<Prueba> implements PruebaDao {
}
