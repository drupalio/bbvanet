package com.bbva.net.back.core.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.net.back.core.pattern.VisitorCommand;

/**
 * 
 * @author Entelgy
 *
 */
public class CollectionBbvaUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollectionBbvaUtils.class);

	
	public static <T extends Serializable> BigDecimal calculateTotal(
			List<T> list, final String expressionLenguage){
		
		final BigDecimal total = BigDecimal.ZERO;
		
		new VisitorCommand<T>(list) {

			@Override
			protected void exceute(T object) {
				
				try {
					//total = total+  BigDecimal.valueOf(((Number) PropertyUtils.getProperty(object, expressionLenguage)).doubleValue());
				} catch (final Exception exception) {
					LOG.debug(exception.getMessage());
				}
					
			}
		}; 
			
	
		return total;
	}
	
	
}
