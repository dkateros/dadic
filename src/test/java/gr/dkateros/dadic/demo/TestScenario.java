package gr.dkateros.dadic.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.Engine;
import gr.dkateros.dadic.impl.EngineImpl;
import gr.dkateros.dadic.util.Debug;

public class TestScenario {
	
	@Test
	public void testScenario() {
		List<Calculation> calculations = Arrays.asList(new CommissionPercentageCalculation(), new DriverRatingCalculation());
		
		Map<String, Object> seed = new HashMap<>();
		LocalDate now = LocalDate.now();
		Risk risk = new Risk(now, now.plusMonths(6));
		seed.put("risk", risk);
		Person person = new Person(now.plusYears(-25), "1");
		seed.put("person", person);
		Vehicle vehicle = new Vehicle("VW", now.plusYears(-10));
		seed.put("vehicle", vehicle);
		
		Engine engine = new EngineImpl();
		engine.plant(seed );
		engine.perform(calculations);
		Map<String, Object> results = engine.reap();
		
		Debug.printMap(results);
		
		assertEquals(DriverRating.OFFENSIVE, results.get("driverRating"));
		assertEquals(BigDecimal.valueOf(0.1), vehicle.commissionPercentage);
	}

}
