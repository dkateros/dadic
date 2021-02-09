package gr.dkateros.dadic.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import gr.dkateros.dadic.DictionaryElement;

public class Vehicle {
	
	public Vehicle(String model, LocalDate manufactureDate) {
		this.model = model;
		this.manufactureDate = manufactureDate;
	}
	
	@DictionaryElement
	String model;
	
	@DictionaryElement
	LocalDate manufactureDate;
	
	@DictionaryElement
	BigDecimal premiums;
	
	@DictionaryElement
	BigDecimal commissionPercentage;

}
