package com.bbva.net.front.core.cxf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.i18n.UncheckedException;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.bbva.net.core.test.TestUtils;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class ResponseInterceptorTest extends AbstractBbvaControllerTest {

	private ResponseInterceptor responseInterceptor;

	@Mock
	private MessageImpl message;

	@Before
	public void init() {
		super.setUp();
		this.responseInterceptor = new ResponseInterceptor();
	}

	@Test
	public void checkHandleMessage_OK() {

		final Map<String, List<String>> headers = new HashMap<String, List<String>>();
		final List<String> tsecList = new ArrayList<String>();
		tsecList.add("12dfsa312a3dsf2asd3fs2adf1asd3f2dsa=");
		headers.put("tsec", tsecList);

		Mockito.when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);
		responseInterceptor.handleMessage(message);

		Mockito.verify(message, Mockito.atLeastOnce()).get(Message.PROTOCOL_HEADERS);
		Assert.assertFalse(tsecList.isEmpty());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkHandleMessage_ThrowException() {

		Mockito.when(message.get(Message.PROTOCOL_HEADERS)).thenThrow(UncheckedException.class);
		responseInterceptor.handleMessage(message);
		Mockito.verify(message, Mockito.atLeastOnce()).get(Message.PROTOCOL_HEADERS);

	}

	@Test
	public void checkCoverageEnums() {

		TestUtils.enumCodeCoverage(ResponseInterceptor.TSecType.class);
	}
}
