package com.bbva.net.back.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Entelgy
 *
 */
public final class CollectionBbvaUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollectionBbvaUtils.class);

	
	public static <T extends Serializable> BigDecimal calculateTotal(
			List<T> list, final String expressionLenguage){
		
		double totalValue = 0d;
		
		// list.forEach((player) -> System.out.print(player.toString()));
		
		

//		new VisitorCommand<T>(list) {
//
//			@Override
//			protected void exceute(T object) {
//				
//				try {
//					totalValue = totalValue + ((Number) PropertyUtils.getProperty(object, expressionLenguage)).doubleValue();
//				} catch (final Exception exception) {
//					LOG.debug(exception.getMessage());
//				}	
//			}
//		}; 
			
		return BigDecimal.valueOf(totalValue);
	}
	
	
}
