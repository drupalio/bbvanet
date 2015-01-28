/**
 * 
 */
package com.bbva.net.back.facade.impl.integration;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.net.back.facade.CheckBookFacade;


/**
 * @author User
 *
 */
@Profile("integration")
@ContextConfiguration(locations = "classpath:spring-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckBooksFacadeIT {
	
	@Resource(name = "checkBookFacade")
	private CheckBookFacade chckBookFacade;

}
