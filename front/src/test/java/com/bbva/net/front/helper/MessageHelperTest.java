package com.bbva.net.front.helper;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.net.core.test.TestUtils;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class MessageHelperTest extends AbstractBbvaControllerTest {

	private MessagesHelper messagesHelper;

	@Before
	public void init() {
		super.setUp();
		this.messagesHelper = MessagesHelper.INSTANCE;
	}

	@Test
	public void checkGetMessages_OK() {
		assertNotNull(this.messagesHelper.getMessages());
	}

	@Test
	public void checkGetString_OK() {
		assertNotNull(this.messagesHelper.getString("Any String"));
	}

	@Test
	public void checkGetStringI18n_OK() {
		assertNotNull(this.messagesHelper.getStringI18("Any String"));
	}

	@Test
	public void checkGetMessagesI18n_OK() {
		assertNotNull(this.messagesHelper.getMessagesI18());
	}

	@Test
	public void checkMonthPrefix_OK() {
		assertNotNull(this.messagesHelper.getMonthPrefix(EnumMonth.APRIL));
	}

	@Test
	public void checkMonthPrefix_WithNull() {
		assertNotNull(this.messagesHelper.getMonthPrefix(null));
	}

	@Test
	public void checkGetCategoryPrefix_OK() {
		assertNotNull(this.messagesHelper.getCategoryPrefix("Any Category"));
	}

	@Test
	public void checkGetFavOperationsPrefix_OK() {
		assertNotNull(this.messagesHelper.getFavOperationsPrefix("Any Fav Operations"));
	}

	@Test
	public void checkEnumCoverage() {
		TestUtils.enumCodeCoverage(MessagesHelper.class);
	}
}
