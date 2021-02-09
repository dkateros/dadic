package gr.dkateros.dadic.demo;

import java.util.Map;

import gr.dkateros.dadic.impl.calc.AbstractCalculation;

public class DriverRatingCalculation extends AbstractCalculation {

	public DriverRatingCalculation() {
		super("driverRating", 0, null);
	}

	@Override
	public Object perform(Map<String, Object> context) {
		Person person = (Person) context.get("person");
		return new DriverRatingProvider().ratingOf(person);
	}
	
}
