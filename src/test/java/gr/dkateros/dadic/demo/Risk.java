package gr.dkateros.dadic.demo;

import java.time.LocalDate;

import gr.dkateros.dadic.DictionaryElement;

public class Risk {
	
	public Risk(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	@DictionaryElement
	LocalDate from;
	
	@DictionaryElement
	LocalDate to;

}
