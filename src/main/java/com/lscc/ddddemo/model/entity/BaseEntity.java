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

package com.lscc.ddddemo.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Defines all the basic features of an entity.
 *
 * @author sandro.mancuso
 * Nov 24, 2010
 */
@Configurable
public abstract class BaseEntity {

    @PersistenceContext
    protected EntityManager em;

    public abstract long getId();
    
	public void save() {
		if (getId() == 0) {
			this.em.persist(this);
		} else {
			this.em.merge(this);
		}
		this.em.flush();
	}	
	
	public void delete() {
		this.em.remove(this);
		this.em.flush();
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
