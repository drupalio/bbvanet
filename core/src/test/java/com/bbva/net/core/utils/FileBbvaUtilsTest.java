package com.bbva.net.core.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.core.Foo;
import com.bbva.net.core.test.TestUtils;

public class FileBbvaUtilsTest {

	private Foo foo;

	@Before
	public void setUp() {
		this.foo = new Foo(5L, 3, "Valor 1");
	}

	@Test
	public void checkToJsonString() {
		final String jsonString = FileBbvaUtils.getJsonString(this.foo);
		Assert.assertNotNull(jsonString);
	}

	@Test
	public void checkMarshal_OK() {

		final File jsonFile = new File("src/test/resources/foo.xml");
		FileBbvaUtils.marshall(this.foo, jsonFile);
		Assert.assertNotNull(jsonFile);

	}

	@Test
	public void checkMarshal_Not_OK() {

		final File xmlFile = new File(StringUtils.EMPTY);
		FileBbvaUtils.marshall(this.foo, xmlFile);
		Assert.assertNull(FileBbvaUtils.unmarshall(Foo.class, xmlFile));

	}

	@Test(expected = IllegalArgumentException.class)
	public void checkMarshal_NOT_OK() {
		FileBbvaUtils.marshall(this.foo, null);
	}

	@Test
	public void checkToJsonFile_OK() {

		final File jsonFile = new File("src/test/resources/foo.json");
		FileBbvaUtils.toJsonFile(this.foo, jsonFile);
		Assert.assertNotNull(jsonFile);

	}

	@Test
	public void checkToJsonFile_NOt_OK() {

		final File jsonFile = new File(StringUtils.EMPTY);
		FileBbvaUtils.toJsonFile(this.foo, jsonFile);
		Assert.assertNull(FileBbvaUtils.fromJson(Foo.class, jsonFile));

	}

	@Test
	public void checkFromJsonFile_OK() {

		final File jsonFile = new File("src/test/resources/foo.json");
		Assert.assertNotNull(FileBbvaUtils.fromJson(Foo.class, jsonFile));

	}

	@Test(expected = NullPointerException.class)
	public void checkToJson_NOT_OK() {
		FileBbvaUtils.toJsonFile(this.foo, null);
	}

	@Test
	public void checkUnMarshal_OK() throws IOException {

		final File xmlFile = new File("src/test/resources/foo.xml");

		FileBbvaUtils.marshall(this.foo, xmlFile);
		Assert.assertNotNull(FileBbvaUtils.unmarshall(Foo.class, xmlFile));

	}

	@Test
	public void checkClass() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {

		TestUtils.utilClassCodeCoverage(FileBbvaUtils.class);
	}

}
