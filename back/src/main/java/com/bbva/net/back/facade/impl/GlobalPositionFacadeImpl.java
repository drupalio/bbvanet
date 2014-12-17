package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.PersonalAccountDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.core.collection.BbvaPredicate;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl extends AbstractBbvaFacade implements GlobalPositionFacade {

	private static final long serialVersionUID = -8133045188591147282L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public GlobalProducts getGlobalProductsByUser(String user) throws RestClientException {		 
		return this.globalPositionService.get(user);
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;

	}

	@Override
	public GlobalProducts getGlobalProductsByUserVisible(String defaultUser, boolean b) {
		
		final GlobalProducts globalProducts = globalPositionService.get(defaultUser);
		
		PersonalAccountDTO acc=new PersonalAccountDTO();
		acc.setAlias("Cuenta 1");
		acc.setProductID("1234");
		List pr= new ArrayList();
		pr.add(acc);
		acc=new PersonalAccountDTO();
		acc.setAlias("Cuenta 2");
		acc.setProductID("12345");
		pr.add(acc);
		acc=new PersonalAccountDTO();
		acc.setAlias("Cuenta 3");
		acc.setProductID("19");
		pr.add(acc);
		acc=new PersonalAccountDTO();
		acc.setAlias("Cuenta 4");
		acc.setProductID("12346");
		pr.add(acc);
		
		HiddenProductPredicate predicate = new HiddenProductPredicate();
		List aList = (List) CollectionUtils.select(pr, predicate);
		System.out.println(" tamaño de sublista despues del predicado "+aList.size());
		acc=(PersonalAccountDTO) aList.get(0);
		System.out.println(acc.getAlias()+" tamaño de sublista despues del predicado "+aList.size());
		
		 //List aList = (List) CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(), predicate);
		 //Account product=(Account) aList.get(0);
		 //System.out.println(product.getProduct().getAlias()+" tamaño de sublista despues del predicado "+aList.size());
		 
		/*HiddenProductPredicate<ProductDTO> predicate = new HiddenProductPredicate<ProductDTO>();
		 *List aList = (List) CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(), predicate);
		 *
		 * globalProducts.setAccounts((List) CollectionUtils.select(globalPositionService.get(defaultUser).getAccounts(), predicate));
		 * globalProducts.setCreditCards((List) CollectionUtils.select(globalPositionService.get(defaultUser).getCreditCards(), predicate));
		 * globalProducts.setElectronicDeposits((List) CollectionUtils.select(globalPositionService.get(defaultUser).getElectronicDeposits(), predicate));
		 globalProducts.setFunds((List) CollectionUtils.select(globalPositionService.get(defaultUser).getFunds(), predicate));
		 globalProducts.setLeasings((List) CollectionUtils.select(globalPositionService.get(defaultUser).getLeasings(), predicate));
		 globalProducts.setRotatingAccounts((List) CollectionUtils.select(globalPositionService.get(defaultUser).getRotatingAccounts(), predicate));
		 */		
		return this.globalPositionService.get(defaultUser);
	}


}
