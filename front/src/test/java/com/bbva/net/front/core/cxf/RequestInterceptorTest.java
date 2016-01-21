package com.bbva.net.front.core.cxf;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

import com.bbva.net.core.test.TestUtils;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

@PowerMockIgnore({ "com.bbva.net.front.core.cxf" })
public class RequestInterceptorTest extends AbstractBbvaControllerTest {

    private RequestInterceptor requestInterceptor;

    @Mock
    private MessageImpl message;

    @Before
    public void init() {
        super.setUp();
        this.requestInterceptor = new RequestInterceptor();

    }

    @Test
    public void checkHandleMessage_OK() throws Fault {

        final Map<String, List<String>> headers = new HashMap<String, List<String>>();
        final List<String> tsecList = new ArrayList<String>();
        tsecList.add("12dfsa312a3dsf2asd3fs2adf1asd3f2dsa=");
        headers.put(RequestInterceptor.TSecType.tsec.name(), tsecList);

        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);
        when(message.get(Message.RESPONSE_CODE)).thenReturn("");
        when(message.get(Message.RESPONSE_CODE).toString()).thenReturn("");
        requestInterceptor.handleMessage(message);

        Date date = new Date();
        date.setMinutes((date.getMinutes() - 15));
        when(httpSession.getAttribute("lastService")).thenReturn(date);
        requestInterceptor.handleMessage(message);

        date = new Date();
        date.setMinutes((date.getMinutes() + 15));
        when(httpSession.getAttribute("lastService")).thenReturn(date);
        requestInterceptor.handleMessage(message);

        verify(message, atLeastOnce()).get(Message.PROTOCOL_HEADERS);
        Assert.assertFalse(tsecList.isEmpty());

    }

    @SuppressWarnings("unchecked")
    @Test
    public void checkHandleMessage_ThrowException() throws Fault, SecurityException, IllegalArgumentException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(message.get(Message.PROTOCOL_HEADERS)).thenThrow(Fault.class);
        requestInterceptor.handleMessage(message);

        verify(message, atLeastOnce()).get(Message.PROTOCOL_HEADERS);
    }

    @Test
    public void checkCoverageEnums() {
        TestUtils.enumCodeCoverage(RequestInterceptor.TSecType.class);
    }
}
