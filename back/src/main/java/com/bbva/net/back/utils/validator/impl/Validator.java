package com.bbva.net.back.utils.validator.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.net.back.utils.validator.IValidator;

/**
 * @author Entelgy Colombia.
 */
public abstract class Validator implements IValidator {

	protected List<BusinessServiceException> exceptions;

	protected Validator() {
		exceptions = new ArrayList<BusinessServiceException>();
	}

	public boolean hasException() {
		return !exceptions.isEmpty();
	}

	public List<BusinessServiceException> getAllExceptions() {
		return exceptions;
	}

	public void throwFirstExceptionIfAny() throws BusinessServiceException {
		if (!exceptions.isEmpty()) {
			throw exceptions.get(0);
		}
	}

	@Override
	public IValidator validate() {
		throwFirstExceptionIfAny();
		return this;
	}
}
