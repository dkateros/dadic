package gr.dkateros.dadic.demo;

import java.math.BigDecimal;
import java.util.Map;

import gr.dkateros.dadic.impl.calc.AbstractCalculation;

public class CommissionPercentageCalculation extends AbstractCalculation {

	public CommissionPercentageCalculation() {
		super("vehicle.commissionPercentage", 10, null);
	}

	@Override
	public Object perform(Map<String, Object> context) {
		DriverRating driverRating = (DriverRating) context.get("driverRating");
		switch(driverRating) {
		case OFFENSIVE:
			return BigDecimal.valueOf(0.1);
		case DEFENSIVE:
			return BigDecimal.valueOf(0.2);
		case MIXED:
			return BigDecimal.valueOf(0.15);
		default:
			return BigDecimal.valueOf(0.1);
			
		}
	}

}
