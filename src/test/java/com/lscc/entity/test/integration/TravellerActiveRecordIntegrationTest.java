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

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lscc.ddddemo.model.entity.Traveller;
import static com.lscc.ddddemo.model.entity.builder.TravellerBuilder.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"file:src/test/resources/applicationContext-test.xml",
				"file:src/main/resources/applicationContext-services.xml"				
		})
@TransactionConfiguration(transactionManager = "myTransactionManager", defaultRollback = true)
@Transactional
public class TravellerActiveRecordIntegrationTest extends BaseTravellerIntegration {
	
	@Test public void 
	testTravellerSelfCreation() {
		assertThereAreNoTravellers(named("John"), from("England"));
		
		Traveller traveller = aTraveller().named("John").from("England").build();
		traveller.save();
		
		assertThereIsASingleTraveller(named("John"), from("England"));
	}
	
	@Test public void
	testTravellerEdition() {
		Traveller traveller = aTraveller().named("John").from("England").build();
		traveller.save();
		
		traveller.setName("Sandro");
		traveller.setCountry("Brazil");
		traveller.save();
		
		assertThereAreNoTravellers(named("John"), from("England"));
		assertThereIsASingleTraveller(named("Sandro"), from("Brazil"));		
	}
	
	@Test public void 
	testDeleteTraveller() {
		Traveller traveller = aTraveller().named("John").from("England").build();
		traveller.save();

		traveller.delete();
		assertThereAreNoTravellers(named("John"), from("England"));
	}
	
}
