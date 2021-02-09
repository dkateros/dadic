package gr.dkateros.dadic.impl.calc;

import java.util.Map;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.DataProvider;

/**
 * A {@link Calculation} that always resolves to a constant value.
 * 
 * @author dkateros
 */
public class Constant extends AbstractCalculation {
	
	public Constant(String id, int priority, DataProvider dataProvider) {
		super(id, priority, dataProvider);
	}

	@Override
	public Object perform(Map<String, Object> context) {
		return dataProvider().data(id());
	}

}
