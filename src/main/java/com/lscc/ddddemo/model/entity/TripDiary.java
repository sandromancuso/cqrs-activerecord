package com.lscc.ddddemo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Trip diary entity. 
 *
 * @author sandro.mancuso
 * Nov 23, 2010
 */
@Entity
@Table(name="tripdiary")
@EqualsAndHashCode(callSuper=false)
@Configurable
public @Data class TripDiary extends BaseEntity {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;

}
