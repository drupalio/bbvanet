/**
 * 
 */
package com.bbva.net.back.facade.impl.integration;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;


/**
 * @author User
 *
 */
@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckBooksFacadeIT {
	
	@Resource(name = "checkBookFacade")
	private CheckBookFacade checkBookFacade;
	
	
	@Test
	public void checkGetCheckByDateAndUserOK() {
		DateRangeDto dateRange = new DateFilterServiceImpl().getPeriodFilter(EnumPeriodType.TODAY);	
		final List<CheckDto> listCheckDto=this.checkBookFacade.getCheckByStatusOrDate("12345678", dateRange, null, null, null);		
		Assert.assertNotNull(listCheckDto);	
		Assert.assertEquals("12834063921", listCheckDto.get(0).getId());
	}
	
	
	@Test
	public void checkGetCheckByStatusAndUserNOK() {	
		final List<CheckDto> listCheckDto=this.checkBookFacade.getCheckByStatusOrDate("12345678", null, "CUALQUIERA", null, null);
		Assert.assertNotNull(listCheckDto);			
	}
	
	@Test
	public void checkGetCheckByStatusAndUserOK() {			
		final List<CheckDto> listCheckDto=this.checkBookFacade.getCheckByStatusOrDate("123", null, "HABILITADO", null, null);
		Assert.assertNotNull(listCheckDto);	
		Assert.assertEquals("HABILITADO", listCheckDto.get(0).getStatus());
	}

}
