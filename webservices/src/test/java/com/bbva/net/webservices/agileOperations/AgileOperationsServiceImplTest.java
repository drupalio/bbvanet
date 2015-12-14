package com.bbva.net.webservices.agileOperations;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.webservices.agileOperations.impl.AgileOperationsServiceImpl;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.test.utils.AbstractBbvaRestClientTest;
import com.bbva.zic.agileoperations.v01.AgileOperation;
import com.bbva.zic.agileoperations.v01.ListAgileOperationsOut;

public class AgileOperationsServiceImplTest extends AbstractBbvaRestClientTest {
    
    private AgileOperationsServiceImpl agileServiceImpl;
    
    @Before
    public void init() {
        
        // Invoke to super to initialize Mocks
        super.setUp();
        
        // Get AgileOperationsServiceImpl instance
        agileServiceImpl = (AgileOperationsServiceImpl)this.restService;
        
    }
    
    @Override
    protected AbstractBbvaRestService getAbstractBbvaRestService() {
        return new AgileOperationsServiceImpl();
    }
    
    /************************************* TEST METHODS **********************************/
    
    @SuppressWarnings("unchecked")
    @Test
    public void checkGetAgileOperations() {
        Mockito.when(webClient.getCollection(AgileOperation.class)).thenReturn(Matchers.anyCollection());
        agileServiceImpl.listAgileOperations("");
        agileServiceImpl.listAgileOperations("$filter");
        Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(ListAgileOperationsOut.class);
    }
    
    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkGetAgileThrowException() {
        Mockito.when(webClient.get(ListAgileOperationsOut.class)).thenThrow(RestClientException.class);
        this.agileServiceImpl.listAgileOperations("");
    }
    
    @Test
    public void checkAddAgileOperation() {
        AgileOperation op = new AgileOperation();
        Mockito.when(webClient.getResponse()).thenReturn(response);
        Mockito.when(webClient.getResponse().getStatus()).thenReturn(0);
        Mockito.when(webClient.post(op)).thenReturn(response);
        agileServiceImpl.addAgileOperation(op);
    }
    
    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkAddAgileThrowException() {
        Mockito.when(webClient.post(null)).thenThrow(RestClientException.class);
        this.agileServiceImpl.addAgileOperation(null);
    }
    
    @Test
    public void checkValidateAgileOperation() {
        String fql = "asdf";
        Mockito.when(webClient.query("$filter", fql)).thenReturn(webClient);
        Mockito.when(webClient.getResponse()).thenReturn(response);
        Mockito.when(webClient.get(boolean.class)).thenReturn(true);
        agileServiceImpl.validateAgileOperation(fql);
    }
    
    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkValidateAgileThrowException() {
        Mockito.when(webClient.get()).thenThrow(RestClientException.class);
        this.agileServiceImpl.validateAgileOperation(null);
    }
    
    @Test
    public void checkDeleteAgileOperation() throws IOException {
        Mockito.when(webClient.delete()).thenReturn(response);
        Mockito.when(webClient.getResponse()).thenReturn(response);
        InputStream fakeStream = new ReaderInputStream(new StringReader(""));
        Mockito.when(response.getEntity()).thenReturn(fakeStream);
        agileServiceImpl.deleteAgileOperation("123", "456");
    }
    
    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkDeleteAgileThrowException() {
        Mockito.when(webClient.delete()).thenThrow(RestClientException.class);
        this.agileServiceImpl.deleteAgileOperation(null, null);
    }
    
    @Test
    public void checkModifyAgileOperation() {
        Mockito.when(webClient.put(new AgileOperation())).thenReturn(response);
        Mockito.when(webClient.getResponse()).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        agileServiceImpl.modifyAgileOperation(Matchers.anyString(), new AgileOperation());
    }
    
    @SuppressWarnings("unchecked")
    @Test(expected = RestClientException.class)
    public void checkModifyAgileThrowException() {
        Mockito.when(webClient.put(null)).thenThrow(RestClientException.class);
        this.agileServiceImpl.modifyAgileOperation(null, null);
    }
}
