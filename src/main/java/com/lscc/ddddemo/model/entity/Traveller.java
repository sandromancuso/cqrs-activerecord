package com.lscc.ddddemo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Table(name="traveller")
@EqualsAndHashCode(callSuper=false)
@Configurable
public @Data class Traveller extends BaseEntity {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String country;
	
}
