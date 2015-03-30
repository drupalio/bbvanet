package com.bbva.net.webservices.subjets;

import javax.ws.rs.ServiceUnavailableException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.subjects.impl.SubjetsServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

public class SubjectsServiceImplTest extends AbstractBbvaRestClientTest {

	private SubjetsServiceImpl subjetsServiceImpl;

	@Before
	public void init() {
		super.setUp();
		// Get GlobalPositionServiceImpl instance
		subjetsServiceImpl = (SubjetsServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new SubjetsServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@Test
	public void checkUpdateSubject() {

		final UpdateSubjectIn updateSubjectIn = new UpdateSubjectIn();

		Mockito.when(webClient.put(updateSubjectIn)).thenReturn(response);
		Mockito.when(webClient.getResponse()).thenReturn(response);
		Mockito.when(response.getStatus()).thenReturn(200);
		this.subjetsServiceImpl.updateSubject("123", updateSubjectIn);
		Mockito.when(response.getStatus()).thenReturn(404);
		this.subjetsServiceImpl.updateSubject("123", updateSubjectIn);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).put(updateSubjectIn);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkGetUpdateSubjectThrowsException() {
		final UpdateSubjectIn updateSubjectIn = new UpdateSubjectIn();
		Mockito.when(webClient.put(updateSubjectIn)).thenThrow(ServiceUnavailableException.class);
		final UpdateAccountOut updateAccountOut = this.subjetsServiceImpl.updateSubject("123", updateSubjectIn);
		Assert.assertTrue(updateAccountOut.getFolio() == null);
	}
}
