package com.lscc.entity.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.lscc.ddddemo.model.entity.TripDiary;

/**
 * Test case for the trip attributes.
 * 
 * @author sandro.mancuso
 */
public class TripAttributeTest {

	@Test
	public void checkIfGettersAndSettersExistForBasicAttributes() {
		TripDiary trip = new TripDiary();
		
		trip.setName("Summer in Spain");
		assertEquals("Summer in Spain", trip.getName());
		
		trip.setId(123);
		assertEquals(123, trip.getId());
	}
	
}
