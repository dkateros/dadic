package gr.dkateros.dadic.impl.data;

import java.util.List;

/**
 * A basic two dimensional array implementation.
 * 
 * @param <R>
 * @param <C>
 * @param <V>
 * 
 * @author dkateros
 */
public class Table<R,C,V> {

	final List<R> rows;
	
	final List<C> columns;
	
	final V[][] data;
	
	public Table(List<R> rows, List<C> columns, V[][] data) {
		this.rows = rows;
		this.columns = columns;
		this.data = data;
	}
	
	public V get(R row, C column) {
		return data[rows.indexOf(row)][columns.indexOf(column)];
	}

}
