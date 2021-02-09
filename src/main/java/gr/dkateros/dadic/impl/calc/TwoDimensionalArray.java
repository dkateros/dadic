package gr.dkateros.dadic.impl.calc;

import java.util.Map;

import gr.dkateros.dadic.Calculation;
import gr.dkateros.dadic.DataProvider;
import gr.dkateros.dadic.impl.data.Table;

/**
 * A {@link Calculation} that is backed by a two-dimensional array.
 * The row and column indices are the result of two other {@link Calculation}s with
 * identifiers {@link #row} and {@link #column} respectively.
 * 
 * @author dkateros
 */
public class TwoDimensionalArray extends AbstractCalculation {
	
	final String row;
	final String column;

	/**
	 * @param id
	 * @param priority
	 * @param dataProvider
	 * @param row
	 *        The identifier of the {@link Calculation} that defines the specific array row.
	 * @param column
	 *        The identifier of the {@link Calculation} that defines the specific array column.
	 */
	public TwoDimensionalArray(String id, int priority, DataProvider dataProvider, String row, String column) {
		super(id, priority, dataProvider);
		this.row = row;
		this.column = column;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object perform(Map<String, Object> context) {
		Table table = (Table) dataProvider.data(id());
		return table.get(context.get(row), context.get(column));
	}

}
