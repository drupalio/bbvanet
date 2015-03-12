package com.bbva.net.front.core.cxf;

import java.io.Serializable;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;

/**
 * @author Entelgy
 */
public interface BbvaInterceptor extends Serializable {

	void handleMessage(Message outMessage) throws Fault;

}
