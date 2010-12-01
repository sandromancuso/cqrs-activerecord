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

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lscc.ddddemo.model.entity.TripDiary;
import com.lscc.ddddemo.model.service.TripDiaryServiceImpl;

/**
 * Test trip diary creation. 
 *
 * @author sandro.mancuso
 * Nov 24, 2010
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"file:src/test/resources/applicationContext-test.xml",
				"file:src/main/resources/applicationContext-services.xml"				
		})
@TransactionConfiguration(transactionManager = "myTransactionManager", defaultRollback = true)
@Transactional
public class TripDiaryCreationIntegrationTest {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TripDiaryServiceImpl tripDiaryService;	
	
	@Test
	public void testTripDiarySelfCreation() {
		assertThereAreNoDiariesNamed("Test");
		
		TripDiary diary = new TripDiary();
		diary.setName("Test");
		diary.save();
		
		assertThereIsASingleDiaryCalled("Test");
	}
	
	@Test
	public void testTripDiaryCreationViaService() {
		assertThereAreNoDiariesNamed("Test");
		this.tripDiaryService.createNewDiary("Test");
		assertThereIsASingleDiaryCalled("Test");
	}
	
	private void assertThereAreNoDiariesNamed(String diaryName) {
		assertTrue(diariesCalled(diaryName).isEmpty());
	}
	
	private void assertThereIsASingleDiaryCalled(String diaryName) {
		assertEquals(1, diariesCalled(diaryName).size());
	}
	
	@SuppressWarnings("unchecked")
	private List<TripDiary> diariesCalled(String diaryName) {
		Query q = em.createQuery("Select td from TripDiary td where td.name = 'Test'");
		return q.getResultList();
	}
	
}
