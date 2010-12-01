package com.lscc.ddddemo.model.entity.builder;

import com.lscc.ddddemo.model.entity.Traveller;

public class TravellerBuilder {
	
	private Traveller traveller;
	
	private TravellerBuilder() {
		this.traveller = new Traveller();
	}
 	
	public static TravellerBuilder aTraveller() {
		return new TravellerBuilder();
	}
	
	public TravellerBuilder named(String name) {
		this.traveller.setName(name);
		return this;
	}
	
	public TravellerBuilder from(String country) {
		this.traveller.setCountry(country);
		return this;
	}
	
	public Traveller build() {
		return this.traveller;
	}

}
