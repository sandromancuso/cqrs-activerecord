/**
   Copyright 2010 Sandro Mancuso

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.lscc.entity.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lscc.ddddemo.model.entity.Traveller;

/**
 * Base class for the traveller integration tests.
 *
 * @author sandro.mancuso
 * Nov 30, 2010
 */
public class BaseTravellerIntegration {

	@PersistenceContext
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	protected List<Traveller> travellers(String name, String country) {
		Query q = em.createQuery("Select t from Traveller t " +
									"where " +
										"t.name = '" + name + "' and " +
										"t.country = '" + country + "'");
		return q.getResultList();
	}
	
	protected <T> T from(T value) {
		return value;
	}
	
	protected <T> T named(T value) {
		return value;
	}
 	
	protected void assertThereAreNoTravellers(String name, String country) {
		assertTrue(travellers(name, country).isEmpty());
	}
	
	protected void assertThereIsASingleTraveller(String name, String country) {
		assertEquals(1, travellers(name, country).size());
	}
	
}
