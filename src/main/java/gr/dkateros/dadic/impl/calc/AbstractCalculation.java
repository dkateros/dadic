package gr.dkateros.dadic.impl.calc;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.DataProvider;

public abstract class AbstractCalculation implements Calculation {

	final String id;
	final int priority;
	final DataProvider dataProvider;
	
	public AbstractCalculation(String id, int priority, DataProvider dataProvider) {
		this.id = id;
		this.priority = priority;
		this.dataProvider = dataProvider;
	}
	
	@Override
	public String id() {
		return id;
	}

	@Override
	public int priority() {
		return priority;
	}
	
	@Override
	public DataProvider dataProvider() {
		return dataProvider;
	}

}
