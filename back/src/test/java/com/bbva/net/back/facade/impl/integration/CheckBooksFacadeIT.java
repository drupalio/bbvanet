/**
 * 
 */
package com.bbva.net.back.facade.impl.integration;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;

/**
 * @author User
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
		final List<CheckDto> listCheckDto = this.checkBookFacade.getCheckByStatusOrDate("00130693000100000010",
				dateRange, null, 1, 10);
		Assert.assertNotNull(listCheckDto);
	}

	@Test
	public void checkGetCheckByStatusAndUserOK() {
		final List<CheckDto> listCheckDto = this.checkBookFacade.getCheckByStatusOrDate("00130693000100000010", null,
				"HABILITADO", 1, 10);
		Assert.assertNotNull(listCheckDto); // Assert.assertEquals("HABILITADO", listCheckDto.get(0).getStatus());
	} 

	@Test(expected = BadRequestException.class)//falla no valida filter date ni status
	public void checkGetCheckByStatusAndUserNotOK() {
		try {
			final List<CheckDto> listCheckDto = this.checkBookFacade.getCheckByStatusOrDate("00130693000100000010",
					null, null, null, 10);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCheckByStatusAndUserWithoutPagination() {
		try {
			final List<CheckDto> listCheckDto = this.checkBookFacade.getCheckByStatusOrDate("00130693000100000010",
					null, null, null, 10);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}

	@Test(expected = BadRequestException.class)
	public void checkGetCheckByStatusAndUserWithoutPageSize() {
		try {
			final List<CheckDto> listCheckDto = this.checkBookFacade.getCheckByStatusOrDate("00130693000100000010",
					null, null, 1, null);
		} catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		}
	}


	  @Test //Todo ok Daniel 
	  public void getCheckBookByAccountIdOk() { 
		  final CheckbookDto checkBook =
	  this.checkBookFacade.getCheckBookByAccountId("00130693000100000010", "00130693000100000010");
	  Assert.assertNotNull(checkBook); 
	  }
	
		
	@Test(expected = BadRequestException.class)//Todo ok without checkBookId 
	  public void getCheckBookByAccountIdNotOk() { 
		try {
			  final CheckbookDto checkBook =
					  this.checkBookFacade.getCheckBookByAccountId("00130693000100000010",null ); 

		}catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		} 
	  }
	
	//Todo ok without checkBookId    
	@Test(expected = BadRequestException.class)
	    public void getCheckBookByAccountIdNotAccountId(){ 
		try {
			  final CheckbookDto checkBook =
					  this.checkBookFacade.getCheckBookByAccountId(null,"00130693000100000010" ); 

		}catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		} 
	  }
	  
	  @Test //Todo ok Tafur 
	  public void getCheckByAccountIdOk() { 
		  final CheckDto checkDto =
	  this.checkBookFacade.getCheckById("12345678909876543212", "123456789"); 
		  Assert.assertNotNull(checkDto); 
	}
	  
	  @Test(expected = BadRequestException.class)
	    public void getCheckByAccountIdNotAccountId(){ 
		try {
			  final CheckDto checkDto =
					  this.checkBookFacade.getCheckById("12345678909876543212", null); 

		}catch (final BadRequestException notFoundException) {
			Assert.assertEquals(notFoundException.getMessage(), "HTTP 400 Bad Request");
			throw notFoundException;
		} 
	}
}