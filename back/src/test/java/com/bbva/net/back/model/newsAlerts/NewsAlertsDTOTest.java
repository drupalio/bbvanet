package com.bbva.net.back.model.newsAlerts;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class NewsAlertsDTOTest extends AbstractBbvaDTOTest<NewsAlertsDto> {

	@Override
	protected NewsAlertsDto getInstance() {
		return new NewsAlertsDto();
	}

}