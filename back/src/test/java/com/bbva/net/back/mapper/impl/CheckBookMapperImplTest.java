package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;

public class CheckBookMapperImplTest {

	private CheckBookMapperImpl checkBookMapper;

	@Before
	public void init() {
		this.checkBookMapper = new CheckBookMapperImpl();
	}

	@Test
	public void checkMapCheckBookList() {
		List<Checkbook> checkList = new ArrayList<Checkbook>();
		List<CheckbookDto> checkBookList = this.checkBookMapper.mapCheckBookList(checkList);
		Assert.assertNotNull(checkBookList);
	}

	@Test
	public void checkMapCheck() {
		Check check = new Check();
		CheckDto checkDto = this.checkBookMapper.mapCheck(check);
		Assert.assertNotNull(checkDto);
	}

	@Test
	public void checkMapCheckList() {
		List<Check> checksList = new ArrayList<Check>();
		List<CheckDto> checkDtoList = this.checkBookMapper.mapCheckList(checksList);
		Assert.assertNotNull(checkDtoList);
	}
}
