package com.bbva.net.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.google.gson.Gson;

/**
 * @author Entelgy Gson guide: https://sites.google.com/site/gson/gson-user-guide
 */
public final class FileBbvaUtils {

	private FileBbvaUtils() {
	}

	protected static final Log LOGGER = I18nLogFactory.getLog(FileBbvaUtils.class);

	/**
	 * @param object
	 * @param file
	 */
	public static <T extends Serializable> void marshall(final T object, final File file) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(object, file);
			jaxbMarshaller.marshal(object, System.out);

		} catch (final JAXBException exception) {
			LOGGER.info(exception.getMessage());
		}
	}

	/**
	 * @param clazz
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T unmarshall(final Class<T> clazz, final File file) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T)jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException exception) {
			LOGGER.info(exception.getMessage());
		}

		return null;
	}

	/**
	 * @param object
	 * @param file
	 */
	public static <T extends Serializable> void toJsonFile(final T object, final File file) {

		final Gson gson = new Gson();
		final String jsonString = gson.toJson(object);

		try {
			FileUtils.writeStringToFile(file, jsonString);
		} catch (final IOException exception) {
			LOGGER.info(exception.getMessage());
		}

	}

	/**
	 * @param object
	 * @return
	 */
	public static <T extends Serializable> String getJsonString(final T object) {

		final Gson gson = new Gson();
		return gson.toJson(object);
	}

	/**
	 * @param clazz
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static <T extends Serializable> T fromJson(final Class<T> clazz, final File file) {

		final Gson gson = new Gson();

		try {
			final String json = FileUtils.readFileToString(file);
			return gson.fromJson(json, clazz);
		} catch (final IOException exception) {
			LOGGER.info(exception.getMessage());
			return null;
		}

	}
}
