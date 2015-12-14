package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.model.checkbook.CheckbookDto;

public class EnumCheckBookStatusPredicateTest {

	private CheckBookStatusPredicate checkBookStatusPredicated;

	private CheckbookDto checkBookDto;

	@Before
	public void init() {
		this.checkBookStatusPredicated = new CheckBookStatusPredicate();
		this.checkBookDto = new CheckbookDto();
		this.checkBookDto.setId("1234567");
	}

	@Test
	public void checkEval() {

		// State 1
		this.checkBookDto.setActualState("1");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State A
		this.checkBookDto.setActualState("A");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State I
		this.checkBookDto.setActualState("I");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State O
		this.checkBookDto.setActualState("O");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State E
		this.checkBookDto.setActualState("E");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State B
		this.checkBookDto.setActualState("B");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State N
		this.checkBookDto.setActualState("N");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State C
		this.checkBookDto.setActualState("C");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
		// State 2
		this.checkBookDto.setActualState("2");
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));
	}

	@Test
	public void checkStatusPredicatedFalse() {
		// Check Null
		assertFalse(this.checkBookStatusPredicated.eval(null));

		// Id Null
		assertFalse(this.checkBookStatusPredicated.eval(new CheckbookDto()));

		// Status Empty
		this.checkBookDto.setActualState("");
		assertFalse(this.checkBookStatusPredicated.eval(this.checkBookDto));

		// StatusNull
		this.checkBookDto.setActualState(null);
		assertTrue(this.checkBookStatusPredicated.eval(this.checkBookDto));

	}
}
