package com.bbva.net.back.utils.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public abstract class Validator implements IValidator {

	protected List<Exception> exceptions;

	protected Validator() {
		exceptions = new ArrayList<Exception>();
	}

	public boolean hasException() {
		return !exceptions.isEmpty();
	}

	public List<Exception> getAllExceptions() {
		return exceptions;
	}

	public void throwFirstExceptionIfAny() throws Exception {
		if (!exceptions.isEmpty()) {
			throw exceptions.get(0);
		}
	}

	@Override
	public IValidator validate() {
		try {
			throwFirstExceptionIfAny();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return this;
	}
}
