package com.bbva.net.core.test;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.core.collection.BbvaPredicate;
import com.bbva.net.core.pattern.VisitorCommand;
import com.bbva.net.core.reflection.BeanBbvaUtils;
import com.bbva.net.core.reflection.ReflectionBbvaUtils;

/**
 * @author Entelgy
 * @param <T>
 */
public abstract class AbstractBbvaDTOTest<T extends Serializable> {

	private T dto;

	private List<Method> setterMethodsList;

	private List<Method> getterMethodsList;

	/**
	 * @return
	 */
	protected abstract T getInstance();

	@SuppressWarnings("unchecked")
	@Before
	public void init() {

		this.dto = getInstance();

		final Method[] methods = this.dto.getClass().getMethods();
		final List<Method> methodsList = new ArrayList<Method>();
		Collections.addAll(methodsList, methods);

		this.setterMethodsList = (List<Method>)CollectionUtils.select(methodsList, new SetterPredicate());
		this.getterMethodsList = (List<Method>)CollectionUtils.select(methodsList, new GetterPredicate());
	}

	/**
	 * Invoke every Setter Method
	 */
	@Test
	public void checkSettersMethods() {
		this.visitSetterMethods();
	}

	/**
	 * Invoke every Getter Method
	 */
	@Test
	public void checkGettersMethods() {
		this.visitGetterMethods();
	}

	/**
	 * Invoke ToString Method
	 */
	@Test
	public void checkToStringMethod() {
		System.out.print(this.dto.toString());
	}

	/**
	 * Invoke HasCode Method
	 */
	@Test
	public void checkHasCodeMethod() {
		System.out.print(this.dto.hashCode());
	}

	/**
	 * Invoke Equals Method
	 */
	@Test
	public void checkEqualsMethod() {

		this.visitSetterMethods();
		Assert.assertTrue(this.dto.equals(this.dto));
		Assert.assertFalse(this.dto.equals(null));
		Assert.assertFalse(this.dto.equals(1L));
		this.dto.equals(getInstance());
	}

	/*********************************** PRIVATE METHODS *******************************/

	/**
	 * Invoke every setter Method
	 */
	private void visitSetterMethods() {

		new VisitorCommand<Method>(setterMethodsList) {

			@Override
			protected void exceute(final Method method) {

				final Class<?> parameterClass = method.getParameterTypes()[0];
				final Object value = BeanBbvaUtils.instantiateClass(parameterClass);
				ReflectionBbvaUtils.invokeMethod(method, dto, value);
			}
		};
	}

	/**
	 * Invoke every getter Method
	 */
	private void visitGetterMethods() {

		new VisitorCommand<Method>(getterMethodsList) {

			@Override
			protected void exceute(final Method method) {
				ReflectionBbvaUtils.invokeMethod(method, dto);
			}
		};
	}

	/*********************************** INNER CLASSES *******************************/

	/**
	 * @author Entelgy
	 */
	private static class SetterPredicate extends BbvaPredicate<Method> {

		@Override
		protected boolean eval(final Method method) {
			return method.getName().startsWith("set");
		}
	}

	/**
	 * @author Entelgy
	 */
	private static class GetterPredicate extends BbvaPredicate<Method> {

		@Override
		protected boolean eval(final Method method) {
			return method.getName().startsWith("get");
		}
	}

}
