package gr.dkateros.dadic.impl.calc;

import java.util.Map;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.DataProvider;

/**
 * A {@link Calculation} that is backed by a one-dimensional data structure.
 * The index of the value is the result of another {@link Calculation} with
 * identifier {@link #index}.
 * 
 * @author dkateros
 */
public abstract class OneDimensionalArray extends AbstractCalculation {
	
	final String index;

	/**
	 * @param id
	 * @param priority
	 * @param dataProvider
	 * @param index
	 *        The identifier of the {@link Calculation} that defines the specific array index.
	 */
	public OneDimensionalArray(String id, int priority, DataProvider dataProvider, String index) {
		super(id, priority, dataProvider);
		this.index = index;
	}
	
	@Override
	public Object perform(Map<String, Object> context) {
		@SuppressWarnings("rawtypes")
		Map data = (Map) dataProvider().data(id());
		return data.get(context.get(index));
	}

}
